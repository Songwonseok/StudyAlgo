package algo.baek;

import java.io.*;
import java.util.*;

public class Main_백준_14890_경사로_서울9반_송원석 {
	static int N, L, result;
	static int[] di = { 0, 1 }, dj = { 1, 0 }; // ��, ��
	static int[][] map;
	static boolean[][] road;

	public static boolean createRoad(int si, int sj, int dir, int type) {
		int ni = si;
		int nj = sj;
		if (type == 0) {
			for (int i = 0; i < L; i++) {
				ni += di[dir];
				nj += dj[dir];
				if (ni >= N || nj >= N)
					return false;
				if (map[ni][nj] != map[si][sj] - 1 || road[ni][nj]) {
					return false;
				}
			}
			ni = si;
			nj = sj;
			for (int i = 0; i < L; i++) {
				ni += di[dir];
				nj += dj[dir];
				road[ni][nj] = true;
			}
			return true;
		} else {
			ni = si;
			nj = sj;
			if(road[si][sj])
				return false;
			for (int i = 0; i < L-1; i++) {
				ni -= di[dir];
				nj -= dj[dir];
				if (ni <0 || nj <0 )
					return false;
				if (map[ni][nj] != map[si][sj] || road[ni][nj]) {
					return false;
				}
			}
			ni = si;
			nj = sj;
			road[si][sj] = true;
			for (int i = 0; i < L-1; i++) {
				ni -= di[dir];
				nj -= dj[dir];
				road[ni][nj] = true;
			}
			return true;
		}
	}

	public static boolean CheckRoad(int si, int sj, int dir) {
		int ni = si;
		int nj = sj;
		int high = map[si][sj];
		// ���� or �� ���� üũ
		road = new boolean[N][N];
		for (int i = 1; i < N; i++) {
			ni += di[dir];
			nj += dj[dir];
			if (map[ni][nj] != high) {
				if (Math.abs(map[ni][nj] - high) >= 2)
					return false;
				else {
					if (high - map[ni][nj] > 0) {
						if (!createRoad(ni - di[dir], nj - dj[dir], dir,0)) {
							break;
						}
					} else {
						if (!createRoad(ni - di[dir], nj - dj[dir], dir,1)) {
							break;
						}
					}
					high = map[ni][nj];
				}
			}
			if (ni + nj == si + sj + N - 1)
				return true;

		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if (CheckRoad(0, i, 1)) // ��
				result++;
			if (CheckRoad(i, 0, 0)) // ��
				result++;
		}

		System.out.println(result);

	}

}
