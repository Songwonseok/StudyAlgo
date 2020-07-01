package SW;

import java.io.*;
import java.util.*;

public class Solution_D9_1953_탈주범검거_서울9반_송원석 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1953.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine().trim());
		int[][] dx = { {}, { -1, 0, 1, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] dy = { {}, { 0, 1, 0, -1 }, { 0, 0 }, { 1, -1 }, { 0, 1 }, { 0, 1 }, { -1, 0 }, { -1, 0 } };
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] v = new int[N][M];
			Queue<Integer> que = new LinkedList<>();

			que.offer(R * M + C);
			int time = 1;
			int size = 1;
			int cnt = 1;
			v[R][C] = time;
			while (!que.isEmpty()) {
				if (time == L)
					break;
				time++;
				for (int i = 0; i < size; i++) {
					int x = que.peek() / M;
					int y = que.poll() % M;
					int num = map[x][y];
					for (int dir = 0; dir < dx[num].length; dir++) {
						int nx = x + dx[num][dir];
						int ny = y + dy[num][dir];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && v[nx][ny] == 0 && map[nx][ny] != 0) {
							if (dx[num][dir] == 1 || dx[num][dir] == -1) {
								for (int k = 0; k < dx[map[nx][ny]].length; k++) {
									if (dx[map[nx][ny]][k] == -dx[num][dir]) {
										v[nx][ny] = time;
										que.add(nx * M + ny);
										cnt++;
										break;
									}
								}
							} else if (dy[num][dir] == 1 || dy[num][dir] == -1) {
								for (int k = 0; k < dy[map[nx][ny]].length; k++) {
									if (dy[map[nx][ny]][k] == -dy[num][dir]) {
										v[nx][ny] = time;
										que.add(nx * M + ny);
										cnt++;
										break;
									}
								}
							}
						}
					}
				}
					size = que.size();

			} // tc
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
