package ocjp.gold.myclasss;

// 익명 클래스
public class Anonymous {
    
    private int num;
    public Anonymous(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        var sample = new Anonymous(10) {
            void modify(int num) {
                setNum(num);
            }
        };
        sample.modify(20);
        // 20출력
        System.out.println(sample.getNum());
    }
}
