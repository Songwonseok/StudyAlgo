package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//중복순열. nㅠr =>n^r => 5ㅠ3 => 5*5*5 = 125
//순열. nPr => n*(n-1)*...*(n-r) =>5P3 => 5*4*3 = 60
//중복조합. nHr =>(n+r-1)Cr => 5H3 => (5+3-1)C3 = 7C3 = 7C4 = 7P3/3! = 7*6*5/3*2*1 = 35
//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class permcomb2 {
	public static int r,n,cnt,a[],v[],d[]= {0,1};
	public static char[] c= {'A','B','C','D'};
	
	public static void powerset(int count) {
		if(count == r) {
			cnt++;
			System.out.print(Arrays.toString(a)+" ");
			for(int i=0;i<r;i++) {
				if(a[i]==1) System.out.print(c[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			v[count]=i;
			powerset(count+1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=d.length;//sc.nextInt();
		r=4;
		v = new int[n];
		a = new int[r];
		powerset(0);
		System.out.println(cnt);
		sc.close();
	}
}
//몽땅 출력하기!!!!