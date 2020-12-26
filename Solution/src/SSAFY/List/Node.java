package SSAFY.List;


public class Node {
	int data;
	Node link;
	
	public Node(){
		this(0, null);
	}
	
	public Node(int data){
		this(data, null);
	}
	
	public Node(int data, Node link){
		this.data = data;
		this.link = link;
	}
}
