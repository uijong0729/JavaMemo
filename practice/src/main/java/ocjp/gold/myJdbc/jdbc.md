# JDBC
## JDBC개요
- java.sql/javax.sql : 어떤 DBMS제품에 사용해도 같은 방법으로 이용할 수 있도록 인터페이스, 예외 클래스, 공통 부품을 제공
- JDBC Driver : DBMS제품에 맞게 인터페이스를 구현한 일반 클래스
## JDBC접속
- DriverManager
    - JDBC를 사용해서 데이터베이스와 접속하는 클래스
    - `getConnection` : JDBC로 데이터베이스와 접속하는 메소드
## JDBC해제
- `Connection.close()` : JDBC의 접속을 해제하는 메소드
## JDBC인터페이스
#### java.sql.Statement
- 파라미터를 받지않는 SQL을 실행하기위한 인터페이스
#### java.sql.PreparedStatement
- 파라미터를 받는 SQL을 실행하기위한 인터페이스
- 파라미터 설정하는법
```java
var sql = "insert into(num,name) ITEM values(?,?)";
try (PreparedStatement ps = con.prepareStatement(sql)) {
    ps.setInt(1, 2); // 첫번째 파라미터
    ps.setString(2, "sample"); // 두번째 파라미터
    ps.executeUpdate();
}
```
- 파라미터를 설정하지 않고 execute메소드를 호출하면 런타임 예외(SQLException)가 발생한다. 
- SQL실행 메소드 종류
    - execute() : 반환형은 boolean 실행문이 update/delete/insert 인 경우 false, select인 경우 true
        - executeUpdate() : insert, update, delete문에 사용된다. 반환형은 int
        - executeQuery() : select문에 사용된다. 반환형은 ResultSet
        - executeBatch()
            - 한번에 복수의 SQL문을 실행하기위한 메소드
            - 반환형은 int[]
            - addBatch를 여러 번 호출해 여러 개의 PreparedStatement를 추가 할 수 있다
- **ResultSet** : `executeQuery`(select문)의 반환형
```java
try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/data/Sample")){
    var sql = "select * from item";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        // next를 한번도 호출하지 않으면 런타임 예외
        while(rs.next()){
            // 열 번호(1부터)로 취득
            System.out.print(rs.getInt(1));
            System.out.print(rs.getString(2));
            // 열 이름으로 취득
            System.out.print(rs.getInt("age"));
            System.out.print(rs.getString("name"));
        }
    }
}

```
## 스토어드 프로시저(Stored Procedure)
데이터베이스에 저장된 SQL 문장들의 집합으로, 특정 작업을 수행하는 프로그램(함수)처럼 실행할 수 있는 객체
```java
try (var cs = con.prepareCall("call sample_proc(?. ?)")) {
    cs.setString(1, "test");
    cs.setInt(2, 1);
    cs.execute();
}
```

