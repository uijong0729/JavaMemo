# 3.병렬처리
## Thread
- Thread에서 run을 직접 호출하면 새 쓰레드가 아닌, run을 호출한 기존 쓰레드에서 실행되기 때문에 start를 사용해야한다.
```java
Thread t = new Thread() {
    @Override
    public synchronized void start() {
        super.start();
        System.out.print("start ");
    }

    @Override
    public void run() {
        super.run();
        System.out.print("run ");
    };
};
// 결과 : run
t.run();
System.out.println("");

// 결과 : start run
t.start();
```
- 미리 몇 개의 쓰레드를 만들어 Pool해두고 시간이 경과함에 따라 불필요한 쓰레드를 삭제하는 ExecutorService를 가져오는 Executors클래스의 메소드는 newCachedThreadPool메소드
```java
ExecutorService exec = Executors.newCachedThreadPool();
for (int i = 0; i < 5; i++) {
    exec.submit(() -> {
        System.out.println(Thread.currentThread().getId());
    });
}
```
- 쓰레드 지연실행 Scheduled
```java
// 1초 후에 실행하는 쓰레드
ScheduledExecutorService exec2 = Executors.newSingleThreadScheduledExecutor();
exec2.schedule(() -> {
    System.out.println("schedule");
    exec2.shutdown();
}, 1, TimeUnit.SECONDS);
```
- 쓰레드 지연후 반복실행
```java
// 2초 후 1초 마다 실행하는 쓰레드를 실행 지정 반복
// 완전히 고정된 간격이므로 시간보다 처리가 길어지면 작업들이 서로 병렬적으로 실행됨
ScheduledExecutorService exec3 = Executors.newSingleThreadScheduledExecutor();
exec3.scheduleAtFixedRate(() -> {
    System.out.println("exec3");
}, 2, 1, TimeUnit.SECONDS);

// 2초 후 1초 마다 실행하는 쓰레드를 실행
// 시간보다 처리가 길어지면 작업의 완료까지 기다린 뒤 실행
ScheduledExecutorService exec4 = Executors.newSingleThreadScheduledExecutor();
exec4.scheduleWithFixedDelay(() -> {
    System.out.println("scheduleWithFixedDelay");
}, 2000, 1000, TimeUnit.SECONDS);
```
- Callable을 get했을때 처리에 예외가 발생하는 경우, 예외를 Catch하려면 ExecutionException으로 Catch해야한다.
- CyclicBarrier :여러개의 스레드의 종료를 기다려 동기화하는 처리를 구현
```java
// Task.java
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

// Main.java
public class Main {

    public static void main(String[] args) {
        // CyclicBarrier
        // 3개의 쓰레드가 처리를 종료하면 Runnable정의된 처리를 실행
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                try {
                    Thread.sleep(new Random().nextInt(5) * 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("done");
            }
        };
        CyclicBarrier cBarrier = new CyclicBarrier(3, () -> {
            System.out.println("complete");
        });
        ExecutorService exec5 = Executors.newFixedThreadPool(3);
        exec5.submit(new Task(cBarrier, runnable));
        exec5.submit(new Task(cBarrier, runnable));
        exec5.submit(new Task(cBarrier, runnable));

        // =========출력결과============
        // run
        // run
        // run
        // done
        // done
        // done
        // complete
    }
}
```
- ReentrantLock : 여러 메소드에 걸쳐 배타제어하는 방법
```java
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
```