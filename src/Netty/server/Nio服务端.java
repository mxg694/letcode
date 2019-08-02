package Netty.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static java.lang.System.out;

public class Nio服务端 {
    //通道管理器
    private Selector selector;

    /**
     * 获得一个ServerSocket通道，并对该通道做一些初始化工作
     * @param port 绑定端口号
     * @throws Exception
     */
    public void initServer(int port) throws Exception{
        //获得一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //设置通道为非堵塞
        serverChannel.configureBlocking(false);
        //将该通道对应的serverSocket绑定到port端口
        serverChannel.socket().bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector = Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     *
     * @throws Exception
     */
    public void listen()throws Exception {
        out.println("服务端启动成功");
        while (true) {
            //当注册事件到达时，方法返回，否则，该方法会一直堵塞
            selector.select();
            //获得selector中的选中的项的迭代器，选中的项为注册事件
            Iterator<?> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey)ite.next();
                //删除已选的key，以防重复处理
                ite.remove();
                
                handler(key);
            }
        }
    }

    /**
     *  处理请求
     * @param key
     * @throws Exception
     */
    public void handler(SelectionKey key) throws Exception{
        //客户端请求连接事件
        if (key.isAcceptable()) {
            handleAccept(key);
            //获得了可读的事件
        }else if (key.isReadable()){
            handleRead(key);
        }

    }

    /**
     *   处理连接请求
     * @param key
     * @throws Exception
     */
    public void handleAccept(SelectionKey key) throws Exception {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        //获得和客户端连接的通道
        SocketChannel channel = server.accept();
        channel.configureBlocking(false);

        //给客户端发送信息
        out.println("新的客户端连接");

        channel.register(this.selector, SelectionKey.OP_READ);
    }


    /**
     * 处理读的事件
     *
     * @param key
     * @throws Exception
     */
    public void handleRead(SelectionKey key) throws Exception {
        //服务端可读取消息： 得到事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if (read>0) {
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            out.println("服务端受到消息：" + msg);

            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes());
            channel.write(outBuffer);
        }else  {
            out.println("客户端关闭");
            key.cancel();
        }

    }

    /**
     * 启动服务端测试
     *
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        Nio服务端 server = new Nio服务端();
        server.initServer(8000);
        server.listen();
    }
}
