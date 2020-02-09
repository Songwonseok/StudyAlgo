package baek;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사 {
	static int N,max;
	static int[][] counsel;
	
	public static void solve(int r, int total) {
		if(r==N) {
			max=Math.max(max, total);
			return;
		}
		
		if(r+counsel[r][0]>N) {
			solve(r+1,total);
		}else {
			solve(r+1,total);
			solve(r+counsel[r][0],total+counsel[r][1]);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		max=0;
		counsel = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0);
		System.out.println(max);
	}
}
