# ※자바11기준
## 클래스와 인터페이스
## Inner Class
- inner class는 public접근자 지정이 불가능
```java
public class Outer
    class Inner {
       private String message; 
    } 
}
```
- inner class에 static필드를 보유하고 싶으면 클래스를 static class로 선언해야한다
```java
public class Outer
    static class Inner {
       private static String message; 
    } 
}
```
- inner static class에서 outer측의 필드는 인스턴스를 생성해 접근하거나 static필드만 접근할수 있다
```java
public class Outer {
    private int num = 2;
    private static class Sinner {
        void execute() {
            // NG : Cannot make a static reference to the non-static field num
            // System.out.println(num);
            
            // OK
            System.out.println(new Outer().num);
        }
    }
}
```
## Interface
- 8버전부터 static method를 허용
default method와는 달리 Override할 수 없다
```java
public interface Vehicle {
    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}
```
- default method의 다중상속문제(Diamond Problem)에선 어떤 메소드를 호출할지 명시해야한다.
```java
interface A {
    default void test() {}
}
interface B {
    default void test() {}
}
public class Sample implements A, B {
    @Override
    public void test() {
        // 명시하지 않으면 컴파일 에러
        A.super.test();
        B.super.test();
    }
}
```
- default method와 정의명과 super클래스의 method의 정의명이 겹치면 super class의 method가 호출된다.
```java
// ---A.java
interface A {
    default void test() {
        System.out.println("a");
    }
}
// ---B.java
class B {
    public void test() {
        System.out.println("b");
    }
}
// ---C.java
class C extends B implements A {}
// ---Main.java
public class Main {
    public static void main(String[] args) {
        A a = new C();
        // 출력값 : b
        a.test();
    }
}
```
- 인터페이스의 private method는 버전9부터 가능해졌다.
```java
public interface Sample {
    default void a() {
        b();
    }
    private void b() {
        System.out.println("b");
    }
}
```
## Enum
- 열거형의 특정 값 취득
```java
// --- Test.java
public enum Test {
    A, B, C
}
// --- Main.java
public class Main {
    public static void main(String[] args) {
        // A : 배열에서 n번째 요소 지정
        System.out.println(Test.values()[0]);
        // A : 열거형 상수 이름을 문자열로 지정
        System.out.println(Test.valueOf("A"));
    }
}
```
- enum의 각 열거형 상수는 인스턴스가 생성된다.
```java
enum Sample {
    A("hello"), B("hello"), C("hello")
    private final String value;
    private Sample(String value) {
        System.out.println(value);
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}

public class Main {
    public static void main(String[] args) {
        // 각 열거형 상수는 인스턴스화 되어 
        // "hello"가 4번 출력된다
        System.out.println(Sample.A);
    }
}
```
## 람다와 함수형 인터페이스
- Supplier는 인수를 받지않고 get으로 값을 받는다(공급 전문)
```java
Supplier<String> supplier = () -> "test";
System.out.println(supplier.get());
```
- Consumer는 인수를 하나만 받지만 BiConsumer는 인수를 두개로 받는다
```java
BiConsumer<Integer, Integer> test = (a, b) -> System.out.println(a + b);
```
- Predicate 활용 (메소드는 test)
```java
public static void main(String[] args) {
    Predicate<Integer> p1 = x -> x > 0;
    Predicate<Integer> p2 = x -> x < 100;
    // true => (p1 or p2).test
    System.out.println(p1.or(p2).test(100));      
}
```
- Function는 apply, compose, andThen 메소드 보유 (before, after라는 메소드는 없다)
```java
public static void main(String[] args) {
    Function<Integer, Integer> f1 = x -> x + 2;
    Function<Integer, Integer> f2 = x -> x * 2;
    // (10+2)*2 = 24
    System.out.println(f1.andThen(f2).apply(10));
    // (10*2)+2 = 22
    System.out.println(f1.compose(f2).apply(10));
}
```
- UnaryOperator (단항 연산자)
    - Function을 계승하므로 추상 메소드는 apply
        ```java
        UnaryOperator<Integer> func = i -> ++i;
        ```
    - UnaryOperator와 replaceAll 응용
        ```java
        list.replaceAll(x -> x.toUpperCase());
        ```
    - BynaryOperator
        ```java
        BinaryOperator<String> bo = (a, b) -> a + b;
        // test
        System.out.println(bo.apply("te", "st"));
        ```
