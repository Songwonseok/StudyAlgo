package SSAFY.Array2;

import java.util.Arrays;

public class Selection {
	public static int[] a = {64,25,10,22,11};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a) + "\n");
		for(int i=0;i<a.length-1;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) min=j;
			}
			int T= a[i];
			a[i]=a[min];
			a[min]=T;
			System.out.println(Arrays.toString(a));
		}
		System.out.println("\n" + Arrays.toString(a));
	}

}
