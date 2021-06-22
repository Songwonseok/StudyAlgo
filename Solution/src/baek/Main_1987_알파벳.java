package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static boolean[] visit;
	static int[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int R,C,max;

	public static void dfs(int x, int y, int size) {
		if(size > max){
			max = size;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(nx < 0 || nx >= R || ny < 0 || ny >=C || visit[board[nx][ny]]){
				continue;
			}
			visit[board[nx][ny]] = true;
			dfs(nx, ny, size+1);
			visit[board[nx][ny]] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		visit = new boolean[26]; // 알파벳 A ~ Z
		max = 0;

		for (int i = 0; i < R; i++) {
			char[] charArray = br.readLine().toCharArray();
			for(int j=0;j<C;j++){
				board[i][j] = charArray[j] - 'A';
			}
		}

		visit[board[0][0]] = true;
		dfs(0,0,1);

		System.out.println(max);
	}
}
