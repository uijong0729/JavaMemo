package ocjp.gold.lambda;

import java.util.function.Function;

public class FunctionSample {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = x -> x + 2;
        Function<Integer, Integer> f2 = x -> x * 2;
        // (10+2)*2 = 24
        System.out.println(f1.andThen(f2).apply(10));
        // (10*2)+2 = 22
        System.out.println(f1.compose(f2).apply(10));
    }
}
