package array1;

import java.util.Arrays;

public class Array2Test {

	public static void main(String[] args) {
		//1.선언
		int[][] a;
		//2.생성
		a=new int[3][3];
		//1+2
		int[][] b = new int[3][3];
		//3.초기화
		b[0][0]=10;
		b[1][1]=11;
		b[2][2]=12;
		//1+2+3
		int[][] c = {{10,0,0}, 
					{0,11,0}, 
					{0,0,12}};
		int[][] d = new int[][]{{10,0,0}, 
								{0,11,0}, 
								{0,0,12}};
		int[][] e;
		e = new int[][]{{10}, 
						{0,11}, 
						{0,0,12}};
		//4.출력
//		for(int i=0;i<e.length;i++) {
//			for(int j=0;j<e[i].length;j++) {
//				System.out.print(e[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int[] va:e) {
//			for(int v:va) {
//				System.out.print(v+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for(int[] v:e) System.out.println(Arrays.toString(v));
						
		//5.복제
		int[][] f = new int[e.length][];
		for(int i=0; i<e.length;i++) {
			//f[i]=new int[e[i].length];
			//System.arraycopy(e[i],0,f[i],0,e[i].length); //e의 0번째를 f의 0번에 e.length만큼 채워넣는다.
			f[i]=Arrays.copyOf(e[i], e[i].length); //위에꺼랑 같은애
		}
		
		e[0][0]=0;
		for(int[] v:e) System.out.println(Arrays.toString(v));
		for(int[] v:f) System.out.println(Arrays.toString(v));
	}
}