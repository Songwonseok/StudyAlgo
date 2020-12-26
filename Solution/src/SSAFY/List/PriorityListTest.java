package SSAFY.List;

class PriorityMyLinkedList{
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
			
			Node t = head;
			while(t.link != null) {
				if(t.link.data>data) {
					n.link=t.link;
					t.link=n;
					return;
				}else {
					t=t.link;
				}
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
public class PriorityListTest {
	public static void main(String[] args) {
		PriorityMyLinkedList ll = new PriorityMyLinkedList();
		
		ll.append(2);
		ll.append(3);
		ll.append(1);
		ll.print();
	}

}
