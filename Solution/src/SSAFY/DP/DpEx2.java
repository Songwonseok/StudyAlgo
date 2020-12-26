package SSAFY.DP;

import java.util.Arrays;

public class DpEx2 {

	public static void main(String[] args) {
		int N=6;
		int[] P = new int[N+1];
		P[0]=1;
		P[1]=2;
		for(int i=2;i<=N;i++) {
			P[i]=2*P[i-1]+P[i-2];
		}
		System.out.println(P[N]);
		System.out.println("P"+Arrays.toString(P));
	}

}
