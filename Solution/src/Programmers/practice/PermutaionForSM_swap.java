package Programmers.practice;

import java.util.Arrays;

public class PermutaionForSM_swap {
	static char[] a = {'A','B','C','D','E'}, result;
	
	static int[] d;
	static int r= 4;
	static int cnt;
	static boolean[] v;
	
	public static void swap(int x, int y) {
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void permComb(int start, int depth) {
		
		if(depth == r) {
			System.out.println(String.valueOf(a).substring(0, a.length-1));
			cnt++;
			return;
		}
		
		for(int i=depth;i<v.length;i++) {
				swap(depth,i);
				permComb(0,depth+1);
				swap(depth,i);
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
