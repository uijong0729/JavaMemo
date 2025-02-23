package effective.Enum;

public class EnumTester {
	public static void main(String[] args) {
		Answer p1 = Answer.Y;
		Answer p2 = Answer.N;
		discriminate(p1);
		
		print(Answer.Y.getValue1());
		print(Answer.Y.getValue2());
		print(Answer.Y.isValue3());
	}
	
	public static void discriminate(Answer arg) {
		switch(arg) {
			case Y: 
				print("Y");
				break;
			case N:
				print("N");
				break;
		}
	}
	
	private static void print(String msg) {
		System.out.println(msg);
	}
	private static void print(boolean msg) {
		System.out.println(msg ? "true" : "false");
	}
}

enum Answer{
	Y("1", "yes", true), N("0", "yes", false);
	
	private String value1;
	private String value2;
	private boolean value3;
	
	Answer(String value1, String value2,boolean value3){
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	public String getValue1() {
		return value1;
	}

	public String getValue2() {
		return value2;
	}

	public boolean isValue3() {
		return value3;
	}
}
