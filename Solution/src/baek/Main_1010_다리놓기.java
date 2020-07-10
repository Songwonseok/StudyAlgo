package baek;

import java.io.*;
import java.util.*;

public class Main_1010_다리놓기 {
	
	static int nCr(int[][] dp, int n, int r) {
		
		if(dp[n][r] != 0) 
			return dp[n][r];
		if(n == r || r == 0)
			return 1;
		
		return nCr(dp,n-1,r-1) + nCr(dp,n-1,r);
	}
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[31][31];
		
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			System.out.println(nCr(dp,n,r));
			
		}
	}

}
