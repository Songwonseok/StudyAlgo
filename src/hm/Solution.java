package hm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
	static int N = 5, INF = Integer.MAX_VALUE;
	static int[][] graph = { { INF, 2, 3, 4, 5 }, { 2, INF, 3, 4, 5, }, { 3, 3, INF, 4, 5 }, { 4, 4, 4, INF, 5 },
			{ 5, 5, 5, 5, INF } };
	static int[] p;
	
	public static int find(int x) {
		if(p[x] == x)
			return x;
		return find(p[x]);
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		p[a] = b;
		
	}
	
	public static int solution() {
		int sum=0;
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				list.add(new int[] {i,j,graph[i][j]});
			}
		}
		p = new int[N];
		for(int i=0;i<N;i++)
			p[i]=i;
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for(int i=0;i<list.size();i++) {
			if(find(list.get(i)[0]) != find(list.get(i)[1])) {
				union(list.get(i)[0],list.get(i)[1]);
				sum+= list.get(i)[2];
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		int n = 10;
		int[] P = { 5, 7, 8, 2, 4, 6, 1, 8, 9, 10 };

		System.out.println(solution());
	}
}
