package baek;

import java.io.*;
import java.util.*;

public class Main_1182_부분수열의합 {
	static int cnt, N, S;
	static int[] arr;
	public static void solve(int idx, int sum) {
		
		if(idx == N)
			return;
		sum += arr[idx];
		
		if(sum == S) cnt++;
		
		solve(idx+1, sum - arr[idx]);
		solve(idx+1, sum);
		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		
		solve(0,0);
		System.out.println(cnt);

	}

}
