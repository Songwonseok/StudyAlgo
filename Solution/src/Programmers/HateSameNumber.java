package Programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class HateSameNumber {
	public int[] solution(int []arr) {
		Stack<Integer> stack = new Stack();

		for(int num : arr) {
			if(stack.size() > 0 && stack.peek() == num) {
				continue;
			}

			stack.push(num);
		}


		int[] answer = new int[stack.size()];

		for(int i = stack.size() - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}

		return answer;
	}
	public static void main(String[] args) {
		int[] answer = new HateSameNumber().solution(new int[] {1, 1, 3, 3, 0, 1, 1});
		System.out.println(Arrays.toString(answer));
	}
}
