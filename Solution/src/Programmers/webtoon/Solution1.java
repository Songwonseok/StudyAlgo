package Programmers.webtoon;

import java.util.Arrays;

public class Solution1 {
	public int solution(int[] prices, int[] discounts) {
		int answer = 0;

		Arrays.sort(discounts);
		Arrays.sort(prices);

		int discountIndex = discounts.length - 1;

		for(int i=prices.length-1; i >= 0; i--){
			if(discountIndex >= 0){
				answer += prices[i] * (100 - discounts[discountIndex--]) / 100;
				continue;
			}
			answer += prices[i];
		}

		return answer;
	}
}
