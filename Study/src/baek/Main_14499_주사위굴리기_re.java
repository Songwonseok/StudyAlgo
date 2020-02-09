package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기_re {

	static class Dice {
		int x, y;
		int east, west, south, north, top, bottom;

		Dice(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void up() {
			int temp = this.bottom;
			this.bottom = this.north;
			this.north = this.top;
			this.top = this.south;
			this.south = temp;
		}

		public void down() {
			int temp = this.bottom;
			this.bottom = this.south;
			this.south = this.top;
			this.top = this.north;
			this.north = temp;
		}

		public void left() {
			int temp = this.bottom;
			this.bottom = this.west;
			this.west = this.top;
			this.top = this.east;
			this.east = temp;
		}

		public void right() {
			int temp = this.bottom;
			this.bottom = this.east;
			this.east = this.top;
			this.top = this.west;
			this.west = temp;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Dice dice = new Dice(X, Y);
		int[] dx = { 0, 0, 0, -1, 1 }, dy = { 0, 1, -1, 0, 0 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = dice.x + dx[dir];
			int ny = dice.y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			dice.x = nx;
			dice.y = ny;

			if (dir == 1)
				dice.right();
			else if (dir == 2)
				dice.left();
			else if (dir == 3)
				dice.up();
			else
				dice.down();
			
			if (map[nx][ny] == 0) {
				map[nx][ny] = dice.bottom;
			} else {
				dice.bottom = map[nx][ny];
				map[nx][ny] = 0;
			}
			System.out.println(dice.top);
		}
	}
}
