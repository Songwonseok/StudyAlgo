package SSAFY.Array1;

import java.util.Arrays;

public class Counting {

	public static void main(String[] args) {
		int[] a = {0,4,1,3,1,2,4,1};
		int m=Arrays.stream(a).max().getAsInt();
		int[] c = new int[m+1];
		int[] s = new int[a.length];
		
		for(int i=0;i<a.length; i++) c[a[i]]++; //갯수 카운팅 저장 배열
		for(int i=1;i<c.length; i++) c[i] += c[i-1]; //카운트 배열 누적
		for(int i=0;i<a.length; i++) {
			c[a[i]]--;
			s[c[a[i]]] = a[i];
		}
		System.out.println(Arrays.toString(s));
	}

}
