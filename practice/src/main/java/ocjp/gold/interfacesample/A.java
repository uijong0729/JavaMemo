package ocjp.gold.interfacesample;

public interface A {
    default void test() {
        System.out.println("a");
    }
}
