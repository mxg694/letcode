package Netty.NIONetty.pool;

import java.nio.channels.ServerSocketChannel;

/**
 * boss 接口
 */
public interface Boss {
    /**
     * 加入一个新的 ServerSocket
     * @param serverChanel
     */
    public void registerAcceptChannelTask(ServerSocketChannel serverChanel);
}
