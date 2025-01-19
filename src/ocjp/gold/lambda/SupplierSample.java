package ocjp.gold.lambda;

import java.util.function.Supplier;

public class SupplierSample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "test";
        System.out.println(supplier.get());
    }
}
