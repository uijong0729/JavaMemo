package javaVersionlearning;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

public class Java8 implements TestDefaultInterface{

	public static void main(String[] args) {
		// Optional Test
		System.out.println("=========Optional Test=========");
		getOptionalString("myString");
		getOptionalString(null); 
		
		// Lambda Test
		System.out.println("=========Lambda Test=========");
		testLambda("my lambda");
		
		// Stream Test
		System.out.println("=========Stream Test=========");
		testStream(makeTestObj());
		
		// parallelSort
		System.out.println("=========parallelSort Test=========");
		testParallelSort(new int[]{4,5,3,7,2,1,8,2});
		
		
		// interface -> default Method
		System.out.println("=========Default Method Test=========");
		Java8 a = new Java8();
		a.defaultMethod();
		
		// StringJoiner
		System.out.println("=========StringJoiner Test=========");
		StringJoiner sj = new StringJoiner("_postfix\n");
		var list = makeTestObj();
		for(String str : list) {
			sj.add(str);
		}
		System.out.println(sj.toString());
		
		
		// ZonedDateTime
		System.out.println("=========ZonedDateTime Test=========");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
	}
	
	
	/**
	 * Optional<T> 
	 * 
	 * @param str 
	 * @return
	 */
	public static void getOptionalString(String str){
		// ofNullable	null값을 인수로 허용
		// of			null값이 들어올 경우 예외 발생 
		Optional<String> value = Optional.ofNullable(str);
		
		// orElse : null인경우 다른 <T>를 가져옴
		String orElseString = value.orElse("Default String");
		System.out.println("orElse : " + orElseString);
		
		// orElseGet : null인경우 Supplier를 가져옴 
		String orElseGetString = value.orElseGet(() -> "default String by supplier");
		System.out.println("orElseGet : " + orElseGetString);

		// Optional에 값이 있는지 확인
		if (value.isPresent()) {
			System.out.println("isPresent : " + value.get());
		}
		
		// Optional에 값이 있는지 확인 + 콜백
		value.ifPresent(getValue -> {
			System.out.println("ifPresent : " + getValue);
		});
	}
	
	/**
	 * Lambda 
	 * 
	 * @param str 
	 * @return
	 */
	public static void testLambda(String str){
		// 기존의 작성법
		var obj1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(str);
			}
		});
		obj1.start();
		
		// 인수가 없는 메소드 
		var obj2 = new Thread(() -> {
			System.out.println(str);
		});
		obj2.start();
		
		// 인수를 갖는 메소드
		Optional<String> obj3 = Optional.of(str);
		obj3.ifPresent((getValue) -> {
			System.out.println(obj3.get());
		});
	}
	

	/**
	 * Stream()
	 * 
	 * @param streamTarget
	 */
	public static void testStream(ArrayList<String> streamTarget) {
		// foreach : 데이터 추출
		System.out.println("--foreach");
		streamTarget.stream().forEach( item -> {
			System.out.println(item);
		});
		
		
		// filter : 조건에 '충족하는' 요소를 추출
		System.out.println("--filter");
		streamTarget.stream().filter(target -> (target.length() > 2)).forEach( item -> {
			System.out.println(item);
		});
		
		
		// skip : 처음 n개의 요소를 제외함
		System.out.println("--skip");
		streamTarget.stream().skip(2).forEach(item -> {
			System.out.println(item);
		});
		
		
		// distinct : 중복 요소를 제외함
		System.out.println("--distinct");
		streamTarget.stream().distinct().forEach(item -> {
			System.out.println(item);
		});
		
		// map<T, R> : T를 R로 변환한 스트림 생성 
		System.out.println("--map");
		streamTarget.stream().map(map -> map.toUpperCase()).forEach(item -> {
			System.out.println(item);
		});
		
		// flatMap<T, R> : 여러 객체를 하나의 스트림 객체로 합침
		System.out.println("--flatMap");
		streamTarget.stream().flatMap(map -> streamTarget.stream()).forEach(item -> {
			System.out.println(item);
		});
	}
	
	
	/**
	 * parallelSort()
	 * 
	 * @return
	 */
	private static void testParallelSort(int[] target){
		Arrays.parallelSort(target);
		for(int i : target) {
			System.out.println(i);
		}
	}
	

	/**
	 * 테스트 데이터 작성용
	 * 
	 * @return
	 */
	static ArrayList<String> makeTestObj(){
		var list = new ArrayList<String>();
		// 중복 데이터
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		
		// 요소 정렬
		list.add("bb5");
		list.add("bb3");
		list.add("bb2");
		list.add("bb1");
		
		// 기타 임의 값
		list.add("ccc");
		return list;
	}

}


interface TestDefaultInterface{
	// java 8 : 디폴트 메소드
	default void defaultMethod() {
		// java 9 : 인터페이스 내 private 메소드 정의
		staticPrivate();
		System.out.println("default method");
	}
	
	// java 9 : 인터페이스 내 private 메소드 정의
	private static String staticPrivate() {
	     return "static private";
	}
}
