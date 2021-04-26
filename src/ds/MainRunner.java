package ds;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insertFront(6);
		list.insertFront(7);
		list.insertFront(8);
		list.insertFront(9);
		list.printList();
		list.clear();
		
		System.out.println("=======");
		
		list.insertBack(3);
		list.insertBack(4);
		list.insertBack(5);
		list.insertBack(6);
		list.insertBack(7);
		list.insertBack(8);
		list.insertBack(9);
		list.insertBack(10);
		list.printList();
		list.clear();
	}

}
