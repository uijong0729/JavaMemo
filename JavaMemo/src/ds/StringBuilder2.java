package ds;

public class StringBuilder2 {
	/*
	 *  단순 루프 문자열 더하기의 시간복잡도는 O(xn^2)
	 *  for (String w : words){
	 *  	sentence += w
	 *  }
	 * 
	 * 	StringBuilder : 동기화x
	 * 	StringBuffer : 동기화o
	 * 
	 */
	
	private char[] value;
	private int size;
	private int index;
	
	public StringBuilder2(){
		size = 1;
		value = new char[size];
		index = 0;
	}
	
	public void append(String str) {
		if(str == null) return;
		int len = str.length();
		ensureCapacity(len);
		for(int i = 0; i < str.length(); i++) {
			value[this.index] = str.charAt(i);
			this.index++;
		}
	}
	
	private void ensureCapacity(int length) {
		if (this.index + length > this.size) {
			this.size = (size + length) >> 1;
			char[] newValue = new char[size];
			for(int i = 0; i < value.length; i++) {
				newValue[i] = value[i];
			}
			this.value = newValue;
		}
	}
	
	@Override
	public String toString() {
		// char[]를 0번부터 index번까지를 반환
		return new String(value, 0, index);
	}
	
}
