package SW;

class Solution {
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int index = -1;
		int N = stones.length;
		boolean flag = true;
		int cnt = 0;

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, stones[i]);
		}
		answer += min;
		for (int i = 0; i < N; i++) {
			stones[i] -= min = Math.min(min, stones[i]);
		}

		label: while (flag) {
			if (index + 1 >= N) {
				answer++;
				index = -1;
				continue;
			} else if (stones[index + 1] != 0) {
				stones[++index]--;
				continue;
			} else if (stones[index + 1] == 0) {
				for (int i = index + 1; i <= index + k; i++) {
					if (i == N) {
						answer++;
						index = -1;
						continue label;
					} else if (stones[i] != 0) {
						stones[i]--;
						index = i;
						continue label;
					}
				}
				flag = false;
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;

		System.out.println(solution(stones, k));

	}
}