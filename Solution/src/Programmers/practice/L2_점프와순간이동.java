package Programmers.practice;

public class L2_점프와순간이동 {

	public int solution(int n) {
		int ans = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n--;
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		

	}

}
