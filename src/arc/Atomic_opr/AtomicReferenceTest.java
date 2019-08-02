package arc.Atomic_opr;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
        final static AtomicReference<String> atomicStr =
                new AtomicReference<String>("abc");

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            final int  num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int)Math.random()*100));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    if(atomicStr.compareAndSet("abd","def")) {
                        System.out.println("Thread:"+Thread.currentThread().getName()+"Change VAlue to def");
                    }else {
                        System.out.println("Thread:"+Thread.currentThread().getName()+"Failed");

                    }

                }
            }).start();
        }
    }


}
