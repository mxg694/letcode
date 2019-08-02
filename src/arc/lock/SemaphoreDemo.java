package arc.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试semaphore 的 acqure he release
 *  Semaphore 信号量
 *  	表示当前公共资源的可用数目
 * 	作用：
 * 		1、用于多个共享资源的互斥使用
 * 		2、用于并发线程数的控制
 */
public class SemaphoreDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println( Thread.currentThread().getName()+ ": done!");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println( Thread.currentThread().getName()+ ": RELEASE!");
            semp.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService es  = Executors.newFixedThreadPool(10);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i=0; i<20;i++) {
            es.submit(demo) ;
        }
    }
}
