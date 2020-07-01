package dp;

import java.io.*;
import java.util.*;
//메모이제이션 사용.
public class TSPTest1 {
	public static int INF=987654321;
	public static int N;
	public static int[][] G;
	public static int[][] d;
	//
	public static int[][] m; //메모이제이션
	
	public static int solve(int pos, int visited, int start) { //pos는 내 현재 위치. start는 시작위치이자 도착위치.
		//
		if(m[pos][visited]!=0) return m[pos][visited]; //한번이라도 계산을 해놨으면~
		if(visited==(1<<N)-1) //return d[pos][start]; //
			return m[pos][visited]=d[pos][start];
		
		int ret=INF;
		for(int next=0; next<N; next++) {
			if((visited&(1<<next))==0 && d[pos][next]!=0){ //방문하지 않았고 현재 값이 0이 아니면
				int tmp=d[pos][next]+solve(next,visited|(1<<next),start); //얘가 핵심!!
				ret=Math.min(ret,tmp);
			}
		}
		//
		m[pos][visited]=ret;
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
				//원본을 복제해서 작업
				m=new int[N][1<<N];
				int tmp=solve(i,1<<i,i); //원래 자기자리로 돌아오도록. 그래서 pos랑start가 같아야함
				ans=Math.min(ans,tmp);
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}
