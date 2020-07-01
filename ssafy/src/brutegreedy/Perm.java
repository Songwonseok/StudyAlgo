package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//중복순열. nㅠr =>n^r => 5ㅠ3 => 5*5*5 = 125
//순열. nPr => n*(n-1)*...*(n-r) =>5P3 => 5*4*3 = 60
//중복조합. nHr =>(n+r-1)Cr => 5H3 => (5+3-1)C3 = 7C3 = 7C4 = 7P3/3! = 7*6*5/3*2*1 = 35
//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class Perm {
	public static int n,cnt,d[]= {1,2,3,4};

	public static void swap(int i,int j) {
		if(i==j) return;
		int T=d[i];d[i]=d[j];d[j]=T;
	}
	public static void perm(int count) {
		if(count == n) {
			cnt++;
			System.out.println(Arrays.toString(d));
			return;
		}
		for(int i=count;i<n;i++) {
			swap(count,i);
			perm(count+1);
			swap(count,i);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=d.length;
		perm(0);
		System.out.println(cnt);
		sc.close();

	}

}
//몽땅 출력하기!!!!