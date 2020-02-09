package SW;


import java.io.*;
import java.util.*;

public class Solution_D4_1249_보급로 {
	public static int[][] arr, memo;
	public static int N;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (memo[ni][nj] != Math.min(memo[ni][nj], memo[curr[0]][curr[1]] + arr[ni][nj])) {
						memo[ni][nj] = memo[curr[0]][curr[1]] + arr[ni][nj];
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int INF = 987654321;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(memo[i], INF);
			}
			memo[0][0] = 0;
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = c[j] - '0';
				}
			}

			bfs(0, 0);

			System.out.println("#" + t + " " + memo[N - 1][N - 1]);
		}
	}
}