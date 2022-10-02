package Programmers;

public class Dev2 {
	long answer;
	// 2: { 1 }, 3: {7}, 4: {4}, 5: {2, 3, 5}, 6: {0, 6, 9}, 7: {8}
	int[] numbers = {0, 0, 1, 1, 1, 3, 3, 1};
	// int[] numbers = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};


	// 2자리수 이상일 경우 0이 맨앞은 x
	// 모두 사용해야함
	public long solution(int k) {
		answer = 0L;

		if(k <= 1) {
			return answer;
		}

		for(int i = 2; i <= 7; i++) {
			if(k < i) {
				break;
			}

			if(i == 6 && k > i) {
				solve(k - i, numbers[i] - 1);
				continue;
			}

			solve(k - i, numbers[i]);
		}

		return answer;
	}

	public void solve(int k, long acc) {
		if(k == 1) {
			return;
		}

		if(k == 0) {
			answer += acc;
			return;
		}


		for(int i = 2; i <= 7; i++) {
			if(k < i) {
				break;
			}

			solve(k - i, acc * numbers[i]);
		}
	}

	public void solve2(int k) {
		if(k == 1) {
			return;
		}

		if(k == 0) {
			answer++;
			return;
		}


		for(int i = 0; i <= 9; i++) {
			if(k < numbers[i]) {
				continue;
			}

			solve2(k - numbers[i]);
		}
	}

	public static void main(String[] args) {
		Dev2 s = new Dev2();

		System.out.println(s.solution(11));
	}
}
