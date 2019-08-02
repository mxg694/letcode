package arc.Atomic_opr;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray  arr = new AtomicIntegerArray(10);

    static class  AddThread implements  Runnable {
        @Override
        public void run() {
            for (int k=0;k<100000; k++) {
                arr.getAndIncrement(k%arr.length());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] ts = new Thread[10];
        for (int i=0; i<10; i++) {
            ts[i] =new Thread(new AddThread());
        }

        for (int i=0; i<10;i++) {
            ts[i].start();
        }

        for (int i=0; i<10; i++) {
            ts[i].join();
        }
        System.out.println(arr);
    }


}
