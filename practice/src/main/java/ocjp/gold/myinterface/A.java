package ocjp.gold.myinterface;

public interface A {
    default void test() {
        System.out.println("a");
    }
}
