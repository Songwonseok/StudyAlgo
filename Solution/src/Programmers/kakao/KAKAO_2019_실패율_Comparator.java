package Programmers.kakao;
import java.util.*;

public class KAKAO_2019_실패율_Comparator {
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] total = new int[N];
		int[] fail = new int[N];
		double[][] result = new double[N][2];
		

		for (int i = 0; i < stages.length; i++) {
			int stage = stages[i] - 1;
			if (stage != N) {
				fail[stage]++;
			} else {
				stage--;
			}
			for (int j = 0; j <= stage; j++)
				total[j]++;
		}

		for (int i = 0; i < N; i++) {
			result[i][0] = i + 1;
			if (total[i] == 0) {
				result[i][1] = 0;
			} else {
				result[i][1] = (double) fail[i] / total[i];
			}
		}

		Arrays.sort(result, new Comparator<double[]>() {
			public int compare(double[] o1, double[] o2) {
				if (o1[1] == o2[1])
					return Double.compare(o1[0], o2[0]);
				return -Double.compare(o1[1], o2[1]);
			}
		});
		

		for (int i = 0; i < N; i++) {
			answer[i] = (int) result[i][0];
		}

		return answer;
	}

	public static void main(String[] args) {
		int N = 5;
		//int[] stages = {4,4,4,4,4};
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		// result = {3,4,2,1,5};
		System.out.println(Arrays.toString(solution(N, stages)));
	}

}
