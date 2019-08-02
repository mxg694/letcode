package Netty.序列化;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class 自定义序列化 {

    public static void main(String[] args) throws Exception {
        int id = 101;
        int age = 21;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        arrayOutputStream.write(int2bytes(id));
        arrayOutputStream.write(int2bytes(age));  //写到流里面

        byte[] byteArray = arrayOutputStream.toByteArray();

        System.out.println(Arrays.toString(byteArray));
        //-----------------------------------------
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        byte[] idBytes = new byte[4];
        arrayInputStream.read(idBytes);  //写到数组里面
        System.out.println("id:" + bytes2int(idBytes));

        byte[] ageBytes = new byte[4];
        arrayInputStream.read(ageBytes);
        System.out.println("age:" + bytes2int(ageBytes));
    }

    /**
     * 大端字节序列(先写高位，再写低位)
     * 百度下 大小端字节序列
     * @param i
     * @return
     */
    public static byte[] int2bytes(int  i) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte)(i >> 3*8);
        bytes[1] = (byte)(i >> 2*8);
        bytes[2] = (byte)(i >> 1*8);
        bytes[3] = (byte)(i >> 0*8);
        return bytes;
    }
    /**
     * 大端
     * @param bytes
     * @return
     */
    public static int bytes2int(byte[] bytes){
        return (bytes[0] << 3*8) |
                (bytes[1] << 2*8) |
                (bytes[2] << 1*8) |
                (bytes[3] << 0*8);
    }
 }
