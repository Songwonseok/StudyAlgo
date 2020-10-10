package baek;

import java.io.*;
import java.util.*;

public class Main_1756_피자굽기 {
	static int[] oven, pizza;
	static int bottom;
	public static int binarySearch(int st, int end, int value) {
		
		if(end - st == 1) {
			if(oven[end] >= value) {
				bottom = end -1;
				return end + 1;
			}else if(oven[st] >= value) {
				bottom = st -1;
				return st + 1;
			}else {
				return -1;
			}
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
		
		bottom = D-1;
		int floor = 0;
		for(int i=0;i<N;i++) {
			
			floor = binarySearch(0,bottom,pizza[i]);
			if(floor == -1) {
				floor = 0;
				break;
			}
		}
		
		System.out.println(floor);
	}

}
