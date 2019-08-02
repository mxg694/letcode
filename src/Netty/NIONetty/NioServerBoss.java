package Netty.NIONetty;

import Netty.NIONetty.pool.Boss;
import Netty.NIONetty.pool.NioSelectorRunnablePool;
import Netty.NIONetty.pool.Worker;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public class NioServerBoss extends AbstractNioSelector implements Boss {

    public NioServerBoss (Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool ) {
        super(executor, threadName, selectorRunnablePool);
    }

    @Override
    protected int select(Selector selector) throws Exception {
        return selector.select();
    }

    @Override
    protected void process(Selector selector) throws IOException {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        if (selectionKeys.isEmpty()) {
            return;
        }
        for (Iterator<SelectionKey> i = selectionKeys.iterator(); i.hasNext(); ) {
            SelectionKey key = i.next();
            i.remove();
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            //新客户端
            SocketChannel channel = server.accept();
            //设置为非阻塞
            channel.configureBlocking(false);
            //获取一个worker
            Worker nextWorker = getSelectorRunnablePool().nextWorker();
            //注册新客户端接入任务
            nextWorker.registerNewChannelTask(channel);

            System.out.println("新客户端连接");
        }
    }

    public void registerAcceptChannelTask(final ServerSocketChannel serverChannel){
        final Selector selector = this.selector;
        registerTask(new Runnable() {
            @Override
            public void run() {
                try {
                    //注册serverChannel到selector
                    serverChannel.register(selector, SelectionKey.OP_ACCEPT);
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
