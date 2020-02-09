package baek;

import java.io.*;
import java.util.*;

//180ms
public class Main_B4485_녹색옷입은애가젤다지_김태희 {

	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x, y, w;

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = 0;
		while (true) {
			++t;
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("Problem " + t + ": " + go());
		}
	}

	private static int go() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		boolean[][] visited = new boolean[N][N];
		int[][] cost = new int[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		cost[0][0] = map[0][0];
		queue.offer(new Node(0, 0, cost[0][0]));

		Node cur = null;
		int nx, ny;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (visited[cur.x][cur.y])
				continue;
			if (cur.x == N - 1 && cur.y == N - 1)
				return cur.w;
			visited[cur.x][cur.y] = true;

			for (int d = 0; d < 4; ++d) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && cost[nx][ny] > cur.w + map[nx][ny]) {
					cost[nx][ny] = cur.w + map[nx][ny];
					queue.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}

		}
		return -1;
	}
}