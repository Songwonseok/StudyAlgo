package SSAFY.Tree;

class BinaryTree{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root=makeTree(a,0,a.length-1);
	}
	public Node makeTree(int[] a,int start,int end) {
		if(start>end) return null;
		int mid=(start+end)/2;
		Node node=new Node(a[mid]);
		node.left=makeTree(a,start,mid-1);
		node.right=makeTree(a,mid+1,end);
		return node;
	}
	public void searchBTree(Node n,int find) {
		if(find<n.data) {
			System.out.println("Data is smaller than "+n.data);
			searchBTree(n.left,find);
		}else if(find>n.data) {
			System.out.println("Data is bigger than "+n.data);
			searchBTree(n.right,find);
		}else {
			System.out.println("Data found!");
		}
	}
}
/*
          4
   1           7
0    2       5   8
       3      6   9 
       
Data is bigger than 4
Data is bigger than 7
Data is bigger than 8
Data found!
       
*/
public class BinaryTreeTest {
	public static void main(String[] args) {
		int[] a=new int[10];
		for(int i=0; i<a.length; i++) a[i]=i;
		
		BinaryTree t=new BinaryTree();
		t.makeTree(a);
		t.searchBTree(t.root, 9);
	}
}
