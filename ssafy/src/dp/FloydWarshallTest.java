package dp;

import java.util.Arrays;

public class FloydWarshallTest {

	public static void main(String[] args) {
		int N=5;
		int INF=987654321;
		int[][] d= {
				{0,4,2,5,INF},
				{INF,0,1,INF,4},
				{1,3,0,1,2},
				{-2,INF,INF,0,2},
				{INF,-3,3,1,0},
		};

		for(int k=0; k<N; k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					d[i][j]=Math.min(d[i][k]+d[k][j], d[i][j]);
				}
			}
		}
		for(int[] a:d) System.out.println(Arrays.toString(a));
	}

}
