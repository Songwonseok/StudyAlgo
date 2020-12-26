package SSAFY.Array1;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] a = {10,4,6,7,2,9,3,1,8,5};
		System.out.println(Arrays.toString(a));
		int temp = 0;
		//Arrays.sort(a);
		
		//int n = a.length;
		for(int i=a.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1]=temp;
				}
				System.out.println(Arrays.toString(a) + " i="+i+ " j="+j);
			}
			System.out.println(Arrays.toString(a) + " i="+i);
		}
	
		System.out.println(Arrays.toString(a));
	}

}