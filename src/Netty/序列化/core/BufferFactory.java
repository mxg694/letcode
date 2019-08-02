package Netty.序列化.core;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.nio.ByteOrder;

public class BufferFactory {

    public static ByteOrder BYTE_ORDER = ByteOrder.BIG_ENDIAN;

    /**
     * 获取一个buffer
     *
     */
    public static ChannelBuffer getBuffer() {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        return buffer;
    }

    /**
     * 将数据写入buffer
     * @param bytes
     * @return
     */
    public static ChannelBuffer getBuffer(byte[] bytes) {
        ChannelBuffer copiedBuffer = ChannelBuffers.copiedBuffer(bytes);
        return copiedBuffer;
    }



}
