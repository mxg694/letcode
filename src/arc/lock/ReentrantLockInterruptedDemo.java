package arc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 ReentrantLock的中断响应
 *
 * 流程分析
 *      线程 thread1 和 thread2 启动后，thread1 先占用 lock1，再占用 lock2；thread2
 *     反之，先占 lock2，后占 lock1。这便形成 thread1 和 thread2 之间的相互等待。
 *
 *     main 线程处于休眠（sleep）状态，两线程此时处于死锁的状态，
 *     thread2 被中断（interrupt），故 thread2 会放弃对 lock1 的申请，
 *     同时释放已获得的 lock2。这个操作导致 thread1 顺利获得 lock2，从而继续执行下去
 */
public class ReentrantLockInterruptedDemo  implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     * @param lock
     */
    public ReentrantLockInterruptedDemo(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(lock ==1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"，执行完毕！");
            }else  {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (Exception e) {
                }
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"，执行完毕！");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
             if(lock1.isHeldByCurrentThread()) {
                 lock1.unlock();
             }
             if (lock2.isHeldByCurrentThread()) {
                 lock2.unlock();
             }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String[] args) throws Exception{
        ReentrantLockInterruptedDemo r1 = new ReentrantLockInterruptedDemo(1);
        ReentrantLockInterruptedDemo r2 = new ReentrantLockInterruptedDemo(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(800);
        //中断一个线程
        t2.interrupt();
    }
}
