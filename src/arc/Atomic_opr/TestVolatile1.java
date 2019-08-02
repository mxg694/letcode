package arc.Atomic_opr;

public class TestVolatile1 {

   boolean status = false;
  //    volatile boolean  status = false;
      static TestVolatile1 tv1 =  new TestVolatile1();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                tv1 .changeStatus();
                System.out.println(Thread.currentThread().getName()+ ":status:");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                tv1.run();
                System.out.println(Thread.currentThread().getName()+ ":run:");
            }
        }).start();
    }


    /*状态切换为true*/
    public void changeStatus() {
        status = true;
    }

    /*若状态为true，则running。*/
    public void  run() {
        if(status) {
            System.out.println("running ");
        }else  {
            System.out.println("no running");
        }
    }

}
