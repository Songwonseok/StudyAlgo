package tree;

import java.util.Scanner;

class Tr22{
	class Node{
		int data;
		Node left, right;
	}
	Node root;
	
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void makeTree(int d1, int d2) {
		if(root == null) {
			root = new Node();
			root.data=d1;
		}
		makeTree(root,d1,d2);
	}
	public Node makeTree(Node root, int d1, int d2) {
		if(root==null) {
			root = new Node();
			root.data=d2;
			return root;
		}
		if(root.data == d1) {
			if(root.left==null) root.left=makeTree(root.left, d1,d2);
			else if(root.right==null) root.right=makeTree(root.right, d1, d2);
			return root;
		}
		makeTree(root.left,d1,d2);
		makeTree(root.right, d1, d2);
		return root;
	}
}

public class TreePreorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Tr22 t = new Tr22();
		for(int i=0;i<N-1;i++) {
			t.makeTree(sc.nextInt(), sc.nextInt());
		}
		t.preorder(t.root);
		sc.close();
	}

}
