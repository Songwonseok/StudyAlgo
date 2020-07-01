package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4 {
	static int N;
	static boolean[] v;
	static int[]d ;
	static int[][] graph;
	
	public static int getSmallIndex() {
		int index=0;
		int min=101;
		for(int i=0;i<N;i++) {
			if(min>d[i] && !v[i]) {
				min=d[i];
				index=i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		d=Arrays.copyOf(graph[start], N); 
		
		v[start]=true;
		for(int i=0;i<N-2;i++) {
			int curr = getSmallIndex();
			v[curr]=true;
			for(int j=0;j<N;j++) {
				if(!v[j]) {
					if(d[j]>d[curr]+graph[curr][j]) {
						d[j]=d[curr]+graph[curr][j];
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		
		int K = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for(int i=0;i<graph.length;i++) {
			Arrays.fill(graph[i], 101);
		}
		for(int i=0;i<K;i++) {
			String[] line = br.readLine().split(" ");
			String from = line[0].replace('o', '1').replace('x', '0');
			String to = line[1].replace('o', '1').replace('x', '0');
			int num1 = Integer.valueOf(from, 2);
			int num2 = Integer.valueOf(to, 2);
			
			graph[num1][num2] = Integer.parseInt(line[2]);
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i=0;i<Q;i++) {
			String[] line = br.readLine().split(" ");
			String from = line[0].replace('o', '1').replace('x', '0');
			String to = line[1].replace('o', '1').replace('x', '0');
			
			int start = Integer.valueOf(from, 2);
			int end = Integer.valueOf(to, 2);
			
			if(start == end)
				System.out.println(0);
			
			v = new boolean[N];
			d = new int[N];
			
			dijkstra(start);
			if(d[end] == 101)
				System.out.println(-1);
			else
				System.out.println(d[end]);
			
		}
		
	}
}
