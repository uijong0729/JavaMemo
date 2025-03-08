package thread.java.gold;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // 기본적인 쓰레드
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

        //=======================================
        // CachedThreadPool
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.submit(() -> {
                System.out.println(Thread.currentThread().getId());
            });
        }

        //=======================================
        // 1초 후에 실행하는 쓰레드
        ScheduledExecutorService exec2 = Executors.newSingleThreadScheduledExecutor();
        exec2.schedule(() -> {
            System.out.println("schedule");
            exec2.shutdown();
        }, 1, TimeUnit.SECONDS);

        // 2초 후 1초 마다 실행하는 쓰레드를 실행행
        ScheduledExecutorService exec3 = Executors.newSingleThreadScheduledExecutor();
        exec3.scheduleAtFixedRate(() -> {
            System.out.println("exec3");
        }, 2, 1, TimeUnit.SECONDS);
    }
}