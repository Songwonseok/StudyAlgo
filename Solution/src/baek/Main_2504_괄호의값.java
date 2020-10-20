package baek;

import java.io.*;
import java.util.*;

public class Main_2504_괄호의값 {
	static String str;
	static int currIndex;
	
	public static int calculate(Stack<Character> stack) {
		if(str.charAt(currIndex) == ']') {
			stack.pop();
			currIndex++;
			return 3;
		}else if(str.charAt(currIndex) == ')') {
			stack.pop();
			currIndex++;
			return 2;
		}
		
		ArrayList<Integer> list =  new ArrayList<>();
		int sum = 0;
		while(currIndex < str.length() && !stack.isEmpty()) {
			if(str.charAt(currIndex) == '[' || str.charAt(currIndex) == '(') {
				stack.add(str.charAt(currIndex++));
				if(sum != 0) {
					list.add(sum);
					sum = 0;
				}
				sum = calculate(stack);
			}else {
				if(str.charAt(currIndex) == ']') {
					for(int num : list)
						sum += num;
					sum *= 3;
				}else {
					for(int num : list)
						sum += num;
					sum *= 2;
				}
				stack.pop();
				currIndex++;
				break;
			}
		}
		return sum;
	}
	
	public static boolean checkValid(String str) {
		Stack<Character> stack = new Stack();
		if(str.charAt(0) != '[' && str.charAt(0) != '(') 
			return false;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			}
			else {
				if(stack.isEmpty()) return false;
				if(str.charAt(i) == ']') {
					if(stack.peek() != '[')
						return false;
					stack.pop();
				}else if(str.charAt(i) == ')') {
					if(stack.peek() != '(')
						return false;
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
		
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int sum = 0;
		currIndex = 0;
		boolean check = checkValid(str);
		Stack<Character>stack = new Stack<>();
		while(check && currIndex < str.length()) {
			if(str.charAt(currIndex) == '[' || str.charAt(currIndex) == '(') {
				stack.add(str.charAt(currIndex++));
				sum += calculate(stack);
			}
		}
		System.out.println(sum);
	}
}
