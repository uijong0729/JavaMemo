package purejava;

public class BitOperator {
	public static void main(String[] args) {
		System.out.println(1 << 3); // 1 * 2 * 2 * 2  == 8
		System.out.println(8 >> 3); // ((8 / 2) / 2) / 2  == 1
		System.out.println("================");
		
		// & : AND (대응되는 비트가 모두 1이면 1을 반환)
		// 0111&0011 => 0011 == 3
		// ※ 연산 대상 한쪽 수가 모두 1인 경우, 두 수를 AND연산할 때 더 작은 수가 그대로 반환되는 것에 주목
		// 1, 3, 7, 15, 31, 63, 127 ...
		System.out.println(7&3); // 3
		System.out.println(31&3); // 0 00101 & 01010 ==>00000  
		System.out.println("================");
		
		// | : OR (대응되는 비트가 하나라도 1이면 1을 반환)
		// 0111&0011 => 0111 == 7
		// ※ 연산 대상 한쪽 수가 모두 1인 경우, 두 수를 OR연산할 때 더 큰 수가 그대로 반환되는 것에 주목
		// 1, 3, 7, 15, 31, 63, 127 ...
		System.out.println(7|3);
		System.out.println(31|10);
		System.out.println("================");
		
		// ^ : XOR (대응되는 비트가 서로 다르면 1을 반환) 
		// 0111^0011 => 0100 == 4
		//  010100
		// ^001110 => 011010 == 50 (40^34)
		// ※ 연산 대상 한쪽 수가 모두 1인 경우, 두 수를 XOR연산할 때 결과가 뺄셈과 같은 것에 주목
		System.out.println(7^3);
		System.out.println("================");
		
		// ~ : NOT (비트를 1이면 0으로, 0이면 1로 반전시킴)
		// 양수 : 음수로 변하며 -1 이 가산됨
		// 음수 : 양수로 변하며 +1 이 가산됨
		System.out.println(~5);
		System.out.println(~-5);
		System.out.println("================");
		
		int[] arr = {1, 3, 31, 7, 127, 15, 63}; 
		System.out.println("max : " + getMax(arr));
		System.out.println("min : " + getMin(arr));
	}
	
	public static int getMax(int[] arr) {
		int result = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			result = result | arr[i];
		}
		return result;
	}
	
	public static int getMin(int[] arr) {
		int result = arr[0];
		
		for (int i = 1 ; i < arr.length ; i++) {
			result = result & arr[i];
		}
		return result;
	}

}
