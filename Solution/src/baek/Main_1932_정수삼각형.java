package baek;

import java.io.*;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] pyramid = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<i+1;j++) {
				pyramid[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i= N-1; i>0; i--) {
			for(int j=i;j>0;j--) {
				pyramid[i-1][j-1] += Math.max(pyramid[i][j], pyramid[i][j-1]);
			}
		}
		
		System.out.println(pyramid[0][0]);
	}
}
