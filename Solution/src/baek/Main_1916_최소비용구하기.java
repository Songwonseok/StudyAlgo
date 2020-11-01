package baek;

import java.io.*;
import java.util.*;
public class Main_1916_최소비용구하기 {
	static int INF = Integer.MAX_VALUE/2;
	static int N, M;
	static int[][] graph;
	public static int getSamllIndex(int start, boolean[] visit) {
		int min = INF;
		int idx = start;
		for(int i=1;i<=N;i++) {
			if(!visit[i] && graph[start][i] != 0){
				if(graph[start][i] < min) {
					min = graph[start][i];
					idx = i;
				}
			}
		}
		return idx;
	}
	
	public static void dijkstra(int start) {
		boolean[] visit = new boolean[N+1];
		graph[start][start] = 0;
		
		int idx = start;
		for(int i=0;i<N-1;i++) {
			int minIdx = getSamllIndex(idx, visit);
			visit[minIdx] = true;
			
			for(int j=1;j<N+1;j++) {
				if(minIdx != j) {
					graph[start][j] = Math.min(graph[start][minIdx] + graph[minIdx][j], graph[start][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];

		for(int i=1;i<=N;i++)
			Arrays.fill(graph[i], INF);
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(graph[s][e] != 0) {
				graph[s][e] = Math.min(graph[s][e], p);
			}else {
				graph[s][e] = p;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(graph[start][end]);
	}
}
