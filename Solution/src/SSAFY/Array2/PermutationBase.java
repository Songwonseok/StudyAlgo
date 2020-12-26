package SSAFY.Array2;

import java.util.Arrays;
import java.util.Random;

public class PermutationBase {

	public static void main(String[] args) {
		int[] a = {1,2,3};//new int[3];
//		Random r = new Random();
//		for(int i=0;i<a.length;i++) {
//			a[i]=r.nextInt(10); //0-9까지 들어감
//		}
		System.out.println(Arrays.toString(a));
		int cnt=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i] != a[j]) {
					for(int k=0;k<a.length;k++){
						if(a[k] != a[i] && a[k] !=a[j]) {
							System.out.println(a[i] + " " + a[j] + " " + a[k]);
							cnt++;
						}
						
					}
				}			
			}
		}
		System.out.println(cnt);
	}

}
