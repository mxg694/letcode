package Jvm;

import java.util.HashMap;

public class StoptheWorld {
    public static void main(String[] args) {
        new PrintThread().start();
    }
}

class  MyThread extends Thread {

    HashMap<Long, byte[]> map = new HashMap<>();
    @Override
    public void run() {
        try {
            while (true) {
                if (map.size()*512/1024/1024 >= 450) {
                    System.out.println("====准备清理"+map.size());
                    map.clear();
                }
                for (int  i=0; i<1024;i++) {
                    map.put(System.nanoTime(), new byte[512]);
                }
                Thread.sleep(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PrintThread extends Thread{
    public static final Long starttime = System.currentTimeMillis();

    @Override
    public void run() {
       try {
           while(true){
               long t=System.currentTimeMillis()-starttime;
               System.out.println("time:"+t);
               Thread.sleep(200);
           }

       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}

