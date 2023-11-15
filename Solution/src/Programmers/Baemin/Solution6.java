package Programmers.Baemin;

import java.util.Arrays;

public class Solution6 {
	public int solution(int[] prices, int k) {
		int answer = -1;

		for(int i =0; i < prices.length - k; i++) {
			int[] sub = Arrays.copyOfRange(prices, i + 1, prices.length);

			Arrays.sort(sub);

			int buy = prices[i];

			int sum = 0;
			for(int j = sub.length - k; j < sub.length; j++) {
				sum += sub[j] - buy;
			}

			answer = Math.max(answer, sum);
		}

		if(answer <= 0) {
			return -1;
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] price = {10, 8, 6, 5, 7, 6, 4, 2, 1};
		int k = 4;

		Solution6 s7 = new Solution6();

		System.out.println(s7.solution(price, k));
	}
}
