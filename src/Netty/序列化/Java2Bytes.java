package Netty.序列化;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Java2Bytes {

    @Test
    public  void  testJava2Bytes() throws Exception {
        byte[] bytes = toBytes();
        toObject(bytes);
    }
    /**
     * 序列化
     */
    public static byte[] toBytes() throws Exception {
        Serialized res = new Serialized();
        res.setGold(123);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        //写入对象
        objectOutputStream.writeObject(res);
        //获取字节数组
        byte[] byteArray = outputStream.toByteArray();
        System.out.println(Arrays.toString(byteArray));
        return byteArray;
    }

    /**
     * 反序列化
     * @param bs
     * @throws Exception
     */
    public static void toObject(byte[] bs) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bs));
        Serialized res = (Serialized)inputStream.readObject();

        System.out.println("gold:" + res.getGold());

    }
}



