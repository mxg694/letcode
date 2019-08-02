package Netty.NIONetty;

import Netty.NIONetty.pool.Boss;
import Netty.NIONetty.pool.NioSelectorRunnablePool;

import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * 服务类
 */
public class ServerBootstrap {

    private NioSelectorRunnablePool selectorRunnablePool;

    public ServerBootstrap(NioSelectorRunnablePool selectorRunnablePool) {
        this.selectorRunnablePool = selectorRunnablePool;
    }

    public void bind(final SocketAddress localAddress) {
        try {
            //获得一个ServerSocket通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            //设置通道非堵塞
            serverChannel.configureBlocking(false);
            //将该通道对应的serversocker绑定到port端口
            serverChannel.socket().bind(localAddress);

            //获取一个boss线程
            Boss nextBoss = selectorRunnablePool.nextBoss();
            //向boss注册一个serverSocket通道
            nextBoss.registerAcceptChannelTask(serverChannel);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
