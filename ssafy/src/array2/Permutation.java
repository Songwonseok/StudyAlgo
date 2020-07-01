package array2;

import java.util.Arrays;
import java.util.Scanner;

//순열. nPr => n*(n-1)*...*(n-r) =>5P3 => 5*4*3 = 60
public class Permutation {
	public static int n,r,cnt,a[];

	public static void Permutation(int start, int count) {
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
		for(int i=1;i<=n;i++) {
			a[count] = i;
			Permutation(i,count+1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=5;//sc.nextInt();
		r=3;//sc.nextInt();
		a = new int[r];
		Permutation(1,0);
		System.out.println(cnt);
		sc.close();

	}

}

//배열에 겹치는 숫자가 있으면 안되게 출력하기!! 비복원추출.
