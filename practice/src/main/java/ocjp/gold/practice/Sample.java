package ocjp.gold.practice;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample extends TestA implements TestB {
    public static void main(String[] args) {
        // 실행결과 : B
        new Sample().exec();
        
        // 결과 : a/d
        Path p = Paths.get("a/b/c/../../d");
        System.out.println(p.normalize());
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