package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[][] DP = new int[2][N+1];
		
		for(int i=1;i<=N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		DP[0][1] = stairs[1];
		
		for(int i=2;i<=N;i++) {
			DP[0][i] = Math.max(DP[0][i-2], DP[1][i-2]) + stairs[i];
			DP[1][i] = DP[0][i-1] + stairs[i];
		}
		
		System.out.println(Math.max(DP[0][N], DP[1][N]));
	}
}
