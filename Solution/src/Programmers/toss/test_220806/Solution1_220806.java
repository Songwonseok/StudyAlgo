package Programmers.toss.test_220806;

public class Solution1_220806 {
	public int solution(String s) {

		if(s.length() < 3) {
			return -1;
		}

		int answer = -1;
		int maxNumber = -1;

		int i = 0;

		int currNum = s.charAt(0) - '0';
		int length = 1;

		while(i < s.length() - 1&& answer < 999) {
			int nextNum = s.charAt(++i) - '0';

			if(currNum != nextNum) {
				length = 1;
				currNum = nextNum;
				continue;
			}

			if(currNum == nextNum) {
				length++;
			}

			if(length == 3) {
				answer = Math.max(111 * currNum, answer);
				maxNumber = Math.max(maxNumber, currNum);
				length = 1;

				if(i == s.length() - 1) {
					break;
				}

				currNum = s.charAt(++i) - '0';
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		Solution1_220806 solve = new Solution1_220806();

		System.out.println(solve.solution(""));

	}
}
