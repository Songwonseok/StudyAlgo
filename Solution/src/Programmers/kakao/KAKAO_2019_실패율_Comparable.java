package Programmers.kakao;
import java.util.*;

public class KAKAO_2019_실패율_Comparable {
	static class Answer implements Comparable<Answer>{
		int stageNumber;
		double failRate;
		
		public Answer(int stageNumber, double failRate) {
			this.stageNumber = stageNumber;
			this.failRate = failRate;
			
		}
		public int compareTo(Answer o) {
			if(this.failRate == o.failRate)
				return Integer.compare(this.stageNumber, o.stageNumber);
			return -Double.compare(this.failRate, o.failRate);
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] total = new int[N];
		int[] fail = new int[N];
		
		Answer[] result = new Answer[N];

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
			if (total[i] == 0) {
				result[i] = new Answer(i+1,0);
			} else {
				result[i] = new Answer(i+1,(double)fail[i]/total[i]);
			}
		}

		
		Arrays.sort(result);

		for (int i = 0; i < N; i++) {
			answer[i] = result[i].stageNumber;
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
