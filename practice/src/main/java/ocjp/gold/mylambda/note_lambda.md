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