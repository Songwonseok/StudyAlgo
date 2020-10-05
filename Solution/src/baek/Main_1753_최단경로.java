package baek;

import java.io.*;
import java.util.*;

public class Main_1753_최단경로 {
	static int INF = 10000000;
	public static int[] dijkstra(ArrayList<int[]>[] list, int start) {
		int N = list.length;
		boolean[] v = new boolean[N];
		int[] distance = new int[N];
		Arrays.fill(distance, INF);
		
		distance[start] = 0;
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		queue.add(new int[] {start, 0});

		while(!queue.isEmpty()) {
			int curr = queue.poll()[0];
			
			if(v[curr]) 
				continue;
			
			v[curr] = true;
			for(int[] n : list[curr]) {
				int next = n[0];
				int nextWeight = n[1];
				if(nextWeight + distance[curr] < distance[next]) {
					distance[next] = nextWeight + distance[curr];
					queue.add(new int[] {next, distance[next]});
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] list = new ArrayList[V];
		for(int i=0;i<V;i++)
			list[i] = new ArrayList<int[]>();
		
		int start = Integer.parseInt(br.readLine()) -1;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) -1;
			int v = Integer.parseInt(st.nextToken()) -1;
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new int[] {v,w});
		}
		int[] result = dijkstra(list, start);
		
		for(int i=0;i<V;i++) {
			if(result[i] == INF)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}
	}

}
