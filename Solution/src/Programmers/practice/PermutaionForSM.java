package Programmers.practice;

import java.util.Arrays;

public class PermutaionForSM {
	static char[] a = {'A','B','C','D','E'}, result;
	
	static int[] d;
	static int r= 4;
	static int cnt;
	static boolean[] v;
	
	
	public static void permComb(int start, int depth) {
		
		if(depth == r) {
			for(int i=0;i<r;i++) {
				result[i] = a[d[i]];
			}
			System.out.println(String.valueOf(result));
			cnt++;
			return;
		}
		
		for(int i=0;i<v.length;i++) {
			if(!v[i]) {
				v[i] = true;
				d[depth] = i;
				permComb(0,depth+1);
				v[i] = false;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		v = new boolean[5];
		d = new int[5];
		result = new char[4];
		cnt = 0;
		permComb(0,0);
		System.out.println(cnt);
	}

}
