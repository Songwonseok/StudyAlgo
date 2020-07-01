package baek;

import java.io.*;
import java.util.*;

public class Main_15650_N과M2 {
	static int N,M;
	static int[] num,result;
	static boolean[] v;
	
	public static void comb(int start, int r) {
		if(r==M) {
			for(int a : result)
				System.out.print(a+" ");
			System.out.println();
			return;
		}
		for(int i=start;i<N;i++) {
			if(!v[i]) {
				v[i] = true;
				result[r] = num[i];
				comb(i,r+1);
				v[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		result = new int[M];
		v = new boolean[N];
		
		for(int i=0;i<N;i++)
			num[i]=i+1;
		comb(0,0);
	}
}
