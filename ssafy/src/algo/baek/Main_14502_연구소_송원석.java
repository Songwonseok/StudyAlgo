package algo.baek;

import java.util.*;
import java.io.*;

public class Main_14502_연구소_송원석 {
	static int[][] ar,lab;
	static int N,M,max;
	static Queue<int[]> virus;
	static boolean[][] visit;
	
	
	public static void comb(int s_i,int s_j,int r) {
		if(r==3) {
			spread(ar);
			return;
		}
		
		for(int i=s_i;i<N;i++) {
			for(int j=s_j;j<M;j++) {
				if(!visit[i][j] && lab[i][j] ==0) {
					visit[i][j] = true;
					ar[r][0] = i;
					ar[r][1] = j;
					comb(i,j+1,r+1);
					visit[i][j] = false;
				}				
			}
			s_j=0;			
		}
	}
	
	public static void spread(int[][] a){
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i] = lab[i].clone();
			}
		}
		for(int i=0;i<3;i++) {
				temp[a[i][0]][a[i][1]] = 1;
		}
		Queue<int[]> spread = new LinkedList<>();
		spread.addAll(virus);
		
		
		while(!spread.isEmpty()) {
			int[] curr = spread.poll();
			
			for(int i=0;i<4;i++) {
				int nx = curr[0]+di[i];
				int ny = curr[1]+dj[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && temp[nx][ny] == 0) {
					temp[nx][ny] = 2;
					spread.offer(new int[] {nx,ny});
				}
			}
			
		}
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}

		max= Math.max(max, cnt);
		
	}
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		virus = new LinkedList<>();
		max = 0;
		visit = new boolean[N][M];
		ar= new int[3][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					virus.offer(new int[] {i,j});
				}
			}
		}
		comb(0,0,0);
		
		System.out.println(max);

		
	}
	
	
	
	
}
