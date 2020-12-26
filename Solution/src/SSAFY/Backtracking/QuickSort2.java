package SSAFY.Backtracking;

import java.util.Arrays;

public class QuickSort2 {
	//public static int[] a = {69,10,30,2,16,8,31,22};
	public static int[] a = {69,19,40,2,16,8,31,22};

	public static int hoare(int begin, int end) {
		int P = a[begin]; 
		int L = begin;
		int R = end;
		
		while(L<R) {
			while(a[L] <= P && L<end) L++; 
			while(a[R] >= P && begin<R) R--;
			if(L<R) {
				if(L==P) P=R; //이 코드는 지금 자료에는 없는데 필요
				int T=a[R]; a[R] = a[L]; a[L]=T;
			}
		}
		int T=a[R]; a[R] = a[begin]; a[begin]=T;
		return R; 
	}
	
	public static void quick(int begin, int end) {
		if(begin<end) {
			int p=hoare(begin, end);
			quick(begin, p-1);
			quick(p+1,end);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
