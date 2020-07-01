package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, L, cnt;
	static int[] di = {0,1}, dj= {1,0}; //우, 하
	static int[][] map;
	static boolean[][] road;
	
	
	
	public static boolean createRoad(int si,int sj,int dir ,int type) {
		int ni = si;
		int nj = sj;
		if(type ==0) {
			for(int i=0;i<L;i++) {
				ni += di[dir];
				nj += dj[dir];
				if(ni>=N || nj >= N)
					return false;
				if(map[si][sj] -1 != map[ni][nj]||road[ni][nj]) {
					return false;
				}
			}
			ni = si;
			nj = sj;
			for(int i=0;i<L;i++) {
				ni += di[dir];
				nj += dj[dir];
				road[ni][nj] = true;
			}
			return true;
		}else {
			if(road[si][sj])
				return false;
			
			for(int i=0;i<L-1;i++) {
				ni -= di[dir];
				nj -= dj[dir];
				if(ni<0 || nj <0)
					return false;
				if(map[si][sj] != map[ni][nj] || road[ni][nj])
					return false;
			}
			ni = si;
			nj = sj;
			road[ni][nj] = true;
			for(int i=0;i<L-1;i++) {
				ni -= di[dir];
				nj -= dj[dir];
				road[ni][nj] = true;
			}
			return true;
		}
	}
	
	public static void solve(int si,int sj, int dir) {
		road = new boolean[N][N];
		int ni = si;
		int nj = sj;
		int height = map[si][sj];
		for(int i=0;i<N-1;i++) {
			ni += di[dir];
			nj += dj[dir];
			if(map[ni][nj] != height) {
				if(Math.abs(height - map[ni][nj]) >=2)
					return;
				else if(height - map[ni][nj] >0){
					if(!createRoad(ni-di[dir],nj-dj[dir],dir,0)) {
						return;
					}
				}else {
					if(!createRoad(ni-di[dir],nj-dj[dir],dir,1)) {
						return;
					}
				}
				height = map[ni][nj];
			}
		}
		
		if(ni+nj== si+sj+N-1)
			cnt++;
		
	}
	
	
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			solve(i,0,0); // 우
			solve(0,i,1); // 하
		}
		System.out.println(cnt);

	}

}
