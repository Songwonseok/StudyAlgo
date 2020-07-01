package stack1;

import java.util.Stack;

import javax.xml.bind.ValidationEvent;

public class StackTest {
	public static int[] stack = new int[100];
	public static int top=-1;
	
	public static boolean push(int val){
		if(top >= stack.length) return false;
		stack[++top] = val;
		return true;
	}
	
//	public static void push(int val){
//		stack[++top] = val;
//	}
	
	public static int pop() {
		if(top == -1) return -1;
		return stack[top--];
	}
	
	public static int peek() {
		if(top == -1) return -1;
		return stack[top];
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	public static void main(String[] args) {
		push(1);
		System.out.println(isEmpty());
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		
		Stack<Character> stack = new Stack<>();
		stack.push('A');
		System.out.println(stack.empty());
		stack.push('B');
		stack.push('C');
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
