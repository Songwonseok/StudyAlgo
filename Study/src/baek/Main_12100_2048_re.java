package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100_2048_re {
	static int N;
	static int max;
	
	public static int[][] move(int num, int[][] temp){
		int[][] copy = new int[N][N];
		for(int i=0;i<N;i++)
			copy[i] = temp[i].clone();
		boolean[][] v = new boolean[N][N];
		
		if(num == 0) { //right
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(copy[i][j] != 0) {
						for(int k=j;k<N-1;k++) {
							if(copy[i][k+1] == 0) {
								copy[i][k+1] = copy[i][k];
								copy[i][k] = 0;
							}else if(copy[i][k+1]== copy[i][k]
									&& !v[i][k+1] && !v[i][k]) {
								v[i][k+1] = true;
								copy[i][k+1] *= 2;
								max = Math.max(max, copy[i][k+1]);
								copy[i][k] =0;
							}
						}
					}
				}
			}
		}else if(num == 1) { // left
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copy[i][j] != 0) {
						for(int k=j;k>=1;k--) {
							if(copy[i][k-1] == 0) {
								copy[i][k-1] = copy[i][k];
								copy[i][k] = 0;
							}else if(copy[i][k-1]== copy[i][k]
									&& !v[i][k-1]&& !v[i][k]) {
								v[i][k-1] = true;
								copy[i][k-1] *= 2;
								max = Math.max(max, copy[i][k-1]);
								copy[i][k] =0;
							}
						}
					}
				}
			}
		}else if(num == 2) { // up
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copy[j][i] != 0) {
						for(int k=j;k>=1;k--) {
							if(copy[k-1][i] == 0) {
								copy[k-1][i] = copy[k][i];
								copy[k][i] = 0;
							}else if(copy[k-1][i]== copy[k][i]
									&& !v[k-1][i]&& !v[k][i]) {
								v[k-1][i] = true;
								copy[k-1][i] *= 2;
								max = Math.max(max, copy[k-1][i]);
								copy[k][i] =0;
							}
						}
					}
				}
			}
		}else { // down
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=0;j--) {
					if(copy[j][i] != 0) {
						for(int k=j;k<N-1;k++) {
							if(copy[k+1][i] == 0) {
								copy[k+1][i] = copy[k][i];
								copy[k][i] = 0;
							}else if(copy[k+1][i]== copy[k][i]
									&& !v[k+1][i]&& !v[k][i]) {
								v[k+1][i] = true;
								copy[k+1][i] *= 2;
								max = Math.max(max, copy[k+1][i]);
								copy[k][i] =0;
							}
						}
					}
				}
			}
		}
		return copy;
	}
	
	
	public static void solve(int r, int[][] copy) {
		
		if(r==5) {
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					max= Math.max(max, copy[i][j]);
//				}
//			}
			return;
		}
		
		for(int i=0;i<4;i++) {
			solve(r+1,move(i,copy));
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max =0;
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		solve(0,map);
		System.out.println(max);
		
	}

}
