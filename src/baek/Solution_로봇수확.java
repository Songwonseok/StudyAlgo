package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_로봇수확 {
	static int[][] map;
	static int N, M, result;
	// 오른 앞 왼 뒤
	// 0 1 2 3
	// 북 서 남 동
	// +3, 0, 1,+2
	static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 }, ddir = { 3, 0, 1, 2 };

	static class Robot {
		int x, y;
		int dir;
		int cops;

		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cops = 0;
		}
	}

	static class Seed {
		int x, y;
		int change;

		public Seed(int x, int y, int change) {
			this.x = x;
			this.y = y;
			this.change = change;
		}
	}

	public static void solve(Robot r) {
		ArrayList<Seed> list = new ArrayList<>();
		HashSet<Integer> crops = new HashSet<>(); //
		int[][] smap = new int[N][N]; // 몇번 심었는지
		boolean[][] v = new boolean[N][N]; // 씨앗이 자라고 있는지
		int time = 1;

		while (time <= M) {

			// 오전
			// 갈 수 있는지 확인

			if (crops.contains(r.x * N + r.y)) {
				r.cops++;
				crops.remove(r.x *N +r.y);
			} else {
				boolean check = false;
				for (int i = 0; i < 4; i++) {
					int nx = r.x + dx[(r.dir + i) % 4];
					int ny = r.y + dy[(r.dir + i) % 4];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1 && !v[nx][ny]) {
						check = true;
						break;
					}
				}
				if (check) {
					list.add(new Seed(r.x, r.y, smap[r.x][r.y] + 5));
					smap[r.x][r.y]++;
					v[r.x][r.y] = true;
				}
			}
			// 오후 //내일이면 씨앗으로 변하는지 여부?
			for (int i = 0; i < 4; i++) {
				int nx = r.x + dx[(r.dir + i) % 4];
				int ny = r.y + dy[(r.dir + i) % 4];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1 && !v[nx][ny]) {
					r.x = nx;
					r.y = ny;
					r.dir = (r.dir + ddir[i]) % 4;
					break;
				}
			}
			// 씨앗 발아
						int start = list.size() - 1;
						for (int i = start; i >= 0; i--) {
							Seed s = list.get(i);
							s.change--;
							if (s.change == 0) {
								crops.add(s.x * N + s.y);
								v[s.x][s.y] = false;
								list.remove(s);
							}
						}
			time++;
		}
		result = Math.max(result, r.cops);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int dir = 0; dir < 4; dir++) {
							solve(new Robot(i, j, dir));
						}
					}
				}
			}
			System.out.println("#" + tc + " " + result);

		}
	}

}
