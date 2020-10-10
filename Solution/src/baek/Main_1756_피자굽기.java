package baek;

import java.io.*;
import java.util.*;

public class Main_1756_피자굽기 {
	static int[] oven, pizza;
	public static int binarySearch(int st, int end, int value) {
		if (end <= 0) 
			return -1;
		if(end - st == 1) {
			if(oven[st] >= value) 
				return st;
			return -1;
			
		}
		
		int mid = (st+end) /2;
		
		if(oven[mid] >= value) 
			return binarySearch(mid, end, value);
		else
			return binarySearch(st, mid, value);
		
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		oven = new int[D];
		pizza = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<D;i++) {
			min = Math.min(min, Integer.parseInt(st.nextToken()));
			oven[i] = min;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int bottom = D;
		for(int i=0;i<N;i++) {
			
			bottom = binarySearch(0,bottom,pizza[i]);
		}
		
		System.out.println(bottom+1);
	}

}
