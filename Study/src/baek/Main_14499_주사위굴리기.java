package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
	int x, y;
	int num;
	public Dice(int x, int y) {
		this.x = x;
		this.y = y;
		this.num =0;
	}
}

public class Main_14499_주사위굴리기 {
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] number = {{2,3,1,4},{2,3,5,1},{5,0,1,4},{0,6,1,4},{2,3,0,5},{2,3,4,1}}; //0~5번 면의 동서북남+반대편 번호
		int[] side = {5,4,3,2,1,0};
		int[] value = new int[6];
		Dice dice = new Dice(x, y);
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int nx = dice.x + dx[dir];
			int ny = dice.y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			dice.x = nx;
			dice.y = ny;
			dice.num = number[dice.num][dir];
			if(map[nx][ny] ==0) {
				map[nx][ny] = value[dice.num];
			}else {
				value[dice.num] = map[nx][ny];
				map[nx][ny]=0;
			}
			System.out.println(value[side[dice.num]]);
		}

	}

}