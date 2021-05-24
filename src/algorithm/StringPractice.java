package algorithm;

public class StringPractice {
	
	private static String reverseString(String str) {
		char[] tmp = str.toCharArray();
		char[] result = new char[tmp.length];
		
		int k = tmp.length - 1;
		for (int i = 0 ; i < tmp.length ; i++) {
			result[i] = tmp[k];
			k--;
		}
		return String.valueOf(result);
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(reverseString(str));
		
		
	}
}
