package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
//카운팅 배열을 사용하여 babygin을 풀어보자
public class Baby_gin2 {
	public static final int N=6;
	public static int[] n= new int[6];
	public static int[] c;

	public static boolean solve() {
		int tri=0;
		int run=0;
		for(int i=0;i<c.length;i++) {
			if(c[i]>=3) {
				c[i]=c[i]-3;
				tri++;
				i--;
			}else if(c[i]>=1 && c[i+1]>=1 && c[i+2]>=1 && i<=7) {
				c[i]--; c[i+1]--; c[i+2]--;
				run++;
				i--;
			}
		}
		if(tri+run == 2 || tri == 2) return true;
		else return false;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	
		
		for(int tc=0; tc<T;tc++) {
			c=new int[10];
			for(int i=0;i<N;i++){
				n[i] = sc.nextInt();
				c[n[i]]++;
			}
			System.out.println("#" + (tc+1) + " " + solve());
			
		}

		sc.close();

	}

}


