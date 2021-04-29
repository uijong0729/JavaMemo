package ds;

class Branch{
	// 자기 자신 
	int data;
	// 왼쪽 노드 
	Branch left;
	// 오른쪽 노드
	Branch right;	
	
	public Branch() {
		
	}
	
	public Branch(Branch left, int data, Branch right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
public class Tree {
	public Branch root;
	public void inorder(Branch branch) {
		if (branch != null) {
			this.inorder(branch.left);
			System.out.println(branch.data);
			this.inorder(branch.right);
		}
	}
	
	public void preorder(Branch branch) {
		if (branch != null) {
			System.out.println(branch.data);
			this.inorder(branch.left);
			this.inorder(branch.right);
		}
	}
	
	public void postorder(Branch branch) {
		if (branch != null) {
			this.inorder(branch.left);
			this.inorder(branch.right);
			System.out.println(branch.data);
		}
	}
}
