package algo.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_서울9반_송원석{
	static int N,min;
	static int[][] graph;
	static boolean[] v;
	public static void comb(int si,int r) {
		if(r == N/2) {
			int sum1 =0,sum2 =0;
			for(int i=0;i<N;i++) {
				if(v[i]) {
					for(int j=0;j<N;j++) {
						if(v[j])
							sum1+=graph[i][j];
					}
				}else {
					for(int j=0;j<N;j++) {
						if(!v[j])
							sum2+=graph[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		for(int i=si;i<N;i++) {
			if(!v[i]) {
				v[i] = true;
				comb(i,r+1);
				v[i] = false;
			}
		}
		
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		graph = new int[N][N];
		min = Integer.MAX_VALUE;
		v = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		
		System.out.println(min);
		
		
	}
}
