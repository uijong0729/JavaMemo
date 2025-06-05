package ocjp.gold.practice;

public class Sample extends TestA implements TestB {
    public static void main(String[] args) {
        // 실행결과 : B
        new Sample().exec();
    }
}

interface TestB {
    public default void exec() {
        System.out.println("A");
    }
}

abstract class TestA {
    public void exec() {
        System.out.println("B");
    }
}