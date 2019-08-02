package arc.Atomic_opr;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

    public static void main(String[] args) {
        //模拟多个线程同时更新后台数据库，为用户充值
        /*for (int i=0; i<3 ;i ++ ) {
            final  int timestamp = money.getStamp();
            new Thread(){
                public void  run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if(m < 20) {
                                if (money.compareAndSet(m,m+20,timestamp, timestamp+1)){
                                    System.out.println("余额小于20元，充值成功，余额:"+money.getReference()+"元");
                                    break;
                                }
                            }else  {
                                System.out.println("余额大于20元，余额："+money.getReference()+"元" );
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
        //模拟消费线程
        new Thread() {
            @Override
            public void run() {
                for (int i=0; i<100; i++) {
                    while (true) {
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if(m >10) {
                            if(money.compareAndSet(m,m-10,timestamp,timestamp+1)) {
                                System.out.println("成功消费10元，余额："+money.getReference());
                                break;
                            }
                        }else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(10);
                    }catch (Exception e) {

                    }
                }
            }
        }.start();*/


        test01();
    }


    public static void  test01( ) {
        AtomicStampedReference<Integer> at = new AtomicStampedReference(19,0);


        at.compareAndSet(19,20, 0,1);
        System.out.println("Value:"+at.getReference());
        System.out.println("Stamp:"+at.getStamp()  );


    }
}
