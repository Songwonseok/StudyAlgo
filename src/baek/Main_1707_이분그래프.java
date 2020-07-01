package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
	static boolean[][] graph;
	static boolean[] v;
	static int V, E;

	public static void check(int n, boolean flag) {
		v[n] = true;
		
		for(int i=0;i<V;i++) {
			if(n != i && graph[n][i] && !v[i]) {
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new boolean[V][V];
			v = new boolean[V];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()) - 1;
				int m = Integer.parseInt(st.nextToken()) - 1;
				graph[n][m] = true;
				graph[m][n] = true;
			}
			int count = 0;

			for (int i = 0; i < V; i++) {
				if (!v[i]) {
					count++;
					check(i,true);
					if(count==2)
						break;
				}
			}

			boolean flag = true;
			
			for(int i=0;i<V;i++) {
				if(!v[i] || count>2) {
					flag=false;
					break;
				}
			}
			
			System.out.println(flag?"YES":"NO");
			
			
		}
	}

}
