package SSAFY.Array2;

import java.util.Arrays;
import java.util.Scanner;

//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class Combination2 {
	public static int n,r,cnt,a[];

	public static void combination(int start, int flag, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<=n;i++) {
			if((flag&(1<<i))==0) {
				a[count] = i;
				combination(i+1,flag|(1<<i),count+1);
			}
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		a = new int[r];
		combination(1,0,0);
		System.out.println(cnt);
		sc.close();

	}
}

//순서랑 안에 값도 중복이 안되게