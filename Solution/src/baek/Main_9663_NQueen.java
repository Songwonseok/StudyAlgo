package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	static int N, count;
	static boolean[][] board;
	static boolean[] visitRow;
	static int[] dx = {-1, -1}, dy = {-1, 1}; // 좌상, 상, 우상

	public static boolean isValid(int x, int y) {
		for (int dir = 0; dir < 2; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			while (nx >= 0 && ny >= 0 && ny < N) {
				if (board[nx][ny]) {
					return false;
				}

				nx += dx[dir];
				ny += dy[dir];
			}
		}

		return true;
	}

	public static void solve(int x) {
		if (x == N) {
			count++;
			return;
		}

		for (int y = 0; y < N; y++) {
			if(visitRow[y]){
				continue;
			}

			if (isValid(x, y)) {
				board[x][y] = true;
				visitRow[y] = true;
				solve(x + 1);
				visitRow[y] = false;
				board[x][y] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;

		board = new boolean[N][N];
		visitRow = new boolean[N];

		solve(0);

		System.out.println(count);
	}
}
