package ocjp.gold.mystream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.List;

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
    }
}
