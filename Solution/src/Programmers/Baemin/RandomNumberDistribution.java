package Programmers.Baemin;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberDistribution {
	static int[] result;

	public static void main(String[] args) {
		List<Integer> rateList = getRate();

		for(int j = 0; j < 10; j++) {
			result = new int[10];
			for(int i = 0; i < 100000; i++) {
				drawRandomPoint(rateList);
			}

			int totalSum = 0;
			for (int num : result) {
				totalSum += num;
			}

			// 각 숫자의 백분율 계산 및 반올림하여 double 배열에 저장
			double[] percentages = new double[result.length];
			DecimalFormat df = new DecimalFormat("#.##"); // 세 자리까지 반올림

			StringBuilder sb = new StringBuilder("| ");
			sb.append((j+1) + " | " );
			for (int i = 0; i < result.length; i++) {
				double percentage = ((double) result[i] / totalSum) * 100.0;
				percentages[i] = Double.parseDouble(df.format(percentage));

				sb.append(result[i] + "회(" + percentages[i] + "%)");
				sb.append(" | ");
			}

			System.out.println(sb);
		}
	}

	public static void drawRandomPoint(List<Integer> rateList) {
		Random random = new Random();

		int randomNumber = random.nextInt(1_000_001);
		int boundary = 0;

		for (int i = 0; i < rateList.size(); i++) {
			boundary += rateList.get(i);

			if (randomNumber <= boundary) {
				result[i]++;
				break;
			}
		}
	}

	public static List<Integer> getRate() {
		String[] rateSplit = "5.46,9.92,17.87,30.27,17.87,9.92,5.09,2.35,0.95,0.3".replaceAll("\\s+", "").split(",");

		// 0.0001 까지 가능하도록 10,000 곱하기
		return Arrays.stream(rateSplit)
			.map(rateStr -> (int)(Double.parseDouble(rateStr) * 10000))
			.collect(Collectors.toList());
	}

}