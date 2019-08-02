package Netty.序列化;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.junit.Test;

import java.util.Arrays;

import static java.lang.System.out;

public class Netty序列化 {

    @Test
    public void Netty序列化() {

        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(101);
        buffer.writeDouble(80.1);

        byte[] bytes = new byte[buffer.writerIndex()];
        buffer.readBytes(bytes);
        out.println(Arrays.toString(bytes));

        //---------------------------------------------
        ChannelBuffer wrappedBuffer = ChannelBuffers.wrappedBuffer(bytes);
        out.println(wrappedBuffer.readInt());
        out.println(wrappedBuffer.readDouble());

    }
}
