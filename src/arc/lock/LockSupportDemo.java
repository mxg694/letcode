package arc.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport比Object的wait/notify有两大优势：
 *
 * ①LockSupport不需要在同步代码块里 。所以线程间也不需要维护一个共享的同步对象了，实现了线程间的解耦。
 *
 * ②unpark函数可以先于park调用，所以不需要担心线程间的执行的先后顺序。
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");


    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
           synchronized (u) {
               System.out.println("in" +getName());
               LockSupport.park();
           }
        }
    }

    public static void main(String[] args) throws Exception {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
