package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isNotPrime = new boolean[N + 1];
		isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!isNotPrime[i]) {
				for (int j = i * 2; j <= N; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb.toString());

	}
}
