package ds;

class Node{
	int value;
	Node next = null;
	
	Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
} 

public class LinkedList{
	private Node headNode, tailNode = null;
	
	public void insertFront(int value) {
		headNode = new Node(value, headNode);
	}
	
	public void insertBack(int value) {
		if(headNode == null) {
			headNode = new Node(value, null);
			tailNode = headNode;
		}else {
			Node tmpNode = headNode;
			while(tmpNode != tailNode) {
				tmpNode = tmpNode.next;
			}
			tmpNode.next = tailNode = new Node(value, null);
		}
	}
	
	// 확인용 출력
	public void printList() {
		if (headNode == null) return;
		
		Node tempNode = headNode;
		while (tempNode != null) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}
	
	// 참조 해제 
	public void clear() {
		for (Node x = headNode; x != null;) {
			Node next = x.next;
			x.next = null;
			x = next;
		}
		headNode = null;
	}
}

