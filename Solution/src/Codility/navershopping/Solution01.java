package Codility.navershopping;

/*

 */
public class Solution01 {
	public static void main(String[] args) {
		int[] start = {};
		int[] dest = {};
		int[] limit = {};
		System.out.println(solution(start, dest, limit));
	}

	public static int solution(int[] start, int[] dest, int[] limit) {
		int cost = 0;
		int largest = -1;

		for(int i = 0; i < start.length; i++) {
			largest = Math.max(largest, Math.max(start[i], dest[i]));

			cost += 2 * Math.abs(start[i] - dest[i]) + 1;
		}

		return Math.min(limit[largest], cost);
	}
}
