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
