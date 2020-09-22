package Programmers.kakao.blind2020;

import java.util.Arrays;

public class solution4 {
	static int INF= 10000000;
	static int[][] graph;
	
	public static int getSmallIndex(int[] d, boolean[] v, int n) {
		int index=0;
		int min=INF;
		for(int i=0;i<n;i++) {
			if(min>d[i] && !v[i]) {
				min=d[i];
				index=i;
			}
		}
		return index;
	}
	
	public static int[] dijkstra(int start, boolean[] v, int n) {
		int[] d=Arrays.copyOf(graph[start], n); 
		
		v[start]=true;
		for(int i=0;i<n;i++) {
			int curr = getSmallIndex(d, v, n);
			v[curr]=true;
			for(int j=0;j<n;j++) {
				if(!v[j]) {
					if(d[j]>d[curr]+graph[curr][j]) {
						d[j]=d[curr]+graph[curr][j];
					}
				}
			}
		}
		graph[start] = Arrays.copyOf(d, n);
		return d;
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		s = s-1;
		a = a-1;
		b = b-1;
		graph = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(graph[i],INF);
		}
		
		for(int i=0;i<fares.length;i++) {
			graph[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
			graph[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
		}
		
		boolean[] visit = new boolean[n];
		int[] startFare = dijkstra(s,visit, n);
		startFare[s] = 0;
		int answer = startFare[a] + startFare[b];
		
		for(int i=0;i<n;i++) {
			if(i != s) {
				boolean[] v = new boolean[n];
				int[] fare = dijkstra(i,v, n);
				fare[i] = 0;
				answer = Math.min(answer, startFare[i] + fare[a] + fare[b]);
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		int[][] fares = {{5,7,9},{4,6,4}, {3,6,1}, {3,2,3},{2,1,6}};
		System.out.println(solution(7,3,4,1,fares));
	}

}
