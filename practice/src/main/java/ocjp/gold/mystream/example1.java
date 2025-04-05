package ocjp.gold.mystream;

import java.util.Optional;
import java.util.function.Consumer;

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

        
    }
}
