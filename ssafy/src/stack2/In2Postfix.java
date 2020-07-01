package stack2;

import java.util.Stack;

public class In2Postfix {
	//public static String msg="(6+5*(2-8)/2)";
	public static String msg="2+3*4/5";
	public static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<msg.length();i++) {
			char c = msg.charAt(i);
			if('0' <= c && c <= '9') { //Character.isDigit(c)
				sb.append(c);
			}else if(c == ' ') {
				
			}else if(c == ')') {
				char s='\u0000'; //유니코드의 null문자
				while((s=stack.pop()) != '(') {
					sb.append(s);
				}
			}else { //+,-,*,/
				while(getIcp(c) <= getIsp()) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
	
	public static int getIcp(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		default:
			return 0;
		}
	}
	
	public static int getIsp() {
		char c = stack.empty() ? ' ' : stack.peek(); //비었으면 비우고 안비었으면 꼭대기를 리턴
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return 0;
		}
	}
}
