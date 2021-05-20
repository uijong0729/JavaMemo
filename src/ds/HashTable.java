package ds;

import java.util.LinkedList;

// 해시테이블의 데이터 흐름 : Function(Key) -> HashCode -> Index -> value
/* https://youtu.be/Vi0hauJemxA
 * 
 * 해시함수를 통해 만든 해시코드는 정수이다.
 * 
 * collision
 *  - 해시 키는 무한한데, 해시 코드는 정수개 밖에 제공하지 못하기 때문에 발생
 *  - 알고리즘이 아무리 좋아도 어떤 키들은 동일한 결과를 리턴할 수 있다.
 * 
 */
public class HashTable {
	class Node2 {
		String key;
		String value;
		
		public Node2(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
	
	// 배열 크기는 소수(素数（そすう)가 유리하다 
	private static final int ARRAY_SIZE = 23;
	private java.util.LinkedList<Node2>[] data;
	
	HashTable(int size) {
		this.data = new java.util.LinkedList[size];
	}
			
	private int getHashCode(String str) {
		char[] arr = str.toCharArray();
		int result = 0;
		for (int i = 0 ; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	private Node2 searchKey(java.util.LinkedList<Node2> list, String key) {
		if (list == null) return null;
		for (Node2 node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	public void put(String key, String value) {
		int hashcode = getHashCode(key);
		// 배열 방 번호
		int index = hashcode % data.length;
		java.util.LinkedList<Node2> list = data[index];
				
		if (list == null) {
			list = new java.util.LinkedList<Node2>();
			data[index] = list;
		}
		// 해당 배열방의 LinkedList에 키가 있는지 검색 
		Node2 node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Node2(key, value));
		} else {
			// 노드에 동일키가 있다면 값 대체
			node.setValue(value);
		}
	}
	
	public String get(String key) {
		int hashcode = getHashCode(key);
		int index = hashcode % data.length;
		LinkedList<Node2> list = data[index];
		Node2 node = searchKey(list, key);
		return node == null ? null : node.getValue();
	}
	
}
