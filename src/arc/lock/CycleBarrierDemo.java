package arc.lock;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 回环栅栏
 */
public class CycleBarrierDemo {

    public  static class Solider implements Runnable {
        private  String solider;
        private  final CyclicBarrier cyclic;

        Solider(CyclicBarrier cyclic, String name) {
            this.cyclic = cyclic;
            solider = name;
        }

        @Override
        public void run() {
            try {
                report();
                //等待所有士兵到齐
                cyclic.await();
                doWork();
                cyclic.await();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        void report()  throws  Exception{
            Thread.sleep(Math.abs(new Random().nextInt()%10000));
            System.out.println(solider +"报道");
        }

        void doWork() throws  Exception{
            Thread.sleep(Math.abs(new Random().nextInt()%10000));
            System.out.println(solider +": 任务完成" );

        }

    }

    public static class BarrierRun implements Runnable {
        boolean flag  ;
        int N;
        public BarrierRun( boolean flag, int N ) {
            this.flag = flag;
            this.N = N;
        }
         @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵"+N+"个任务完成]");
            }else  {
                System.out.println("司令：[士兵"+N+"个集合完毕]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final  int n = 10;
        Thread[] allSolider = new Thread[n];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(flag,n));
        //设置屏障点，主要为了执行这个方法
        System.out.println("集合队伍！");
        for (int i=0; i<n; i++) {

            allSolider[i] = new Thread(new Solider(cyclic, "士兵"+i));
            allSolider[i].start();
//            if (i ==5 ) {
//                allSolider[0].interrupt();
//            }
        }
    }
}
