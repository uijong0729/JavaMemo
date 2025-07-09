package ocjp.gold.myinterface;

public class Runner {

    public static void main(String[] args) {
        Sample sample = new Sample();
        // b : 인터페이스의 디폴트 메소드 < 클래스의 메소드
        sample.test();
    }
}
