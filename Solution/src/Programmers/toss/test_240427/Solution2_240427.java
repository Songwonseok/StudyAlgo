package Programmers.toss.test_240427;

public class Solution2_240427 {
	public static int solution(String s) {
		int answer = -1;

		for(int i = 0; i < s.length() - 2; i++) {

			if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i+1) == s.charAt(i + 2)) {
				answer = Math.max(Integer.parseInt(s.substring(i, i + 3)), answer);
			}
		}

		return answer;
	}
	public static void main(String[] args) {

	}
}
