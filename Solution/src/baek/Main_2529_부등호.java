package baek;

import java.io.*;
import java.util.*;

public class Main_2529_부등호 {
	static boolean[] visit;
	static int N;
	static String max, min;
	static char[] list;
	
	public static void dfs(int prev, int depth, String result) {
		if(depth == N) {
			if(Long.valueOf(min) > Long.valueOf(result)) {
				min = result;
			}
			if(Long.valueOf(result) > Long.valueOf(max)) {
				max = result;
			}
			return;
		}
		
		char curr = list[depth];
		if(curr == '<') {
			for(int i=0;i<10;i++) {
				if(!visit[i] && i > prev) {
					visit[i] = true;
					dfs(i, depth+1, result+i);
					visit[i] = false;
				}
			}
		}else {
			for(int i=0;i<10;i++) {
				if(!visit[i] && i < prev) {
					visit[i] = true;
					dfs(i, depth+1, result+i);
					visit[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[10];
		list = new char[N];
		min = "9876543210";
		max ="000";
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			list[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0;i<10;i++) {
			visit[i] = true;
			dfs(i, 0, Integer.toString(i));
			visit[i] = false;
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}

}
