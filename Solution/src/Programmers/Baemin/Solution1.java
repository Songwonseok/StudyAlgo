package Programmers.Baemin;

public class Solution1 {
	public int solution(String s, int N) {
		int answer = -1;

		if(s.length() == 0 || s.length() < N) {
			return answer;
		}

		char[] cArr = s.toCharArray();

		int start = 0;
		int end = N;

		do {
			if(isPandigitalNumber(cArr,start, end ,N)) {
				answer = Math.max(answer, Integer.parseInt(s.substring(start, end)));
			}
			
			start++;
			end++;

		} while(end < s.length());


		return answer;
	}

	public boolean isPandigitalNumber(char[] cArr, int start, int end, int N) {
		boolean[] visit = new boolean[10];

		for(int i = start; i < end; i++) {
			visit[cArr[i] - '0'] = true;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution1 a = new Solution1();

		System.out.println(a.solution("1", 2));
		;
	}
}
