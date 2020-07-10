package baek;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사_BP {
	static int N, max;
	static int[] time,pay;
	
	public static void BP(int day, int total) {
		if(day == N) {
			max = Math.max(max, total);
			return;
		}
		if(day+ time[day] <=N)
			BP(day+time[day],total+pay[day]);
		
		BP(day+1,total);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		time = new int[N];
		pay = new int[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		BP(0,0);
		System.out.println(max);
	}

}
