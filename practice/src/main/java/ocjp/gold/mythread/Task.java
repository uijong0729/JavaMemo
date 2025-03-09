package ocjp.gold.mythread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private CyclicBarrier barrier;
    private Runnable runnable;

    public Task(CyclicBarrier barrier, Runnable runnable) {
        this.barrier = barrier;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
        try {
            barrier.await(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
