package baek;

import java.io.*;
import java.util.*;

public class Main_1010_다리놓기_다시 {
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[31][31];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i=2;i<=30;i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
			for(int j=1;j<i;j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[n][r]);
			
		}
	}

}
