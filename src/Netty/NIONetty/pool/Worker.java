package Netty.NIONetty.pool;

import java.nio.channels.SocketChannel;

/**
 * worker 接口
 */
public interface Worker {

    public void registerNewChannelTask(SocketChannel channel);

}
