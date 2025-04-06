# Stream API
## Stream을 이용하는 이유
- Collection이나 Array의 전 요소를 형변환하는 경우
- Collection이나 Array의 요소의 합게나 평균 등의 통계를 구하는 경우
- Collection이나 Array의 요소를 무언가의 조건으로 그룹화하는 경우
- Collection이나 Array에서 조건에 맞는 데이터를 검색하는 경우

## 배열 → 스트림 변환
#### 기본형(Primitive)
```java
IntStream stream = Arrays.stream(array);
```
#### 참조형(Reference)
```java
Stream<String> stream = Arrays.stream(array);
```

## Stream의 처리순서
- Stream의 처리순서는 Collection이 관리하는 순서로 처리된다.

## String형 요소를 다루는 list에서 병렬 스트림을 취득하는 코드
- 병렬 스트림 : 멀티스레드를 이용해 병럴처리를 사용하는 경우를 지원하기 위한 객체
```java
Stream<String> stream = list.parallelStream();
```

## 정렬
- sotred ('ed'주의)

## findAny와 findFirst
#### findFirst
- 스트림의 첫번째 요소를 반환한다 (최초에 '처리한' 요소가 아님)
- 항상 같은 요소를 반환한다는 보장(첫번째 요소)
#### findAny
- 항상 같은 요소를 반환한다는 보장이 없다
- 병렬처리 시에는 병렬로 처리되는 중에 어떤 한 값이 반환된다.

## reduce사용법
```java
// reduce 사용법
// 일련의 요소를 하나로 통합하는 스트림 조작
List<Integer> list = Arrays.asList(1,2,3,4,5);
// Optional로 받을게
Optional<Integer> result = list.stream().reduce((c, d) -> c + d);
result.ifPresent(System.out::println); // 15
// 값이 없다면 0으로 받을테니 일단 줘
Integer result2 = list.stream().reduce(0, (c, d) -> c + d);
System.out.println(result2);
```

## max는 String에도 적용된다
```java
// max 사용법
List<String> strList = Arrays.asList("A", "B", "C", "D");
// compare는 String클래스에도 있으며, String클래스에서의 max는 나중에오는 문자이다
Optional<String> strResult = strList.stream().max((e, f) -> e.compareTo(f));
strResult.ifPresent(System.out::println);    
```

## java.util.stream.Collector
Stream을 다룰 때 도중경과를 보존하는 오브젝트를 사용하고 싶을 때 java.util.stream.Collector를 사용한다.

