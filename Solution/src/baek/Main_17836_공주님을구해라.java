package baek;

import java.io.*;
import java.util.*;

public class Main_17836_공주님을구해라 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		boolean[][] visit = new boolean[N][M];
		int[][] map = new int[N][M];
		int[] gram = new int[2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					gram[0] = i;
					gram[1] = j;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0,0,0});
		int min = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[2] > T || curr[2] >= min)
				break;
			if(curr[0] == gram[0] && curr[1] == gram[1]) {
				int cnt = curr[2] + Math.abs(curr[0] - (N-1)) + Math.abs(curr[1] - (M-1));
				min = Math.min(min, cnt);
				continue;
			}
			if(curr[0] == N-1 && curr[1] == M-1) {
				min = Math.min(min, curr[2]);
				continue;
			}
			
			for(int dir=0;dir<dx.length;dir++) {
				int nx = curr[0] + dx[dir];
				int ny = curr[1] + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] {nx, ny, curr[2]+1});
			}
		}
		if(min > T) 
			System.out.println("Fail");
		else 
			System.out.println(min);
	}

}
