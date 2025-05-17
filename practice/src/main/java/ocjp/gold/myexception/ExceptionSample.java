package ocjp.gold.myexception;

public class ExceptionSample {
    public static void main(String[] args) {
        A a = new A("A");
        try (a;
         A b = new A("B");
         A c = new A("C")) {
            System.err.println("main");
        } catch (Exception e) {
            // TODO: handle exception
        }

        // abc cannot be resolved to a type
        // A abc;
        // try (abc = new A("A")) {

        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        A abc2 = new A("A");
        try (abc2) {

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

class A implements AutoCloseable {
    String msg;
    A(String msg) {
        this.msg = msg;
    }
    @Override
    public void close() throws Exception {
        System.out.println(msg);
    }
}