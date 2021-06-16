package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temperature = new int[N];
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
			if (i < K) {
				sum += temperature[i];
			}
		}

		int start = 0;
		int max = sum;

		for (int end = K; end < N; end++) {
			sum += temperature[end] - temperature[end - K];
			max = Math.max(sum, max);
		}

		System.out.println(max);

	}
}
