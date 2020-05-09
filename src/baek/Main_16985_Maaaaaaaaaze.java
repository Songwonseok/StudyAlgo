package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16985_Maaaaaaaaaze {
	// 방향 중복조합 + 순열
	//
	static int[][][] map;
	static int[] comb, perm;
	static boolean[] v;
	static int min;
	// 동서남북 하
	static int[] dx = { 0, 0, 1, -1, 0, 0 }, dy = { 1, -1, 0, 0, 0, 0 }, dz = { 0, 0, 0, 0, -1, 1 };

	// 회전 제자리, 90, 180, 270
	public static int[][] rotation(int[][] board) {
		int[][] temp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[j][4 - i] = board[i][j];
			}
		}
		return temp;
	}

	// 방향
	public static void combi(int r) {
		if (r == 5) {
			permu(0);
			return;
		}
		for (int i = 0; i < 4; i++) {
			comb[r] = i;
			combi(r + 1);
		}
	}

	public static void permu(int r) {
		if (r == 5) {
			solve();
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!v[i]) {
				v[i] = true;
				perm[r] = i;
				permu(r + 1);
				v[i] = false;
			}
		}
	}

	public static void solve() {
		int[][][] temp = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = map[perm[i]][j].clone();
			}
		}

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < comb[perm[i]]; j++)
				temp[i] = rotation(temp[i]);

		if (temp[0][0][0] == 0 || temp[4][4][4] == 0)
			return;

		Queue<int[]> que = new LinkedList<>();
		boolean[][][] v = new boolean[5][5][5];

		que.add(new int[] { 0, 0, 0, 0 }); // z,x,y,cnt
		v[0][0][0] = true;

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			if (curr[3] > min)
				break;

			if (curr[0] == 4 && curr[1] == 4 && curr[2] == 4) {
				min = Math.min(min, curr[3]);
				break;
			}

			for (int dir = 0; dir < dx.length; dir++) {
				int nx = curr[1] + dx[dir];
				int ny = curr[2] + dy[dir];
				int nz = curr[0] + dz[dir];
				if (nz >= 0 && nz < 5 && nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !v[nz][nx][ny]
						&& temp[nz][nx][ny] == 1) {
					v[nz][nx][ny] = true;
					que.add(new int[] { nz, nx, ny, curr[3] + 1 });
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comb = new int[5];
		perm = new int[5];
		v = new boolean[5];
		map = new int[5][5][5];
		min = Integer.MAX_VALUE / 2;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());

				}
			}
		}

		combi(0);
		if (min == Integer.MAX_VALUE / 2)
			min = -1;

		System.out.println(min);

	}

}
