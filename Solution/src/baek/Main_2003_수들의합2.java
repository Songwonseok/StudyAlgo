package baek;

import java.io.*;
import java.util.*;

public class Main_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = 0;
		int sum = num[0];
		int cnt = 0;
		
		while(right < N) {
			if(sum == M) cnt++;
			if(sum >= M && left < right) {
				sum -= num[left];
				left++;
			}else {
				right++;
				if(right == N) break;
				sum += num[right];
			}
		}
		
		System.out.println(cnt);
	}
}
