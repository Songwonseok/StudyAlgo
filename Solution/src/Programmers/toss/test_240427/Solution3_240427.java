package Programmers.toss.test_240427;

import java.util.regex.Pattern;

public class Solution3_240427 {
	public static boolean solution(String amountText) {
		boolean answer = true;

		if(!Pattern.matches("[0-9,]+", amountText)) {
			return false;
		}

		if(!amountText.equals("0") && amountText.charAt(0) == '0') {
			return false;
		}

		if(!Pattern.matches("\\d{1,3}(,\\d{3})*|\\d+", amountText)) {
			return false;
		}


		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("124,,"));
	}
}
