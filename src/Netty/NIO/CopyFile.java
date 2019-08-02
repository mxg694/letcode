package Netty.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

    public static void copyFileUseNIO(String src,String dest) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi = new FileInputStream(new File(src));
        FileOutputStream fo = new FileOutputStream(new File(dest));
        /* 获得传输通道channel */
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            //重设一下buffer的position = 0, limit = position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完需要重置 buffer，重设position = 0， limit = capacity
            buffer.clear();

        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();

    }

}
