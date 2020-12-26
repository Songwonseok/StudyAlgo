package SSAFY.Array2;

import java.util.Arrays;
import java.util.Scanner;

//중복조합. nHr =>(n+r-1)Cr => 5H3 => (5+3-1)C3 = 7C3 = 7C4 = 7P3/3! = 7*6*5/3*2*1 = 35
public class Homogeneous {
	public static int n,r,cnt,a[];

	public static void homogeneous(int start, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<=n;i++) {
			a[count] = i;
			homogeneous(i,count+1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		a = new int[r];
		homogeneous(1,0);
		System.out.println(cnt);
		sc.close();

	}

}
//중복제거(집합의 개념에서 중복을 제거. 배열에서 같은 숫자는 제거하지 않았음)