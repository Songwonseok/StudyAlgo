package array2;

import java.util.Arrays;

public class Array2 {

	public static void main(String[] args) {
		int[][] a = {{1,2,3}, 
					 {4,5,6}, 
					 {7,8,9}};
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[j][i] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j+(a[i].length-1-2*j)*(i%2)] + " ");//-해줘야 인덱스가 되고, j가 하나 있으니까 2를 곱해서 빼준다.
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] b = new int[a.length][];
		for(int i=0;i<a.length;i++) {
			b[i] = Arrays.copyOf(a[i], a[i].length);
		}
		
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == 5) {					
					int[] di = {-1,-1,0,1,1,1,0,-1};
					int[] dj = {0,1,1,1,0,-1,-1,-1};
					for(int d=0;d<di.length;d++) {
						int ni=i+di[d];
						int nj=j+dj[d];
						System.out.print(a[ni][nj]);
					}
				}
			}
			System.out.println();
		}
		
		
		//8방향
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				if(a[i][j] == 5) {					
//					int[] di = {-1,-1,0,1,1,1,0,-1};
//					int[] dj = {0,1,1,1,0,-1,-1,-1};
//					for(int d=0;d<di.length;d++) {
//						int ni=i+di[d];
//						int nj=j+dj[d];
//						System.out.print(a[ni][nj]);
//					}
//				}
//			}
//			System.out.println();
//		}
		
		
		
		//X4방향
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				if(a[i][j] == 5) {					
//					int[] di = {-1,1,1,-1};
//					int[] dj = {1,1,-1,-1};
//					for(int d=0;d<di.length;d++) {
//						int ni=i+di[d];
//						int nj=j+dj[d];
//						System.out.print(a[ni][nj]);
//					}
//				}
//			}
//			System.out.println();
//		}
//		
		
		
		//+4방향
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				if(a[i][j] == 5) {
//					System.out.print(a[i-1][j]);
//					System.out.print(a[i][j+1]);
//					System.out.print(a[i+1][j]);
//					System.out.print(a[i][j-1]);
//					System.out.println();
//					
//					int[] di = {-1,0,1,0};
//					int[] dj = {0,1,0,-1};
//					for(int d=0;d<di.length;d++) {
//						int ni=i+di[d];
//						int nj=j+dj[d];
//						System.out.print(a[ni][nj]);
//					}
//				}
//			}
//			System.out.println();
//		}
		
		
		
//		for(int[] v:b) System.out.println(Arrays.toString(v));
//		System.out.println();
//		for(int i=0;i<b.length;i++) {
//			for(int j=0;j<b[i].length;j++) {
//				if(i<j) {
//					int T = b[i][j];
//					b[i][j]=b[j][i];
//					b[j][i]=T;
//				}
//			}
//		}
//		for(int[] v:b) System.out.println(Arrays.toString(v));
	}

}
