package algo.baek;

import java.io.*;
import java.util.*;

public class Main_17471_게리맨더링_송원석 {
	static int[] value, v, p;
	static int[][] graph;
	static int N, total, min;

	public static int findParent(int x) {

		if (p[x] == x) {
			return x;
		}
		else
			return findParent(p[x]);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		p[b] = a;
	}

	public static void check(int r) {
		
		p = new int[N];
		
		if (r == N) {
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			for (int i = 0; i < N; i++) {
				if (v[i] == 1) {
					for (int j = 0; j < N; j++) {
						if (graph[i][j] == 1 && v[j] == 1) {
							if (findParent(i) != findParent(j))
								unionParent(i, j);
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (graph[i][j] == 1 && v[j] == 0) {
							if (findParent(i) != findParent(j))
								unionParent(i, j);
						}
					}
				}
			}
			ArrayList<Integer> check = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				if (!check.contains(p[i]))
					check.add(p[i]);
			}
			if (check.size() != 2)
				return;

			int[] temp = v.clone();
			int sum=0;
			for (int i = 0; i < N; i++) {
				if (temp[i] == 1) {
					sum += value[i];
					temp[i] = 0;
					for (int j = 0; j < graph[i].length; j++) {
						if (graph[i][j] == 1 && temp[j] == 1) {
							sum += value[j];
							temp[j] = 0;
						}
					}
				}
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
