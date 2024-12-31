package ocjp.gold;

// Outer class
public class Outer {

    private int num = 2;
    
    private static class Sinner {
        private int data;
        void execute() {
            // NG : Cannot make a static reference to the non-static field num
            // System.out.println(num * data);
            
            // OK
            System.out.println(data);
        }
    }

    public void hoge() {
        Sinner iSinner = new Sinner();
        iSinner.data = 3;
        iSinner.execute();
    }

    // Inner Class (:public불가)
    class Inner {
        public void test() {
            System.out.println("test");
        }
    }

	public static void main(String[] args) {
		// NG
        // new Inner();

        // NG
        // new Outer.Inner();
        
        // OK
        new Outer().new Inner().test();

        // NG
        // new Outer:Inner();
	}
}