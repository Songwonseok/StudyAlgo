package baek;

import java.io.*;
import java.util.*;

public class Main_14889_스타트와링크 {
	static int N, min;
	static int[][] graph;
	static int[] steam, lteam;
	static boolean[] v;
	
	
	static void makeTeam(int start, int depth) {
		if(depth == N/2) {
			int index1 = 0;
			int index2 = 0;
			int score_s=0;
			int score_l=0;
			
			for(int i=0;i<N;i++) {
				if(v[i]) {
					steam[index1++] = i;
				}else {
					lteam[index2++] = i;
				}
			}
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					if(i!=j) {
						score_s += graph[steam[i]][steam[j]];
						score_l += graph[lteam[i]][lteam[j]];
					}
				}
			}
			min = Math.min(min, Math.abs(score_s - score_l));
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(!v[i]) {
				v[i] = true;
				makeTeam(i, depth+1);
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		steam = new int[N/2];		
		lteam = new int[N/2];
		graph = new int[N][N];
		v = new boolean[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0,0);
		System.out.println(min);
	}

}
