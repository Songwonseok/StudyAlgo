package Infraware;

public class Solution3 {
	static int max;

	public void counting(int N, int[] array, int start) {
		int count = 1;
		boolean removed = false;
		for (int i = start; i < N - 1; i++) {
			if (array[i] < array[i + 1]) {
				count++;
			} else {
				if (!removed) {
					counting(N, array, i + 1);
					removed = true;
					continue;
				} else {
					break;
				}
			}
		}
		max = Math.max(count, max);
	}

	public int solution(int N, int[] array) {
		int answer = 0;
		int start = 0;
		max = 0;

		counting(N, array, 0);

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
