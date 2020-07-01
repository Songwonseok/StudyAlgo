package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N, M, result;
	static ArrayList<int[]> BBQ, customer;
	static int[] survive;
	static boolean[] v;

	public static void solve(int r, int start) {
		if (r == M) {
			int sum=0;
			for (int i = 0; i < customer.size(); i++) {
				int x = customer.get(i)[0];
				int y = customer.get(i)[1];
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int cx = BBQ.get(survive[j])[0];
					int cy = BBQ.get(survive[j])[1];
					min = Math.min(min, Math.abs(x-cx)+Math.abs(y-cy));
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}

		for (int i = start; i < BBQ.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				survive[r] = i;
				solve(r + 1, i);
				v[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		BBQ = new ArrayList<>();
		customer = new ArrayList<>();
		survive = new int[M];
		result = Integer.MAX_VALUE;
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					customer.add(new int[] { i, j });
				} else if (num == 2) {
					BBQ.add(new int[] { i, j });
				}
			}
		}
		v = new boolean[BBQ.size()];
		solve(0, 0);
		System.out.println(result);
	}

}
