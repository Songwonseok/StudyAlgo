package baek;

import java.io.*;
import java.util.*;

public class Main_1600_말이되고픈원숭이 {
	public static class Monkey{
		int x,y,k,cnt;
		public Monkey(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		
		int[] dx = {-1, 0, 1, 0}, dy = {0,1,0,-1}; // 시계방향
		int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
		
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][][] visit = new boolean[K+1][H][W];
		
		Queue<Monkey> queue = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		
		visit[0][0][0] = true;
		
		queue.add(new Monkey(0,0,0,0)); // x,y,k,cnt
		int cnt = 0;
		while(!queue.isEmpty()) {
			Monkey curr = queue.poll();
			cnt++;
			
			if(curr.cnt >= min) 
				break;
			
			
			if(curr.x == H-1 &&  curr.y == W-1) {
				min = Math.min(min, curr.cnt);
				continue;
			}
			
			for(int dir=0;dir<dx.length;dir++) {
				int nx = curr.x + dx[dir];
				int ny = curr.y + dy[dir];
				
				if(nx < 0 || nx >= H || ny <0 || ny >= W || visit[curr.k][nx][ny] || map[nx][ny] == 1)
					continue;
				visit[curr.k][nx][ny] = true;
				queue.add(new Monkey(nx,ny, curr.k, curr.cnt + 1));
			}
			
			if(curr.k < K ) {
				for(int dir = 0; dir<hx.length;dir++) {
					int nx = curr.x + hx[dir];
					int ny = curr.y + hy[dir];
					
					if(nx < 0 || nx >= H || ny <0 || ny >= W || visit[curr.k+1][nx][ny] || map[nx][ny] == 1)
						continue;
					visit[curr.k + 1][nx][ny] = true;
					queue.add(new Monkey(nx,ny,curr.k+1, curr.cnt+1));
				}
			}
		}
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
		
	}

}
