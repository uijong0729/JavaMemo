## 어노테이션
#### 정의부분
```java
public class AnnotationTest {
    @AnnotationSample(test = "파리미터")
    public void test() {

    }
}
```
#### 사용부분
```java
// 컴파일 후에 남겨두고 싶지 않음
@Retention(RetentionPolicy.SOURCE)
// Target을 지정하지 않으면 모든 대상
@Target(ElementType.METHOD)
public @interface AnnotationSample {
    // 어노테이션 파라미터
    String test();
}

```