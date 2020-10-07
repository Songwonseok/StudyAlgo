package baek;

import java.io.*;
import java.util.*;

public class Main_1890_점프 {
	static int N;
	static int[][] map;
	static long [][]memo;
	public static long solve(int x, int y) {
		if(x == N-1 && y == N-1)
			return 1;
		if(map[x][y] == 0)
			return 0;
		
		int size = map[x][y];
		int nx = x + size;
		int ny = y + size;
		
		long cnt = 0;
		
		if(nx <N) {
			if(memo[nx][y] != 0)
				cnt += memo[nx][y];
			else
				cnt += solve(nx,y);
		}
		if(ny < N) {
			if(memo[x][ny] != 0)
				cnt += memo[x][ny];
			else
				cnt += solve(x,ny);
		}
		memo[x][y] = cnt;
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new long[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(0,0));
	}

}
