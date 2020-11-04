package baek;

import java.io.*;
import java.util.*;

public class Main_11057_오르막수 {
	public static void DP(int[][] num, int n) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<=i;j++) {
				num[n][i] = (num[n][i] + num[n-1][j]) % 10007;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N+1][10];
		
		Arrays.fill(num[1], 1);
		
		for(int i=2;i<=N;i++) {
			DP(num, i);
		}
		int sum = 0;
		
		for(int i=0;i<10;i++) {
			sum = (sum + num[N][i]) % 10007;
		}
		System.out.println(sum);
	}

}
