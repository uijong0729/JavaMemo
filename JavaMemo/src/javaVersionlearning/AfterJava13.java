package javaVersionlearning;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;

public class AfterJava13 {

	// record
	/**
	 * 레코드(record)란 "데이터 클래스"이며 순수하게 데이터를 보유하기 위한 특수한 종류의 클래스이다. get,set함수 정의안해도 됨
	 */
	record recordObj(String name, int age) {
		// ==================== 멤버변수 선언불가 (static만 가능)========================
		// 컴파일 NG
		// int aa = 1;
		// 컴파일 OK
		// static int aa = 1;

		// ==================== 생성자 선언방법========================
		// 생성자 사용법 NG
//		public recordObj(name, age) {
//			
//		}
		// 생성자 사용법 OK
		public recordObj {
			System.out.println(name);
			System.out.println(age);
		}

		// ==================== 메소드 정의 ========================
		public void sysout() {
			System.out.println("method : " + name);
			System.out.println("method : " + age);
		}
	}

	public static void main(String[] args) {
		// Arrow Label 1
		System.out.println(testArrowLabel(1));
		System.out.println(testArrowLabel(2));
		System.out.println(testArrowLabel(3));

		// Arrow Label 2
		testArrowLabel2(1);
		testArrowLabel2(2);
		testArrowLabel2(3);

		// yield
		System.out.println(testYield("foo"));
		System.out.println(testYield("faa"));

		// record
		var obj = new recordObj("name", 5);

		// record의 메소드 호출
		obj.sysout();

		// record의 멤버변수 접근
		System.out.println(obj.name());
		System.out.println(obj.age());
	}

	public static String testArrowLabel(int k) {
		return switch (k) {
			case 1 -> "my k = 1";
			case 2 -> "my k = 2";
			default -> "my k = defualt";
		};
	}

	public static void testArrowLabel2(int k) {
		switch (k) {
			case 1 -> System.out.println("my k = 1");
			case 2 -> System.out.println("my k = 2");
			default -> System.out.println("my k = default");
		}
	}

	/**
	 * yield : switch 문이 결과값을 반환할 때 그 값을 변수에 대입하려는 경우 yield 키워드 사용
	 * 
	 * @param a
	 * @return
	 */
	public static String testYield(String a) {
		String result = switch (a) {
		case "foo":
			yield "result";
		default:
			yield "default";
		};

		return result;
	}

	public static String testYield2(String a) {
		return switch (a) {
		case "foo":
			yield "result";
		default:
			yield "default";
		};
	}
}
