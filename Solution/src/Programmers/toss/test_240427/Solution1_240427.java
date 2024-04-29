package Programmers.toss.test_240427;

import java.util.Arrays;

public class Solution1_240427 {
	public static int solution(int[] levels) {
		int size = levels.length;

		if(size < 4) {
			return -1;
		}

		Arrays.sort(levels);

		int index = size / 4;

		return levels[levels.length - index];
	}

	public static void main(String[] args) {
		int[] levels = {1,2,3,4,5,6,7,8,9};

		System.out.println(solution(levels));

	}
}
