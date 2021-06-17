package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	public static void visitConnection(int start, boolean[][] graph, boolean[] isVisit) {
		isVisit[start] = true;

		for (int i = 0; i < isVisit.length; i++) {
			if (graph[start][i] && !isVisit[i]) {
				visitConnection(i, graph, isVisit);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] graph = new boolean[N][N];
		boolean[] isVisit = new boolean[N];

		int answer = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int edge1 = Integer.parseInt(st.nextToken()) - 1;
			int edge2 = Integer.parseInt(st.nextToken()) - 1;

			graph[edge1][edge2] = true;
			graph[edge2][edge1] = true;
		}

		for (int i = 0; i < isVisit.length; i++) {
			if (!isVisit[i]) {
				visitConnection(i, graph, isVisit);
				answer++;
			}
		}

		System.out.println(answer);
	}
}
