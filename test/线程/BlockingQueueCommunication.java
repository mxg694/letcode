package 线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 线程安全
 */
public class BlockingQueueCommunication {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread( new Runnable() {

            @Override
            public void run() {

                for(int i=1;i<=50;i++){
                    business.sub(i);
                }

            }
        }
        ).start();

        for(int i=1;i<=50;i++){
            business.main(i);
        }
    }

    static class Business {
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);

        {
            try {
                System.out.println("嘻嘻嘻嘻嘻嘻寻");
                queue2.put(1);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void  sub(int i) {
            try {
                queue1.put(1);
                System.out.println("sub queue1 put :" + queue1.size());
            }catch (Exception e)  {
                e.printStackTrace();
            }
       /*     for(int j=1;j<=10;j++){
                System.out.println("sub thread sequece of " + j + ",loop of " + i);
            }*/
            try {
                queue2.take();
                System.out.println("sub queu2 take :" + queue1.size());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public  void main(int i){
            try {
                queue2.put(1);
                System.out.println("main queue2 put :" + queue1.size());
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           /* for(int j=1;j<=100;j++){
                System.out.println("main thread sequece of " + j + ",loop of " + i);
            }*/
            try {
                queue1.take();
                System.out.println("main queu1 take :" + queue1.size());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
