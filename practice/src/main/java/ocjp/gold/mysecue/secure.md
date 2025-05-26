## 시큐어 코딩
#### 미국의 CERT가 정한 시큐어 코딩 프랙티스
- 시큐어 코딩 10원칙이 있지만 제1원칙으로 가장 중요시 여기는 것은 `입력을 검증한다(入力を検証する)`는 것이다
#### 유니코드 정규화
- java.text.Normalizer클래스의 normalize메소드
```java
public static void main(String[] args) {
    String de = "\u3066\u3099";
    System.out.println(de); // て?
    System.out.println(de.length()); // 2

    String result = Normalizer.normalize(de, Form.NFKC);
    System.out.println(result); // で
    System.out.println(result.length()); // 1
}
```
