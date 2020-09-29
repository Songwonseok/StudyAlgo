package Steet_11;


/*
 * [1...N]범위의  길이가 N인 배열을 모든 숫자가 겹치지 않게 바꾸는 최소 횟수
 * 
 */

import java.util.Arrays;

public class Solution3 {
	public static int solution(int[] A) {
		Arrays.sort(A);
		int cnt = 0;
		
		for(int i=0;i<A.length;i++) {
			cnt += Math.abs(A[i] - (i+1)); 
			if(cnt > 100000000) return -1;
		}
		return cnt;
    }
	public static void main(String[] args) {
		int[] aa = {6,2,3,5,6,3};
		System.out.println(solution(aa));

	}

}
