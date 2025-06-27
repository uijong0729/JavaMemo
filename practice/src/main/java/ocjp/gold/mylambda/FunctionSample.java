package ocjp.gold.mylambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionSample {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = x -> x + 2;
        Function<Integer, Integer> f2 = x -> x * 2;
        // (10+2)*2 = 24
        System.out.println(f1.andThen(f2).apply(10));
        // (10*2)+2 = 22
        System.out.println(f1.compose(f2).apply(10));

        // 람다식1 (unchecked warning포함)
        Consumer c1 = System.out::println;
        // 람다식2 (unchecked warning포함)
        Consumer c2 = x -> System.out.println(x);
        // 람다식3 (unchecked warning포함)
        Consumer<String> c3 = (String msg) -> System.out.println(msg);
        // 원문
        Consumer c4 = new Consumer() {
            @Override
            public void accept(Object x) {
                System.out.println(x);
            }
        };
    }
}
