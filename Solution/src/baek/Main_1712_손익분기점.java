package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1712_손익분기점 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int fixCost = Integer.parseInt(st.nextToken());
		int makeCost = Integer.parseInt(st.nextToken());
		int salePrice = Integer.parseInt(st.nextToken());

		if (makeCost >= salePrice) {
			System.out.println(-1);
			return;
		}

		int breakPoint =  fixCost / (salePrice - makeCost);

		System.out.println(breakPoint + 1);
	}
}
