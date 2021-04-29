package ds;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList list = new LinkedList();
//		list.insertFront(6);
//		list.insertFront(7);
//		list.insertFront(8);
//		list.insertFront(9);
//		list.printList();
//		list.clear();
//		
//		System.out.println("=======");
//		
//		list.insertBack(3);
//		list.insertBack(4);
//		list.insertBack(5);
//		list.insertBack(6);
//		list.insertBack(7);
//		list.insertBack(8);
//		list.insertBack(9);
//		list.insertBack(10);
//		list.printList();
//		list.clear();
		
		Tree t = new Tree();
		Branch node11 = new Branch(null, 4, null);
		Branch node12 = new Branch(null, 5, null);
		Branch node13 = new Branch(node11, 7, node12);
		
		Branch node21 = new Branch(null, 9, null);
		Branch node22 = new Branch(null, 6, null);
		Branch node23 = new Branch(node21, 11, node22);
		
		t.preorder(node13);
		t.preorder(node23);
	}

}
