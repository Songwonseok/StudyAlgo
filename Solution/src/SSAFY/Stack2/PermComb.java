package SSAFY.Stack2;

import java.util.Arrays;
import java.util.Scanner;

//중복순열. nㅠr =>n^r => 5ㅠ3 => 5*5*5 = 125
//순열. nPr => n*(n-1)*...*(n-r) =>5P3 => 5*4*3 = 60
//중복조합. nHr =>(n+r-1)Cr => 5H3 => (5+3-1)C3 = 7C3 = 7C4 = 7P3/3! = 7*6*5/3*2*1 = 35
//조합. nCr => nPr/r! => 5C3/3!= 5*4*3/3*2*1 = 10
public class PermComb {
	public static int n,r,cnt,a[],v[],d[]= {1,2,3,4,5};

	public static void permcomb(int start, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<n;i++) {
			if(v[i]==0) { //중복 순열&조합은 visit를 주석. 순열은 i가 0부터 시작이지만, 조합은 start부터 시작
				v[i]=1;
				a[count] = d[i];
				permcomb(i, count+1);
				v[i]=0;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		v = new int[n];
		a = new int[r];
		permcomb(0,0);
		System.out.println(cnt);
		sc.close();

	}

}
//몽땅 출력하기!!!!