package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11055_가장큰증가부분수열 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] DP = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = A[0];
		int answer = DP[0];
		
		for(int i=1;i<N;i++) {
			DP[i] = A[i];
			for(int j=i-1;j>=0;j--) {
				if(A[j] < A[i] && DP[i] < DP[j] + A[i]) {
					DP[i] = DP[j] + A[i];
				}
			}
			answer = Math.max(answer, DP[i]);
		}
		
		System.out.println(answer);
	}

}
