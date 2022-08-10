package Programmers.toss.test_220806;

import java.util.Arrays;

public class Solution2_220806 {
	public int solution(int[] levels) {
		Arrays.sort(levels);

		int index = (int)Math.ceil(((double)levels.length / 4 * 3));

		if(index >= levels.length) {
			return -1;
		}


		return levels[index];
	}

	public static void main(String[] args) {
		Solution2_220806 solve = new Solution2_220806();

		System.out.println(solve.solution(new int[] {1,2,3,4,5,6,7,8,9}));

	}
}
