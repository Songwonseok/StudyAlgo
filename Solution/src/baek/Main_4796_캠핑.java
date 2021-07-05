package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4796_캠핑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caseNumber = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0) {
				System.out.print(sb.toString());
				return;
			}

			int count = L * (V / P);
			count += L < (V % P) ? L : (V % P);
			sb.append("Case ").append(caseNumber++).append(": ").append(count).append("\n");
		}
	}
}
