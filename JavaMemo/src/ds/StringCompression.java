package ds;


public class StringCompression {
	
	private String compress(String str) {
		int count = 0;
		int length = str.length();
		StringBuilder sb = new StringBuilder(getTotal(str));
		for(int i = 0; i < length; i++) {
			count++;
			// 마지막 문자이거나 해당 문자가 다음 문자와 다른 경우
			if (i + 2 > length || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.toString();
	}
	
	String compressString(String str) {
		String newStr = compress(str);
		// 압축한 문자열이 기존 문자열보다 길면 기존 문자열 반환 
		return str.length() < newStr.length() ? str : newStr;
	}
	
	
	private int getTotal(String str) {
		int count = 0;
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 2 >= str.length() || str.charAt(i) != str.charAt(i+1) ) {
				total += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return total;
	}
	
	// aabbbccccd
	// a2b3c4d1
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		System.out.println(sc.compressString("aaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(sc.compressString("abcd"));
		
	}
}
