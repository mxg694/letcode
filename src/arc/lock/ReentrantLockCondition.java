package arc.lock;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** 目的：测试ReentrantLock 的 condition  类的  await()和signal
 *
 */
public class ReentrantLockCondition implements Runnable  {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();  //
            System.out.println("Thread is going on");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws  Exception {
        ReentrantLockCondition rtc = new ReentrantLockCondition();
        Thread t1 = new Thread(rtc);
        t1.start();
        System.out.println(new Date().getSeconds());
        Thread.sleep(8000);
        //通知线程t1 继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
        System.out.println(new Date().getSeconds());
    }
}
