package 线程;

public class TraditionalThread {

    public static void main(String[] args) {
        //直接 new Thread
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("1："+ Thread.currentThread().getName());
                    System.out.println("2："+ this.getName());
                }
            }
        };
        thread.start();

        //使用Runnable 接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());

                }
            }
        });

        thread1.start();
    }




}
