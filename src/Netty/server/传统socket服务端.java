package Netty.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 传统socket服务端 {

    public static void main(String[] args) throws Exception{

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        //创建socket服务
        ServerSocket server = new ServerSocket(10101);
        System.out.println("服务器启动！");

        while (true) {
            final Socket socket = server.accept();
            System.out.println("来一个新的客户端");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //处理业务
                    handler(socket);
                }
            });

        }

    }

    /**
     * 读取数据
     * @param socket
     */
    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                //读取数据（堵塞）
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("socket关闭");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
