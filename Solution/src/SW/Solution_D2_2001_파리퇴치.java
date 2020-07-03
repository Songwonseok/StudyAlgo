package SW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {
	static int N,M, max;
	static int[][] flies;

	public static void catchFly(int x, int y) {
		int sum = 0;
		
		for(int i=x;i<x+M;i++) {
			for(int j=y;j<y+M;j++) {
				sum += flies[i][j];
			}
		}
		max = Math.max(max, sum);
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flies = new int[N][N];
			max = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					catchFly(i,j);
				}
			}
			
			
			System.out.println("#"+tc+" "+max);
		}
		
		
	}

}
