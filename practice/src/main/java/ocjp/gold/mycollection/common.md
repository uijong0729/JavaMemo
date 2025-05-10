# 제네릭
## 형추론
- 형추론은 <> 연산자로 사용
- 제네릭의 형추론은 형이 명확한 경우에만 사용할 수 있다 (클래스에는 형추론 불가)
    - 변수에의 대입
    ```java
    List<String> list = new ArrayList<>();
    ```
    - 메소드의 반환값
    ```java
    public List<String> test() {
        return new ArrayList<>();
    }
    ```
    - 메소드 호출의 파라미터
    ```java
    public void execute(List<String> list) { }
    execute(new ArrayList<>());
    ```
