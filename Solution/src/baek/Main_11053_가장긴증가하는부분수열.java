package baek;

import java.io.*;
import java.util.*;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] DP = new int[N];
		int length = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			for(int j=i-1;j>=0;j--) {
				if(arr[j] < arr[i] && DP[j] > max) {
					max = DP[j];
				}
			}
			DP[i] = max+1;
			length = Math.max(DP[i], length);
		}
		System.out.println(length);
		
	}

}
