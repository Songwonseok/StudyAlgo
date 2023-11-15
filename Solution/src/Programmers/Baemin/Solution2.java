package Programmers.Baemin;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

	public int solution(int[][] relationships, int target, int limit) {
		int sum = 0;
		int newFriends = 0;
		
		boolean[][] graph = new boolean[101][101];

		boolean[] visit = new boolean[101];

		for (int i = 0; i < relationships.length; i++) {
			graph[relationships[i][0]][relationships[i][1]] = true;
			graph[relationships[i][1]][relationships[i][0]] = true;
		}

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {target, 1});
		visit[target] = true;

		while(!queue.isEmpty()) {
			int curr = queue.peek()[0];
			int depth = queue.poll()[1];

			if(depth > limit) {
				break;
			}

			for(int i = 1; i <= 100; i++) {
				if(graph[curr][i] && !visit[i]) {

					if(depth == 1) {
						sum += 5;
					}else {
						sum += 10;
						newFriends++;
					}

					visit[i] = true;
					queue.add(new int[] {i, depth + 1});
				}
			}
		}


		return sum + newFriends;
	}
	public static void main(String[] args) {
		int[][] a = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
		int target = 2;
		int limit = 3;


		Solution2 s2 = new Solution2();

		System.out.println(s2.solution(a,target,limit));

	}
}
