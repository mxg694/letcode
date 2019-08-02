package Netty.NIONetty;

import Netty.NIONetty.pool.NioSelectorRunnablePool;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 抽象selector 线程类
 */
public abstract class AbstractNioSelector implements Runnable {

    /**
     * 线程池
     */
    private final Executor executor;

    /**
     * 选择器
     */
    protected Selector selector;

    /**
     * 选择器wakeUp 状态标记
     */
    protected final AtomicBoolean wakeUp = new AtomicBoolean();

    /**
     * 任务队列
     */
    private final Queue<Runnable> taskQueue = new ConcurrentLinkedDeque<>();

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * 线程管理对象
     */
    private NioSelectorRunnablePool selectorRunnablePool;

    AbstractNioSelector(Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool) {
        this.executor = executor;
        this.threadName = threadName;
        this.selectorRunnablePool = selectorRunnablePool;
        openSelector();
    }

    /**
     * 获取selector 并启动线程
     */
    private void openSelector() {
        try {
            this.selector = Selector.open();
        }catch (Exception e) {
            e.printStackTrace();
        }
        executor.execute(this);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.threadName);
        while (true) {
            try {
                wakeUp.set(false);
                select(selector);

                processTaskQueue();
                process(selector);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注册一个任务并激活selector
     * @param task
     */
    protected final void registerTask(Runnable task) {
        taskQueue.add(task);
        Selector selector = this.selector;
        if (selector !=null) {
            if(wakeUp.compareAndSet(false,true)) {
                selector.wakeup();
            }
        }else {
            taskQueue.remove(task);
        }
    }

    /**
     * 执行队列里的任务
     */
    private void processTaskQueue() {
        for (;;){
            final Runnable task = taskQueue.poll();
            if (task == null) {
                break;
            }
            task.run();
        }
    }

    /**
     * 获取线程管理对象
     * @return
     */
    public NioSelectorRunnablePool getSelectorRunnablePool() {
        return selectorRunnablePool;
    }

    /**
     * select 抽象方法
     * @param selector
     * @return
     * @throws Exception
     */
    protected abstract int select(Selector selector) throws Exception;

    /**
     * selector的业务处理
     *
     * @param selector
     * @throws IOException
     */
    protected abstract void process(Selector selector) throws IOException;
}
