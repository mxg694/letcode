package Netty.序列化;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Nio序列化 {

    public static void main(String[] args) {
        int id = 101 ;
        int age = 21 ;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(id);
        buffer.putInt(age);

        byte[] array = buffer.array();
        System.out.println(Arrays.toString(array));

        //-----------------------------------------------------
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(array);
        System.out.println("id:"+byteBuffer2.getInt());
        System.out.println("age:"+byteBuffer2.getInt());
    }
}
