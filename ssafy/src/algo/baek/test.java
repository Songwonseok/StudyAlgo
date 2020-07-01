package algo.baek;

import java.util.Arrays;
import java.util.Scanner;

public class test {
	static final int msize = 10;
	static int[][] map;
	static boolean[][] isV;
	static int total_count;
	static int total;
	static int check_count;
	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[msize][msize];
		isV = new boolean[msize][msize];
		total_count = 0;
		total = 0;
		check_count = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < msize; i++) {
			for (int j = 0; j < msize; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					total++;
			}
		}

		check_all();
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void check_all() {
		if (check_count == total) {
			min = Math.min(min, total_count);
			return;
		}
		boolean isA = false;
		for (int i = 0; i < msize; i++) {
			for (int j = 0; j < msize; j++) {
				if (map[i][j] == 1 && !isV[i][j]) {
					for (int r = 5; r >= 1; r--) {
						isA = check_paper(i, j, r);
						if (isA) {
							for (int k = i; k < i + r; k++) {
								Arrays.fill(isV[k], j, j + r, true);
							}
							check_count += r * r;
							total_count++;
							papers[r]--;
							check_all();
							for (int k = i; k < i + r; k++) {
								Arrays.fill(isV[k], j, j + r, false);
							}
							check_count -= r * r;
							total_count--;
							papers[r]++;
						} else {
							continue;
						}
					}
					return;
				}
			}
		}
	}

	static boolean check_paper(int s_i, int s_j, int range) {
		for (int i = s_i; i < s_i + range; i++) {
			for (int j = s_j; j < s_j + range; j++) {
				if (i >= msize || i < 0 || j >= msize || j < 0 || map[i][j] == 0 || isV[i][j] || papers[range] == 0)
					return false;
			}
		}
		return true;
	}
}