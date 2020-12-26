package SSAFY.Array2;

import java.util.Arrays;
import java.util.Scanner;

//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class Combination {
	public static int n,r,cnt,a[];

	public static void combination(int start, int count) {
		if(count == r) {
			for(int i=0;i<r;i++) {
				for(int j=i+1;j<r;j++) {
					if(a[i] == a[j]) return;
				}
			}
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<=n;i++) {
			a[count] = i;
			combination(i,count+1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		a = new int[r];
		combination(1,0);
		System.out.println(cnt);
		sc.close();

	}
}

//순서랑 안에 값도 중복이 안되게(집합에서 중복도 제거)