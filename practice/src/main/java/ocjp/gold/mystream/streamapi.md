# Stream API
## Stream을 이용하는 이유
- Collection이나 Array의 전 요소를 **형 변환**하는 경우
```java
// map메소드를 이용해 String을 Integer로
List<String> list = Arrays.asList("1", "2", "3");
List<Integer> intList = list.stream()
    .map(Integer::parseInt)
    .collect(Collectors.toList());
```
- Collection이나 Array의 요소의 **합게나 평균** 등의 통계를 구하는 경우
```java
// sum, average합계와 평균
// 통계 메소드를 사용하려면 기본형 스트림이어야 하기에 mapToInt가 필요하다
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
int sum = nums.stream().mapToInt(i -> i).sum();
double avg = nums.stream().mapToInt(i -> i).average().orElse(0);

```
- Collection이나 Array의 요소를 무언가의 조건으로 **그룹화**하는 경우
- Collection이나 Array에서 조건에 맞는 데이터를 **검색**하는 경우

## 배열 → 스트림 변환 : Arrays.stream
#### 기본형(Primitive)
```java
// 기본형 스트림
IntStream stream = Arrays.stream(array);
```
#### 참조형(Reference)
```java
// 제네릭 이용
Stream<String> stream = Arrays.stream(array);
```

## Stream의 처리순서
- Stream의 처리순서는 Collection이 관리하는 순서로 처리된다.

## String형 요소를 다루는 list에서 병렬 스트림을 취득하는 코드
- 병렬 스트림 : 멀티스레드를 이용해 병럴처리를 사용하는 경우를 지원하기 위한 객체
- parallelStream의 처리순서를 유지하고 싶다면 forEach가 아니라 `forEachOrdered` 메소드를 사용해야 한다.
```java
Stream<String> stream = list.parallelStream();
```

## 정렬
- **sorted** ('ed'주의)
- sorted는 Stream과 IntStream양쪽에 어느 쪽이든 갖고있다
```java
List<Integer> nums = Arrays.asList(5, 3, 1, 4, 2);
List<Integer> sortedNums = nums.stream()
    .sorted()
    .collect(Collectors.toList());
System.out.println(sortedNums); // [1, 2, 3, 4, 5]
```
## findAny와 findFirst
#### findFirst
- 스트림의 *첫번째 요소*를 반환한다 (병렬 스트림주의 : 최초에 '처리한' 요소가 아님)
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
// 빈 리스트인경우 result2에 0을 반환
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
### supplier, accumulator, combiner, finisher
- **Stream을 다룰 때 도중경과를 보존하는 오브젝트를 사용하고 싶을 때 java.util.stream.Collector를 사용한다.**
- 예제 : accumulator가 실제로 수행하고싶은 처리를 기술하는 인터페이스
```java
// java.util.Collector
List<String> words = List.of("apple", "banana", "kiwi");
Collector<String, int[], Integer> lengthSumCollector =
        Collector.of(
                () -> new int[]{0},             // supplier: 초기 누적자 (길이 1의 int 배열)
                (acc, word) -> acc[0] += word.length(), // accumulator: 각 단어의 길이를 누적
                (acc1, acc2) -> { acc1[0] += acc2[0]; return acc1; }, // combiner: 병렬 처리 결과 병합
                acc -> acc[0]                     // finisher: 최종 결과 변환
        );
int totalLength = words.stream().collect(lengthSumCollector);
System.out.println("Total length: " + totalLength); // 출력: Total length: 15
```
### Collectors.groupingBy
- 성별로 그룹화하는 예제 
- 리스트가 Map<<그룹기준>, 리스트<오브젝트>>로 재작성됨
- ex : `Map<Gender, List<Human>>`
```java
// java.util.Collector : groupingBy
List<Human> humanList = Arrays.asList(
    new Human(10, "a", Gender.female),
    new Human(10, "b", Gender.female),
    new Human(11, "c", Gender.female),
    new Human(11, "d", Gender.male ),
    new Human(12, "e", Gender.male)
);
Map<Gender, List<Human>> group = humanList.stream().collect(Collectors.groupingBy(Human::getGender));
System.out.println(group);
```

## Collectors.partitioningBy
- 조건에 일치하는 그룹과 일치하지 않는 그룹
```java
// java.util.Collector : partitioningBy
// 스트림의 요소를 지정한 조건에 일치하는 그룹과 일치하지 않는 그룹, 두 가지로 분할
List<String> fruitList = Arrays.asList("banana", "apple", "orange");
Stream<String> stream = fruitList.stream();
Set<Boolean> listKeys = stream.collect(
        Collectors.partitioningBy(str -> str.length() > 5)
).keySet();
// false
// true
listKeys.forEach(System.out::println);
```

## peek
```java
// Stream peek
// peek은 처리 중간에 픽업해서 내용을 들여다보고 싶을때 사용된다. (실제 데이터에 영향은 없음) 처리순서도 중간에 개입한다.
Stream<String> stream3 = Arrays.asList("banana", "apple", "orange").stream();
// 콘솔 : banana BANANA BANANAorange ORANGE ORANGE
stream3.filter(str -> str.length() > 5)
        .peek(str -> System.out.print(str + " "))
        .map(str -> str.toUpperCase())
        .peek(str -> System.out.print(str + " "))
        .forEach(System.out::print);
```