package Infraware;

public class Solution2 {
	public long solution(int N, int K, int A, int B) {
		long answer = 0;

		if (K == 1) {
			answer = (N - 1) * A;
			return answer;
		}

		while (N > 1) {
			if (N >= K && N % K == 0) {
				int divided = N / K;
				int differ = N - divided;

				if (B <= A * differ) {
					answer += B;
					N = divided;
				} else {
					answer += A * differ;
					N = divided;
				}
			} else {
				N--;
				answer += A;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
