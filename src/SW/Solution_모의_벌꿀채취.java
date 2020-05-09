package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_모의_벌꿀채취 {
	static int N,M,C,max,honey,result;
	static int[][] honeycomb;
	static boolean[][] v;
	static boolean[] flag;
	static int[][] worker;
	
	public static void maxHoney(int n,int r, int start,int total) {
		if(r==M) {
			int sum=0;
			for(int i=0;i<M;i++) {
				if(flag[i]) {
					sum += Math.pow(worker[n][i], 2);
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		boolean check = false;
		for(int i=start;i<M;i++) {
			if(!flag[i] && total-worker[n][i] >=0) {
				flag[i] = true;
				check = true;
				maxHoney(n,r+1,i,total-worker[n][i]);
				flag[i] = false;
			}
		}
		if(!check){
			maxHoney(n,r+1,start,total);
		}
		
	}
	
	
	
	public static void comb(int si, int sj, int r) {
		if(r==2) {
			honey=0;
			
			for(int i=0;i<2;i++) {
				max=0;
				flag = new boolean[M];
				maxHoney(i,0,0,C);
				honey += max;
			}
			result = Math.max(result, honey);
			return;
		}
		for(int i=si;i<N;i++) {
			for(int j=sj;j<N;j++) {
				if(!v[i][j] && j+M <= N) {
					for(int n=0;n<M;n++) {
						v[i][j+n] = true;
						worker[r][n] = honeycomb[i][j+n];
					}
					comb(i,j+M-1,r+1);
					for(int n=0;n<M;n++) {
						v[i][j+n] = false;
					}
				}
			}
			sj=0;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			worker = new int[2][M];
			
			honeycomb = new int[N][N];
			v = new boolean[N][N];
			result=0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					honeycomb[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0,0);
			System.out.println("#"+tc+" "+result);
		}
	}

}
