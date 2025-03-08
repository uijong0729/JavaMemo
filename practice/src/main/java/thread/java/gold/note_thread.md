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
// 2초 후 1초 마다 실행하는 쓰레드를 실행행
ScheduledExecutorService exec3 = Executors.newSingleThreadScheduledExecutor();
exec3.scheduleAtFixedRate(() -> {
    System.out.println("exec3");
}, 2, 1, TimeUnit.SECONDS);
```