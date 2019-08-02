package arc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  代码目的： ReentrantLock  测试锁的可重入性
 *
 *
 */
public class ReentrantLockDemo2 implements  Runnable{
    public static ReentrantLock lock  = new ReentrantLock();
    public static int i= 0;

    @Override
    public void run() {
        for (int j=0; j<10000; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                 lock.unlock();
                 lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws  InterruptedException{
        ReentrantLockDemo2 rt2 = new ReentrantLockDemo2();
        Thread t1 = new Thread(rt2);
        Thread t2 = new Thread(rt2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i="+i);
    }
}
