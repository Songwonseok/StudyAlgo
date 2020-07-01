package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class Comb {
	public static int n,r,cnt,a[],d[]= {1,2,3,4,5};

	public static void comb(int n, int r) {
		if(r == 0) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}else if(n<r) return;
		else{
			a[r-1]=d[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		a = new int[r];
		comb(n,r);
		System.out.println(cnt);
		sc.close();

	}

}