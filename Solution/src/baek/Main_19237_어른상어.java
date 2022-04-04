package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_19237_어른상어 {
	static int[][][] map;
	static int N, M, k, time;
	static HashMap<Integer, Integer> locMap;
	static int[] moveX = {0, -1, 1, 0, 0}; // {x , 상, 하, 좌, 우}
	static int[] moveY = {0, 0, 0, -1, 1}; // {x , 상, 하, 좌, 우}

	static class Shark {
		int x, y, number; // 현재 위치, 이전 위치, 번호
		int currDir;
		int[][] dirInfo;
		boolean isSurvive;

		Shark(int x, int y, int number) {
			this.x = x;
			this.y = y;
			this.number = number;
			dirInfo = new int[5][4];
			isSurvive = true;
		}

		void move() {
			int sx = x;
			int sy = y;

			for (int i = 0; i < 4; i++) {
				int nx = x + moveX[dirInfo[currDir][i]];
				int ny = y + moveY[dirInfo[currDir][i]];

				// 맵 범위 확인
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				// 냄새가 남은 구역인지 확인
				if (map[nx][ny][0] != -1 && map[nx][ny][0] + k >= time + 1) {
					continue;
				}

				x = nx;
				y = ny;
				currDir = dirInfo[currDir][i];

				int loc = (nx * N) + ny;

				// 숫자가 작은 순서부터 이동하기 때문에 겹치면 무조건 잡아먹힌다.
				if (locMap.containsKey(loc)) {
					isSurvive = false;
					return;
				}

				locMap.put(loc, number);
				return;
			}

			// 4방향 모두 움직일 수 없는 경우 자신의 영역으로 이동
			for (int i = 0; i < 4; i++) {
				int nx = x + moveX[dirInfo[currDir][i]];
				int ny = y + moveY[dirInfo[currDir][i]];

				// 맵 범위 확인
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				// 자신의 영역인지 확인
				if (map[nx][ny][1] == number) {
					x = nx;
					y = ny;
					currDir = dirInfo[currDir][i];

					int loc = (nx * N) + ny;
					locMap.put(loc, number);
					return;
				}
			}
		}
	}

	public static boolean isFinished(Shark[] sharks) {
		int count = 0;

		for (Shark shark : sharks) {
			if (shark.isSurvive) {
				count++;

				if (count > 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N][2]; // 시간, 상어번호
		time = 0;

		Shark[] sharks = new Shark[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				Arrays.fill(map[i][j], -1);
				int value = Integer.parseInt(st.nextToken());

				if (value > 0) {
					map[i][j][0] = time;
					map[i][j][1] = value;
					sharks[value - 1] = new Shark(i, j, value);
				}

			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int dir = Integer.parseInt(st.nextToken());
			sharks[i].currDir = dir;
		}

		for (int i = 0; i < M; i++) {
			for (int dir = 1; dir <= 4; dir++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 4; j++) {
					sharks[i].dirInfo[dir][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		locMap = new HashMap<>();
		while (!isFinished(sharks)) {
			for (Shark shark : sharks) {
				if(!shark.isSurvive)
					continue;

				shark.move();
			}

			for (Map.Entry<Integer, Integer> entry : locMap.entrySet()) {
				int x = entry.getKey() / N;
				int y = entry.getKey() % N;

				map[x][y][0] = time + 1;
				map[x][y][1] = entry.getValue();

			}

			locMap.clear();
			time++;

			if (time > 1000) {
				time = -1;
				break;
			}
		}

		System.out.println(time);
	}
}
