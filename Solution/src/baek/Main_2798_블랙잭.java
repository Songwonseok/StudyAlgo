package baek;

import java.io.*;
import java.util.*;

public class Main_2798_블랙잭 {
	static boolean[] visit;
	static int[] combResult, nums;
	static int N,M, result;
	
	public static void comb(int start, int depth) {
		if(result == M) return;
		
		if(depth == 3) {
			int sum=0;
			for(int i=0;i<3;i++) {
				sum += combResult[i];
			}
			if(sum > M) return;
			
			if(sum > result) {
				result = sum;
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				combResult[depth] = nums[i];
				comb(i,depth+1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		combResult = new int[3];
		
		visit = new boolean[N];
		result = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		comb(0,0);
		
		System.out.println(result);
		
	}

}
