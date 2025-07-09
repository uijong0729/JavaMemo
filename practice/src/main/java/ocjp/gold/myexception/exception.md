## Exception
#### 독자적으로 예외 클래스를 작성할 때
- java.lang.Exception 클래스의 서브클래스여야 한다

## 예외와 에러
#### java.lang.Throwable
- 모든 에러와 예외의 슈퍼클래스
#### java.lang.Error
- 에러 클래스
#### java.lang.Exception
- 예외 클래스
- 비검사예외와 검사예외 : RuntimeException은 비검사예외, 그 외는 검사예외에 해당한다

## try-resource
- try()안의 리소스는 나중에 들어간 변수가 먼저 close된다.
```java
public class ExceptionSample {
    // 실행결과 : mainCBA
    public static void main(String[] args) {
        A a = new A("A");
        try (a;
         A b = new A("B");
         A c = new A("C")) {
            // 실행결과 : mainCBA
            System.err.print("main");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

class A implements AutoCloseable {
    String msg;
    A(String msg) {
        this.msg = msg;
    }
    @Override
    public void close() throws Exception {
        System.out.print(msg);
    }
}
```
- try()안의 리소스는 선언과 초기화가 모두 이뤄져야한다.
```java
    public static void main(String[] args) {
        // 안되는 케이스
        A a;
        try (a = new A("A")) {
            System.err.print("main");
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 되는 케이스 1
        A a = new A("A");zm
        try (a) {
            System.err.print("main");
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 되는 케이스 2
        try (A a = new A("A")) {
            System.err.print("main");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
```
- try-resource문에서 예외가 발생했을 때 try, catch, finally 순서
1. 예외가 발생할 실행문
2. close
3. catch
4. finally

## assert
- 어센션을 유효화하는 커맨드
```
java -ea Sample
```