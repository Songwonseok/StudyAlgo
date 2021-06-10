package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		int maxWeight = 0;

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		for (int i = 0; i < N; i++) {
			maxWeight = Math.max(maxWeight, rope[i] * (N-i));
		}

		System.out.println(maxWeight);
	}
}
