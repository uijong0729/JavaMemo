package ocjp.gold.mystream;

import java.util.Optional;

public class example1 {
    public static void main(String[] args) {
        // java.util.NoSuchElementException
        Optional<String> sample = Optional.ofNullable(null);
        System.out.println(sample.get());

        // java.lang.NullPointerException
        sample = Optional.of(null);
        System.out.println(sample);
    }
}
