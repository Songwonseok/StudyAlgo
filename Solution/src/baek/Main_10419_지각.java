package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10419_지각 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			int d = Integer.parseInt(br.readLine());

			int result = (int)Math.sqrt(d);

			while(result > 0) {

				if(d >= result + Math.pow(result, 2)) {
					break;
				}

				result--;
			}

			System.out.println(result);
		}
	}
}
