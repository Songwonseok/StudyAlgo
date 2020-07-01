package algo.baek;


import java.io.*;
import java.util.*;

/*
3
2 2
1 5
13 29
*/
public class Main_1010_다리놓기_송원석 {
	static int cnt,N,M;
	static boolean[] v;
	public static void dfs(int r, int n) {
		if(r == N) {
			cnt++;
			return;
		}
		for(int i=n;i<M;i++) {
			if(!v[i]) {
				v[i]=true;
				dfs(r+1,i);
				v[i]=false;
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); 
		
		for(int tc=1;tc<=T;tc++) {
			cnt =0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new boolean[M];
			dfs(0,0);
			
			System.out.println(cnt);
			
		}
		
	}

}
