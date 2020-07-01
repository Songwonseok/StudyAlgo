package list;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {69,10,30,2,16,8,31,22};
		System.out.println(Arrays.toString(a));
		
		for(int i=1;i<a.length;i++) {
			int k=i;
			for(int j=i-1;j>=0;j--) {
				if(a[j] > a[k]) {
					int T = a[j]; a[j] = a[k]; a[k] = T;
					k=j;
				}
			}
			System.out.println(Arrays.toString(a));
		}

	}

}
