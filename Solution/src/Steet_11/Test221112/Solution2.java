package Steet_11.Test221112;

public class Solution2 {
	public static boolean solution(int[] A, int K) {
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			// if (A[i] + 1 < A[i + 1])
			if (A[i] + 1 < A[i + 1] && A[i + 1] <= K)
				return false;
		}
		// if (A[0] != 1 && A[n - 1] != K)
		if (A[0] > 1 || A[n - 1] < K)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		int[] A = {1,1, 2,3,4,5, 8};

		System.out.println(solution(A, 1));

	}
}
