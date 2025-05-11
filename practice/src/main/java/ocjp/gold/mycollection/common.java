package ocjp.gold.mycollection;

import java.util.ArrayList;
import java.util.List;

public class common {
    public static void main(String[] args) {
        Test<?> test = new Test<>("HELLO");
        // T형 인수에 유일하게 대입가능한 값은 null 리터럴
        test.setValue(null);
        //test.setValue(1);
        //test.setValue("str");
        
        // T형 메소드 반환형은 Object형이다
        Object msg2 = test.getValue();
        // cast해서 사용하면 된다
        String msg = (String) test.getValue();

        // ----------------------------
        // 上限境界ワイルドカード
        List<? extends Number> list = new ArrayList<Integer>();
        Number myNumber = 100;
        Integer myInteger = 100;
        // 컴파일 에러1 : ?가 어떤 Number의 하위 타입인지 알 수 없다.
        // list.add(myInteger);
        // 컴파일 에러2 : Number는 Number의 하위타입이 아니므로 ? extends Number가 성립되지 않는다.
        // list.add(myNumber);
        // 컴파일 성공 : List<? extends Number> 타입으로 선언된 리스트에는 null 외에는 어떤 타입의 객체도 안전하게 추가할 수 없습니다.
        list.add(null);

        // ---------------------------------------------
    }

    static class Test<T> {
        T value;
        Test(T value) {
            super();
            this.value = value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
    }
}
