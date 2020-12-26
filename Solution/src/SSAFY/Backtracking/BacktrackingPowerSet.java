package SSAFY.Backtracking;

import java.util.Arrays;

public class BacktrackingPowerSet {
	public static int[] d= {1,2,3};
	public static int cnt;

	public static void main(String[] args) {
		int[] a = new int[d.length];
		Backtrack(a,0,a.length);
		System.out.println(cnt);
	}

	public static void Backtrack(int[] a, int k, int input) {
//		for(int i=0;i<k;i++) System.out.print("   ");
//		System.out.println(Arrays.toString(a)+" k="+k+" input="+input); //상태공간트리 보기
		int[] c = new int[a.length];
		if(k==input) {
			cnt++;
			System.out.print(Arrays.toString(a)+" ");
			for(int i=0;i<input;i++) {
				if(a[i]==1) System.out.print(d[i]+" ");
			}
			System.out.println();
			return;
		}
		int ncands = candidate(a,k,c);
		for(int i=0;i<ncands;i++) {
			a[k]=c[i];
			Backtrack(a, k+1, input);
		
		}
		
	}

	public static int candidate(int[] a, int k, int[] c) {
		c[0]=0;
		c[1]=1;
		return 2;
	}

}
