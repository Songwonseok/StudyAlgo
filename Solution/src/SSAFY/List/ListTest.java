package SSAFY.List;

class MyLinkedList{
	Node head = new Node();
	
	public void addFirst(int data) {
		Node n = new Node();
		n.data = data;
		n.link = head.link;
		
		head.link = n;
	}
	
	public void append(int data) {
		if(head.link == null) {
			addFirst(data);
		}else {
			Node n = new Node();
			n.data = data;
			n.link = null;
			
			Node t = head.link; //제일 마지막
			while(t.link != null) {
				t=t.link;
			}
			t.link = n;
		}
	}
	
	public void delete(int data) {
		if(head.link == null) return;
		
		Node t = head;
		while(t.link != null) {
			if(t.link.data == data)	{
				t.link = t.link.link;
			}else {
				t=t.link;
			}			
		}
	}
	
	public void print() {
		if(head.link ==null) return;
		
		Node t = head.link; //나
		while(t.link != null) {
			System.out.print(t.data + " -> ");
			t=t.link;
		}
		System.out.println(t.data);
	}
}
public class ListTest {
	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.append(4);
		ll.append(5);
		ll.delete(3);
		ll.print();
	}

}
