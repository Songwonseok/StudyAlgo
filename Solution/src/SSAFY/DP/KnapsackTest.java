package SSAFY.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4
10
5 10
4 40
6 30
3 50
 */
public class KnapsackTest {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		int[] w = new int[N+1];
		int[] v = new int[N+1];
		int[][] k = new int[N+1][W+1];		
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());		 
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=W;j++) {
				if(w[i]>j) {
					k[i][j]=k[i-1][j]; //바로 위에꺼 가져오기(나를 넣기 전 완성된 값)
				}else {
					k[i][j]=Math.max(k[i-1][j-w[i]]+v[i], k[i-1][j]); //이전에 완성된 값과 나를 포함해서 넣을 값 중에 최대 값
				}
			}
		}
		
		System.out.println(k[N][W]);
		for(int[] a:k) System.out.println(Arrays.toString(a));
	}

}
