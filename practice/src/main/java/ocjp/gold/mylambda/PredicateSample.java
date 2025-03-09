package ocjp.gold.mylambda;

import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        Predicate<Integer> p1 = x -> x > 0;
        Predicate<Integer> p2 = x -> x < 100;
        System.out.println(p1.or(p2).test(100));
    }
}
