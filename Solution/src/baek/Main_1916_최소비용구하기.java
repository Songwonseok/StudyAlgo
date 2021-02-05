package baek;

import java.io.*;
import java.util.*;
public class Main_1916_최소비용구하기 {
	static int N,M;
	static int INF = Integer.MAX_VALUE;
	static int[][] graph;
	
	public static int getMinIndex(int[] distance, boolean[] visit) {
		int minIndex = -1;
		int min = INF;
		
		for(int i=1;i<=N;i++) {
			if(!visit[i] && distance[i] != INF) {
				if(distance[i] < min) {
					min = distance[i];
					minIndex = i;
				}
			}
		}
		
		return minIndex;
	}
	
	public static int dijkstra(int start, int end){
		boolean[] visit= new boolean[N+1];
		int[] distance = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			distance[i] = graph[start][i];
		}
		
		distance[start] = 0;
		visit[start] = true;
		
		for(int i=0;i<N-1;i++) {
			int minIndex = getMinIndex(distance, visit);
			if(minIndex == -1) break;
			visit[minIndex] = true;
			for(int j=1;j<=N;j++) {
				if(!visit[j] && graph[minIndex][j] != INF) {
					distance[j] = Math.min(distance[minIndex] + graph[minIndex][j], distance[j]);
				}
			}
		}
		
		return distance[end];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(graph[from][to] > weight) {
				graph[from][to] = weight;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int answer = dijkstra(start, end);
		
		System.out.println(answer);
	}
}
