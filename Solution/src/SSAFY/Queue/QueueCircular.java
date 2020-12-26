package SSAFY.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCircular {
	public static int n=100;
	public static int[] queue = new int[n];
	public static int front=0;
	public static int rear=0;
	
	public static boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	
	public static boolean isFull() {
		if((rear+1)%n == front) return true;
		else return false;
	}
	
	public static void enqueue(int item) {
		if(isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[(++rear)%n] = item;
	}
	
	public static int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(++front)%n];
	}
	
	public static int qpeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(front+1)%n];
	}
	
	public static void main(String[] args) {
//		enqueue(1);
//		enqueue(2);
//		enqueue(3);
//		System.out.println(qpeek());
//		System.out.println(dequeue());
//		System.out.println(dequeue());
//		System.out.println(dequeue());
//		System.out.println();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		System.out.println(q);
		System.out.println(q.peek());

		q.poll();
		q.poll();
		q.poll();
		System.out.println(q);

	}

}
