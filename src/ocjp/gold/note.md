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
