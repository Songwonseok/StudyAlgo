package Programmers.practice;

import java.util.Arrays;
import java.util.Stack;

public class Stack_주식가격 {
	
	public static int[] solution(int[] prices) {
		int N = prices.length;
		int[] answer = new int[N];
		
		Stack<Integer> stack = new Stack();
		int time =0;
		for(int i=0;i<N;i++) {
			while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				int idx = stack.pop();
				answer[idx] = time - idx; 
			}
			stack.push(i);
			time++;
		}
		
		while(!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = time - idx -1; 
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}

}
