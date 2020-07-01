package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15649_N과M {
	static int[] num, result;
	static boolean[] v;
	static int N, M;

	public static void perm(int r) {
		if (r == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				result[r] = num[i];
				perm(r + 1);
				v[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		v = new boolean[N];
		result = new int[M];
		for (int i = 1; i <= N; i++)
			num[i - 1] = i;
		perm(0);

	}

}
