package ocjp.gold.mythread;

import java.util.concurrent.locks.ReentrantLock;

public class LockedRunner {
    ReentrantLock reentrantLock = new ReentrantLock();
    Runnable runnable;

    public LockedRunner(Runnable runnable) {
        this.runnable = runnable;
    }

    public void run() {
        lock();
        runnable.run();
        unlock();
    }

    private void lock() {
        reentrantLock.lock();
    }

    private void unlock() {
        if (reentrantLock.isLocked()) {
            reentrantLock.unlock();
        }
    }
}
