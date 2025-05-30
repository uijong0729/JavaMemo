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
#### 시큐리티 매니저
- 실행 시에 시큐리티 폴리시를 설정해두면 허가한 동작만 수행하도록 할 수 있다
- 방법1 : -D옵션을 지정해서 실행하기
```shell
java -Djava.security.manager Sample
```
- 방법2 : SecurityManager 인스턴스
```java
System.setSecuiryManager(new SecurityManager());
```
#### 시큐리티 폴리시 파일(.policy)
- 특정 코드나 jar파일만 시큐리티 폴리시를 적용시키는 방법
- sample.policy파일에 lib.jar파일이 루트 디렉토리에의 읽기접근을 허가하는 샘플
```java
grant codeBase "file:/Users/eui/workspace/lib.jar" {
    permission java.io.FilePermission "/", "read"
};
```
#### 가변(可変) 오브젝트의 취급 주의점
- getter메소드에서 필드의 참조를 그대로 반환하지 않고 카피본을 만들어 반환한다 **(참조를 그대로 반환하면 필드가 private더라도 액세스 메소드를 제공한다면 실질적으로 public 필드와 차이 없음)**
```java
public Date getDate() {
    return (Date) this.date.clone();
}
```
- 인수로 받은 오브젝트를 그대로 대입하지 않는다
```java
public TestCalendar(Date date) {
    this.date = new Date(date.getTime());
}
```
- 카피 생성자 : 신뢰성있는 가변 오브젝트를 만드는 수단
```java
public class TestCalendar {
    private Date date;
    
    public TestCalendar(Date date) {
        this.date = new Date(date.getTime());
    }
    // 카피 생성자
    public TestCalendar(TestCalendar input) {
        this.date = new Date(input.date.getTime());
    }
}
```
#### 그 외 시큐어 코딩 실천
- 패키지 안에서 공개하는 인터페이스를 제한한다
- 모듈을 사용해 공개할 패지키를 제한한다
- 클래스를 선언할 때 악의적인 오버라이딩을 막기위해 final 수식어를 사용한다
- SQL인젝션을 막기위한 인터페이스
```java
// java.sql.PreparedStatement
String sql = "SELECT * FROM test WHERE name = ?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, name);
ResultSet rs = ps.executeQuery();
```
- 기밀정보를 다루는 인스턴스를 직렬화 할 때는 transient
```java
public class Human implements Serializable {
    // 직렬화 대상
    private String name;
    // 직렬화 제외
    private transient String telephone;
}
```
#### 직렬화-프록시 패턴
- 객체를 직렬화 할 때 본체 클래스가 아닌, 별도의 프록시 클래스를 이용해 직렬화를 수행하는 패턴
- 직렬화 : writeReplace
- 역직렬화 : readResolve
#### volatile
- 멀티스레드 환경에서 필드의 캐쉬를 제어해서 퍼포먼스를 향상시키는 예약어
- 변수를 메인 메모리에 저장하고 읽어오기 때문에 변수 값 불일치 문제를 해결할 수 있다 (항상 최신의 값을 보장)