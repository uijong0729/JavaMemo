package ocjp.gold.lambda;

import java.util.function.BinaryOperator;

public class BynaryOperatorSample {
    public static void main(String[] args) {
        BinaryOperator<String> bo = (a, b) -> a + b;
        System.out.println(bo.apply("te", "st"));
    }
}
