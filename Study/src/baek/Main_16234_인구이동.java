package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void solve(int x, int y) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(x*N+y);
		int sum = map[x][y];
		Queue<Integer> que = new LinkedList<>();
		que.add(x * N + y);
		while (!que.isEmpty()) {
			int cx = que.peek() / N;
			int cy = que.poll() % N;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !v[nx][ny] && Math.abs(map[cx][cy] - map[nx][ny]) >= L
						&& Math.abs(map[cx][cy] - map[nx][ny]) <= R) {
					v[nx][ny] = true;
					sum += map[nx][ny];
					list.add(nx*N+ny);
					que.add(nx*N+ny);
				}
			}
		}
		for(int i=0;i<list.size();i++) {
			int cx = list.get(i)/N;
			int cy = list.get(i)%N;
			map[cx][cy] = sum/list.size();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		while (true) {
			v = new boolean[N][N];
			
			int check=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!v[i][j]) {
						v[i][j] = true;
						boolean flag = false;
						for(int dir=0;dir<4;dir++) {
							int nx = i+dx[dir];
							int ny = j+dy[dir];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && !v[nx][ny] && Math.abs(map[i][j] - map[nx][ny]) >= L
									&& Math.abs(map[i][j] - map[nx][ny]) <= R) {
								flag = true;
								break;
							}
						}
						if(flag) {
							solve(i,j);
							check++;
						}
					}
				}
			}
			
			if(check ==0) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
