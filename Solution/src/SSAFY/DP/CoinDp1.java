package SSAFY.DP;

import java.util.Arrays;

public class CoinDp1 {
	public static int[] coin= {1,4,6}, m;
	public static void main(String[] args) {
		int N=8;
		m = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int min=Integer.MAX_VALUE/2;
			for(int j=0;j<coin.length;j++) {
				if(i-coin[j]>=0) {
					if(min>m[i-coin[j]]) min=m[i-coin[j]];
				}
			}
			m[i]=min+1;
		}
		
		System.out.println(m[N]);
		System.out.println(Arrays.toString(m));

	}

}
