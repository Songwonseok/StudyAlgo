package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10804_카드역배치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] cards = new int[21];

		for (int i = 1; i <= 20; i++) {
			cards[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = 0; j <= (end - start) / 2; j++) {
				int temp = cards[start + j];
				cards[start + j] = cards[end - j];
				cards[end - j] = temp;
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 1; i <= 20; i++) {
			answer.append(cards[i]).append(" ");
		}

		System.out.println(answer.toString());
	}
}
