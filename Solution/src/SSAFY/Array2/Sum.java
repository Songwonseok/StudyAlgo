package SSAFY.Array2;

public class Sum {
	private static int sum(int n) {
		if(n==1) return 1; //재귀에서 멈추는 식
		return n*sum(n-1); //재귀에서 쓰는 식
	}
	
	private static int fac(int n) {
		if(n==1) return 1; //재귀에서 멈추는 식
		return n*fac(n-1); //재귀에서 쓰는 식
		
	}
	
	private static int fibo(int n) {
		if(n<2) return n; //재귀에서 멈추는 식
		return fibo(n-1)+fibo(n-2); //재귀에서 쓰는 식
		
	}

	public static void main(String[] args) {
		System.out.println(fibo(10));

	}


}
