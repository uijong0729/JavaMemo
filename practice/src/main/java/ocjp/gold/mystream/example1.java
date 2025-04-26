package ocjp.gold.mystream;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ocjp.gold.Human;
import ocjp.gold.Human.Gender;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class example1 {
    public static void main(String[] args) {
        // java.util.NoSuchElementException : null을 그대로 get하면 예외발생
        // Optional<String> sample = Optional.ofNullable(null);
        // System.out.println(sample.get());

        // java.lang.NullPointerException : nullable없이 null을 세팅하면 예외발생
        // sample = Optional.of(null);
        // System.out.println(sample);

        // ifPresentOrElse
        Optional<String> sample3 = Optional.empty();
        sample3.ifPresentOrElse(new Consumer<String>() {
            public void accept(String t) {
                System.out.println(t);
            };
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("empty");
            }
        });

        // ifPresentOrElse lambda
        sample3.ifPresentOrElse(str -> {
            // consumer
            System.out.println(str);
        }
        ,() -> {
            // runnable
            System.out.println("empty");
        });

        // map 사용법
        Optional<Integer> a = Optional.of(100);
        Optional<Integer> b = a.map(price -> price * 3);
        System.out.println(b.get());

        // reduce 사용법
        // 일련의 요소를 하나로 통합하는 스트림 조작
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // Optional로 받을게
        Optional<Integer> result = list.stream().reduce((c, d) -> c + d);
        result.ifPresent(System.out::println); // 15
        // 값이 없다면 0으로 받을테니 일단 줘
        Integer result2 = list.stream().reduce(0, (c, d) -> c + d);
        System.out.println(result2);

        // max 사용법
        List<String> strList = Arrays.asList("A", "B", "C", "D");
        // compare는 String클래스에도 있으며, String클래스에서의 max는 나중에오는 문자이다
        Optional<String> strResult = strList.stream().max((e, f) -> e.compareTo(f));
        strResult.ifPresent(System.out::println);
        
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

        // java.util.Collector : groupingBy
        // 스트림의 요소를 특정한 기준으로 그룹화
        List<Human> humanList = Arrays.asList(
            new Human(10, "a", Gender.female),
            new Human(10, "b", Gender.female),
            new Human(11, "c", Gender.female),
            new Human(11, "d", Gender.male ),
            new Human(12, "e", Gender.male)
        );
        Map<Gender, List<Human>> group = humanList.stream().collect(Collectors.groupingBy(Human::getGender));
        System.out.println(group);

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

        // Stream peek
        // peek은 처리 중간에 픽업해서 내용을 들여다보고 싶을때 사용된다. (실제 데이터에 영향은 없음)
        Stream<String> stream3 = Arrays.asList("banana", "apple", "orange").stream();
        // 콘솔 : banana BANANA BANANAorange ORANGE ORANGE
        stream3.filter(str -> str.length() > 5)
            .peek(str -> System.out.print(str + " "))
            .map(str -> str.toUpperCase())
            .peek(str -> System.out.print(str + " "))
            .forEach(System.out::print);
        
    }
}
