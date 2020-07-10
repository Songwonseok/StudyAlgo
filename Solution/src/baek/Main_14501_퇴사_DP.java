package baek;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사_DP {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] time = new int[N+1];
		int[] pay = new int[N+1];
		int[] DP = new int[N+1];
		
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			if(i+time[i] <= N+1) {
				int max = 0;
				DP[i] = pay[i];
				
				for(int j=1;j<i;j++) {
					if(j+time[j] <= i && DP[j] > max) {
						max = DP[j];
					}
				}
				DP[i] += max;
			}
			if(DP[i] > answer)
				answer = DP[i];
		}
		
		System.out.println(answer);
	}

}
