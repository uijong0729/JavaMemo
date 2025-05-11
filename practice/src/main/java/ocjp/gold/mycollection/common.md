# 제네릭
### 형추론
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
### 非境界ワイルドカード(Unbounded Wildcards)
- 한국어로 비경계 와일드카드 보통 T를 쓴다
```java
static class Test<T> {
    T value;
    Test(T value) {
        super();
        this.value = value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
```
- 파라미터가 `?` 뿐인 제네릭형
- 예시 : `List<?>`
- 반환 : 와일드카드를 사용한 메소드의 반환치의 형태는 Object형이다
```java
// T형 메소드 반환형은 Object형이다
Object msg2 = test.getValue();
// cast해서 사용하면 된다
String msg = (String) test.getValue();

```
- 인수 : T형 인수에 유일하게 넣을수 있는 인수는 null 리터럴값
```java
public static void main(String[] args) {
    Test<?> test = new Test<>("HELLO");
    // T형 인수에 유일하게 대입가능한 값은 null 리터럴
    test.setValue(null);
    //test.setValue(1);
    //test.setValue("str");
}
```

### 上限境界ワイルドカード (상한 경계 와일드카드)
```java
List<? extends Number> list = new ArrayList<Integer>();
// List<? extends Number> 타입으로 선언된 리스트에는 null 외에는 어떤 타입의 객체도 안전하게 추가할 수 없습니다.
list.add(null);
```

### PECS(Producer Extends, Consumer Super) 원리
- 생산 메소드 : `? extends T`
    - 상한경계 와일드 카드
    - 값을 꺼내올 때는 최소한 T타입은 보장하는 T의 하위타입
    - Number 또는 Number의 자식 클래스 타입의 요소만 처리하는 메서드
    ```java
    public static double sumOfList(List<? extends Number> list);
    ```
- 소비 메소드 : `? super T`
    - 하한경계 와일드 카드
    - T타입이거나 T의 상위타입의 객체를 안전하게 인수로 받음
    - Integer 또는 Integer의 부모 클래스 타입의 리스트에 Integer 객체를 추가하는 메서드
    ```java
    public static void addIntegersToList(List<? super Integer> list);
    ```

# 컬렉션 
### java.util.Deque
- 양 끝단에서 요소를 삽입/삭제할 수 있는 데이터 구조
### Map오브젝트 요소 출력하기
```java
Map<Integer, String> map = Map.ofEntries(
    Map.entry(1, "A"),
    Map.entry(2, "B"),
    Map.entry(3, "C")
);

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ":" + entry.getValue());
}
```
### Comparable
- 자기가 비교대상보다 앞에 위치하도록 정렬하려면 음수를 반환
- 자기가 비교대상보다 뒤에 위치하도록 정렬하려면 양수를 반환
- 동일 값이면 0을 반환