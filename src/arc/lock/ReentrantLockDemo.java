package arc.lock;

import java.util.concurrent.locks.ReentrantLock;

/*ReentrantLock  的加锁   作用等同  synchronized */
public class ReentrantLockDemo implements  Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i=0;

    @Override
    public void run() {
        for(int j=0; j<10000; j++){
         //   lock.lock();   //加锁  保证线程安全
            try {
                i++;
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
         //       lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws  InterruptedException {
        ReentrantLockDemo rt1 = new ReentrantLockDemo();
        Thread t1 =new Thread(rt1);
        Thread t2 = new Thread(rt1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i:"+i);
    }

}
