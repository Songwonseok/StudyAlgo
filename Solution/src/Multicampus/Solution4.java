package Multicampus;

public class Solution4 {

	// 소 수이면 1리턴 아니면 약수중에 1보다 큰 가장 작은 수 리턴
	public static int isPrime(long n) {
	    // Write your code here
		for(int i=2;i<= n/2;i++) {
			if(n%i == 0) {
				return i;
			}
		}
		return 1;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
