package tree;


class Tree{
	class Node{
		char data;
		Node left, right;
	}
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node makeTree(Node left, char data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		
		return node;
	}
	
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}
}

public class TreeTest {

	public static void main(String[] args) {
		Tree t = new Tree();
		
		/*
		Tree.Node d = t.makeTree(null,'D',null);
		Tree.Node h = t.makeTree(null,'H',null);
		Tree.Node i = t.makeTree(null,'I',null);
		Tree.Node f = t.makeTree(null,'F',null);
		Tree.Node g = t.makeTree(null,'G',null);
		
		
		Tree.Node e = t.makeTree(h,'E',i);
		Tree.Node b = t.makeTree(d,'B',e);
		Tree.Node c = t.makeTree(f,'C',g);
		
		Tree.Node a = t.makeTree(b, 'A', c);
		t.setRoot(a);
		*/
		
		Tree.Node h = t.makeTree(null,'H',null);
		Tree.Node i = t.makeTree(null,'I',null);
		Tree.Node j = t.makeTree(null,'J',null);
		Tree.Node k = t.makeTree(null,'K',null);
		Tree.Node l = t.makeTree(null,'L',null);
		Tree.Node m = t.makeTree(null,'M',null);
		
		
		Tree.Node d = t.makeTree(h,'D',i);
		Tree.Node e = t.makeTree(j,'E',null);
		Tree.Node f = t.makeTree(null,'F',k);
		Tree.Node g = t.makeTree(l,'G',m);
		
		Tree.Node b = t.makeTree(d, 'B', e);
		Tree.Node c = t.makeTree(f, 'C', g);
		
		Tree.Node a = t.makeTree(b, 'A', c);
		t.setRoot(a);
		
		Tree.Node r = t.getRoot();
		t.preorder(r);
		System.out.println();
		t.inorder(r);
		System.out.println();
		t.postorder(r);
		System.out.println();
	}

}
