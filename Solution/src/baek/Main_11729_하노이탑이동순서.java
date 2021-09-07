package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11729_하노이탑이동순서 {
	static int N, count;
	static StringBuilder sb;

	public static void moveToDisk(int n, int start, int mid, int end) {
		count++;

		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
		}else{
			moveToDisk(n - 1, start, end, mid);
			sb.append(start).append(" ").append(end).append("\n");
			moveToDisk(n - 1, mid, start, end);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		sb = new StringBuilder();

		moveToDisk(N, 1, 2, 3);

		StringBuilder answer = new StringBuilder(Integer.toString(count));
		answer.append("\n").append(sb.toString());

		System.out.print(answer);
	}
}
