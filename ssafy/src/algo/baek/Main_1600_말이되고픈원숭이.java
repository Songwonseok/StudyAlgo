package algo.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static int[] hx = {-2,-1,1,2,2,1,-1,-2}, hy= {1,2,2,1,-1,-2,-2,-1},
			dx = {-1,1,0,0}, dy= {0,0,-1,1};
	static int[][] map;
	static boolean[][][] v;
	static int W,H,K;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map = new int[H][W];
		v = new boolean[H][W][K+1];
			
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {0,0,0,0}); //x,y,k,cnt
		v[0][0][0]=true;
		int result=0;
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			int x = curr[0];
			int y = curr[1];
			int k = curr[2];
			int cnt = curr[3];
			
			if(x==H-1 && y == W-1) {
				result=cnt;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx= x+dx[i];
				int ny= y+dy[i];
				if(nx>=0 && nx < H && ny>=0 && ny<W && map[nx][ny] ==0 && !v[nx][ny][k]) {
					v[nx][ny][k] = true;
					que.add(new int[] {nx,ny,k,cnt+1});
				}
			}
			if(k<K) {
				for(int i=0;i<8;i++) {
					int nx= x+hx[i];
					int ny= y+hy[i];
					if(nx>=0 && nx < H && ny>=0 && ny<W && map[nx][ny] ==0 && !v[nx][ny][k+1]) {
						v[nx][ny][k+1] = true;
						que.add(new int[] {nx,ny,k+1,cnt+1});
					}
				}
				
			}
		}
		if(result==0)
			System.out.println(-1);
		else
			System.out.println(result);
		
		
	}

}
