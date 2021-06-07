package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10162_전자레인지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] operatingTime = {300, 60, 10}; // {5분, 1분, 10초}
		int[] pressCount = new int[3];
		int cookTime = Integer.parseInt(br.readLine());

		if (cookTime % 10 > 0) {
			System.out.println(-1);
			return;
		}

		for (int idx = 0; idx < 3; idx++) {
			if (cookTime / operatingTime[idx] > 0) {
				pressCount[idx] = cookTime / operatingTime[idx];
				cookTime %= operatingTime[idx];
			}
		}

		System.out.println(
			String.join(
				" ",
				Arrays.stream(pressCount)
					.mapToObj(String::valueOf)
					.toArray(String[]::new))
		);
	}
}
