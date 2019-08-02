package arc.lock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 锁申请等待限时
 *
 *
 */
public class ReentrantLockTryLockDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            }else {
                System.out.println(Thread.currentThread().getName()+  ": get lock is Failed");
            }
        }catch (Exception e) {
           e.printStackTrace();
        }finally {
            //查询当前线程是否保持此锁
            if (lock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName()+" release lock");
                lock.unlock();
            }
        }
    }

    /**
     * 在本例中，由于占用锁的线程会持有锁长达6s，所以另一个线程无法在5s的等待时间获得锁，
     * 因此请求锁会失败
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ReentrantLockTryLockDemo rt = new ReentrantLockTryLockDemo();
        Thread t1 = new Thread(rt,"线程1");
        Thread t2 = new Thread(rt,"线程2");
        t1.start();
    //    Thread.sleep(1500);
        t2.start();
    }
}
