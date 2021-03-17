package Programmers.kakao;

import java.util.Stack;

public class KAKAO_2018_n진수게임 {
	static char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String changeNumber(int n, int value) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack();
		if (value == 0)
			return "0";

		while (value > 0) {
			stack.push(numbers[value % n]);
			value /= n;
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		int max = m * t;
		int value = 0;

		while (sb.length() < max) {
			sb.append(changeNumber(n, value));
			value++;
		}

		String totalNum = sb.toString();

		for (int i = p - 1; i < max; i += m) {
			answer.append(totalNum.charAt(i));
		}

		return answer.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
