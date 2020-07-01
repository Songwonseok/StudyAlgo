package dp;

import java.io.*;
import java.util.*;

public class TSPTest {
	public static int INF=987654321;
	public static int N;
	public static int[][] G;
	public static int[][] d;
	//public static int[][] m;
	
	public static int solve(int pos, int visited, int start) {
		//if(m[pos][visited]!=0) return m[pos][visited];
		if(visited==(1<<N)-1) return d[pos][start]; //return m[pos][visited]=d[pos][start];
		
		int ret=INF;
		for(int next=0; next<N; next++) {
			if((visited&(1<<next))==0 && d[pos][next]!=0){
				int tmp=d[pos][next]+solve(next,visited|(1<<next),start);
				ret=Math.min(ret,tmp);
			}
		}
		//m[pos][visited]=ret;
		//for(int[] a:m) System.out.println(Arrays.toString(a));
		//System.out.println();
		return ret;
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_tsp.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			G=new int[N][N];
			d=new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					G[i][j]=sc.nextInt();
					if(i!=j & G[i][j]==0) G[i][j]=INF;
				}
			}
			
			int ans=INF;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					d[j]=G[j].clone();
				}
				//m=new int[N][1<<N];
				int tmp=solve(i,1<<i,i);
				ans=Math.min(ans,tmp);
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}
