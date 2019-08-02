package arc.Atomic_opr;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过多线程 测试 AtomicInteger 是原子性的
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();   //结果  100000
    //static  int  i ;   //结果非原子性

    public static void main(String[] args) throws  Exception {
        Thread[] ts = new Thread[10];
        for (int k=0;k<10;k++) {
          ts[k] = new Thread(new AddThread());
        }

        for (int k=0; k<10; k++) {
            ts[k].start();
        }
        for (int k=0; k<10; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }


    static class  AddThread implements  Runnable {
        @Override
        public void run() {
            for (int k=0; k<10000; k++) {
                //i++;
                i.incrementAndGet();
            }
        }
    }

}
