package stack2;

import java.util.Scanner;

public class NQueen {
	public static int N;
	public static int result;
	public static int[] col; //이렇게 해서 이차원 배열을 표현할 수 있음..

	public static boolean promising(int i) {
		for(int j=0;j<i;j++) {
			if(col[j] == col[i] || Math.abs(col[i]-col[j]) == (i-j)) return false; //같은선상에 있느냐 혹은 대각선상에 위치하는가
		}
		return true;
	}
	public static void nqueen(int i, String ij) {
		if(i == N) {
			result++;
			System.out.println(ij);
			return;
		}
		for(int j=0;j<N;j++) {
			col[i] = j;
			if(promising(i)) nqueen(i+1, ij+"(" + i + "," + col[i] + ")"); //좌표찍기
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		nqueen(0,"");
		System.out.println(result); //놓을 수 있는 경우의 수를 찾아라
	}


}
