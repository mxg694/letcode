package 线程;

import java.util.concurrent.*;

public class CallableAndFeture {


    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> future =
            threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return "hello";
                };
            });
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果"+ future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool2);
        for (int i=0; i<10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(5000);
                    return seq;
                }
            });
        }
        for(int i=0;i<10;i++){
            try {
                System.out.println(
                        completionService.take().get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
