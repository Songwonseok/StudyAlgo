package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809_Gaaaaaaaaaarden {
	public static class CultureMedium{
		int x,y,seq;
		boolean color; // G = false, R = true
		
		public CultureMedium(int x, int y, boolean color, int seq) {
			this.x = x;
			this.y = y;
			this.seq= seq;
			this.color = color;
		}
	}
	
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int N,M,R,G,max;
	static int[][] garden;
	static boolean[][] visit;
	static CultureMedium[] cm;
	static int[] loc;
	
	public static void solve() {
		boolean[][] v = new boolean[N][M];
		int[][] map = new int[N][M];
		HashSet<Integer> set = new HashSet<>(); // ²ÉÀÇ À§Ä¡
		
		for(int i=0;i<N;i++)
			v[i] = visit[i].clone();
		
		Queue<CultureMedium> que = new LinkedList<>();
		
		for(int i=0;i<R+G;i++) {
			que.add(cm[i]);
		}
		
		while(!que.isEmpty()) {
			CultureMedium curr = que.poll();
			if(set.contains(curr.x*M+curr.y))
				continue;
			
			for(int i=0;i<4;i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx >=0 && nx <N && ny >=0 && ny <M 
						&& !v[nx][ny] && garden[nx][ny] != 0) {
					v[nx][ny] = true;
					map[nx][ny] = curr.seq+1;
					que.add(new CultureMedium(nx, ny, curr.color,curr.seq+1));	
					v[nx][ny] = false;
				}else if(v[nx][ny] && map[nx][ny] == curr.seq+1) {
					set.add(nx*M+ny);
				}
			}
		}
		max = Math.max(max, set.size());
	}
	
	
	
	
	public static void comb2(int red, int green, int r) {
		if(r== R+G) {
			solve();
			return;
		}
		
		if(red >0) {
			cm[r] = new CultureMedium(loc[r]/M, loc[r]%M, true,0);
			comb2(red-1,green,r+1);
		}
		if(green >0) {
			cm[r] = new CultureMedium(loc[r]/M, loc[r]%M, false,0);
			comb2(red,green-1,r+1);
		}
	}
	
	
	public static void comb(int si, int sj, int r) {
		if(r == R+G) {
			comb2(R,G,0);
			return;
		}
		
		for(int i=si;i<N;i++) {
			for(int j=sj;j<M;j++) {
				if(garden[i][j] == 2 && !visit[i][j]) {
					visit[i][j] = true;
					loc[r] = i*M+j;
					comb(i,j,r+1);
					visit[i][j] = false;
				}
			}
			sj=0;
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		for(int i=0;i<R;i++) {
			
		}
		
		garden = new int[N][M];
		visit = new boolean[N][M];
		max=0;
		cm = new CultureMedium[R+G];
		loc = new int[R+G];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0,0);
		System.out.println(max);
		
	}
}
