package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
//비트연산을 사용해서 중복을 없앰
//중복순열. nPr => n*(n-1)*...*(n-r) =>5P3 => 5*4*3 = 60
public class Baby_gin {
	public static final int N=6;
	public static int[] n= new int[6];
	public static int[] a= new int[6];

	public static boolean permutation(int flag, int count) {
		if(count == N) {
			int tri=0;
			int run=0;

			if(a[0]==a[1] && a[1]==a[2]) tri++;
			if(a[3]==a[4] && a[4]==a[5]) tri++;
			if(a[0]+1==a[1] && a[1]+1==a[2]) run++;
			if(a[3]+1==a[4] && a[4]+1==a[5]) run++;
			if(tri+run == 2 || tri == 2) return true;
			else return false;
		}
		
		for(int i=0;i<N;i++) {
			if((flag & (1<<i))==0) { //사용했니 안했니?
				a[count] = n[i];
				if(permutation(flag|(1<<i),count+1)) return true; //사용했다~
			}			
		}
		return false;		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	
		
		for(int tc=0; tc<T;tc++) {
			for(int i=0;i<N;i++)
				n[i] = sc.nextInt();
			System.out.print("#" + (tc+1) + " " + permutation(0, 0));
			System.out.println();
		}
		sc.close();
	}

}


