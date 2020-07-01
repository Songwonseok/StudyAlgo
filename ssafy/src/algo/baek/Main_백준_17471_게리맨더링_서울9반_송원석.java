package algo.baek;

import java.io.*;
import java.util.*;

public class Main_백준_17471_게리맨더링_서울9반_송원석 {
	static int[] value, v, p;
	static boolean visit[];
	static int[][] graph;
	static int N, total, min,sum;


	public static void dfs(int x, int n) {
		visit[x] = true;
		if(n==1)
			sum+= value[x];
		
		for(int i=0;i<N;i++) {
			if(graph[x][i] == 1 && !visit[i] && v[i] == n ) {
				dfs(i,n);
			}
		}
	}
	
	public static void check(int r) {
		
		
		if (r == N) {
			sum=0;
			int cnt=0;
			visit = new boolean[N];
			for(int i=0;i<N;i++) {
				if(v[i] == 1 && !visit[i]) {
					dfs(i,1);
					cnt++;
					break;
					}
				}
			
			for(int i=0;i<N;i++) {
				if(v[i] == 0 && !visit[i]) {
					dfs(i,0);
					cnt++;
					break;
					}
				}
			if(cnt != 2)
				return;
			
			for(int i=0;i<N;i++) {
				if(!visit[i])
					return;
			}
			
			min = Math.min(min, Math.abs(sum - (total - sum)));
			return;
		}
		for (int i = 0; i < 2; i++) {
			v[r] = i;
			check(r + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		value = new int[N];
		total = 0;
		min = 987654321;
		graph = new int[N][N];
		v = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			total += value[i];
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				graph[i][num] = 1;
				graph[num][i] = 1;
			}
		}

		check(0);
		if (min == 987654321)
			System.out.println(-1);
		else
			System.out.println(min);

	}

}
