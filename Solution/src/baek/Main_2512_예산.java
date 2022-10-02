package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512_예산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] budgets = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
		}

		int total = Integer.parseInt(br.readLine());
		int start = 0;
		int end = Arrays.stream(budgets).max().getAsInt();

		int sum = 0;

		for (int budget : budgets) {
			sum += (budget <= end) ? budget : end;
		}

		if(sum <= total){
			System.out.println(end);
			return;
		}

		while (start < end) {
			int mid = (start + end) / 2;
			sum = 0;

			for (int budget : budgets) {
				sum += (budget <= mid) ? budget : mid;
			}

			if (sum < total) {
				if (start == mid) {
					break;
				}

				start = mid;
			} else {
				end = mid;
			}
		}

		System.out.println(start);
	}
}
