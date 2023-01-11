package Steet_11.Test221112;

public class Solution1 {
	public int solution(int N) {
		int answer = N;
		int sum = getSumOfDigits(N);

		for(int i = N + 1; N <= 50000; i++) {
			if(getSumOfDigits(i) == sum) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public int getSumOfDigits(int N) {
		int sum = 0;

		for(int i = (int)Math.log10(N); i >= 0; i--) {
			int digit = (int)Math.pow(10, i);

			sum += N / digit;
			N %= digit;
		}

		return sum;
	}

	public static void main(String[] args) {
		// System.out.println(getSumOfDigits(1512));
	}
}
