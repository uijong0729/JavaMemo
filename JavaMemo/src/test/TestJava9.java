package test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

public class TestJava9 {
		
	@Test
	public void testLocalVariableType() {
		// 明示的に型が解決できる場合
		var list = new ArrayList<String>();
		list.add("aaa");
		
		for (var i = 0 ; i < list.size(); i++) {
			System.out.println(list);
		}
		
		for (var s : list) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testUnderscore() {
		int _b_c = 5;
		System.out.println(_b_c);
	}
	
}
