package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지_dijk {
	static class Node implements Comparable<Node> {
		int i;
		int j;
		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost[i][j], cost[o.i][o.j]);
		}
	}

	static final int INF = 987654321;
	static int N, map[][], cost[][];
	static int di[] = { 0, 0, 1, -1 };
	static int dj[] = { 1, -1, 0, 0 };
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			cost = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			cost[0][0] = map[0][0];
			System.out.println("Problem " + cnt + ": " + dijkstra(0, 0));
			cnt++;
		}
	}

	static int dijkstra(int i, int j) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(i, j));
		while (!queue.isEmpty()) {
			Node smallCur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = smallCur.i + di[d];
				int nextj = smallCur.j + dj[d];
				if (nexti < 0 || nextj < 0 || nexti >= N || nextj >= N)
					continue;
				if (cost[nexti][nextj] > map[nexti][nextj] + cost[smallCur.i][smallCur.j]) {
					cost[nexti][nextj] = map[nexti][nextj] + cost[smallCur.i][smallCur.j];
					queue.add(new Node(nexti, nextj));
				}
			}
		}
		return cost[N - 1][N - 1];
	}
}