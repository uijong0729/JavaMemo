package ocjp.gold.classsample;

// Outer class
public class Outer {

    // ---------------------------------------------
    private int num = 2;
    private static class Sinner {
        private int data;
        void execute() {
            // NG : Cannot make a static reference to the non-static field num
            // System.out.println(num * data);
        
            // OK
            System.out.println(data);
            System.out.println(new Outer().num);
        }
    }

    public void hoge() {
        Sinner iSinner = new Sinner();
        iSinner.data = 3;
        iSinner.execute();
    }

    // ---------------------------------------------
    // Inner Class (:public불가)
    class Inner {
        public void test() {
            System.out.println("test");
        }
    }

    // static-Inner클래스
    static class Inner2 {
        // non-static-Inner클래스의 static필드 금지 (컴파일 에러해결을 위해 static class 적용)
        private static String message;
        public void test() {
            System.out.println(message);
        }
    }

    void test() {
        Inner2.message = "hello";
    }

    // ---------------------------------------------
	public static void main(String[] args) {
		// NG
        // new Inner();

        // NG
        // new Outer.Inner();
        
        // OK
        new Outer().new Inner().test();

        // NG
        // new Outer:Inner();
        
        //----------------------------------//
        
        // NG
        //Outer outer = new Outer();
        //outer.test();
        //outer.new Inner2().test();

        // OK
        new Inner2().test();

        new Sinner().execute();
	}
}