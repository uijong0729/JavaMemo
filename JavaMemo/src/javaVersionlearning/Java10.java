package javaVersionlearning;

public class Java10 {
	public static void main(String[] args) {
		// 로컬변수 선언 var
		var msg = "String";
		System.out.println(msg);
		
		// 반복문에서의 var
		var list = Java8.makeTestObj();
		for (var a : list) {
			System.out.println(a);
		}
	}
}
