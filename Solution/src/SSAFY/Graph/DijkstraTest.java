package SSAFY.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DijkstraTest {
	public static int N=7;
	public static int INF=Integer.MAX_VALUE/2;
	public static int[][] a={
		{  0, 67,INF, 28, 17,INF, 12},
		{ 67,  0,INF, 24, 62,INF,INF},
		{INF,INF,  0,INF, 20, 37,INF},
		{ 28, 24,INF,  0,INF,INF, 13},
		{ 17, 62, 20,INF,  0, 45, 73},
		{INF,INF, 37,INF, 45,  0,INF},
		{ 12,INF,INF, 13, 73,INF,  0},
	};
	
	public static boolean[] v;
	public static int[]d ;
	public static int getSmallIndex() {
		int index=0;
		int min=INF;
		for(int i=0;i<N;i++) {
			if(min>d[i] && !v[i]) {
				min=d[i];
				index=i;
			}
		}
		System.out.println("min index="+index);
		return index;
	}
	public static void dijkstra(int start) {
//		for(int i=0;i<N;i++) {
//			d[i]=a[start][i];
//		}
		d=Arrays.copyOf(a[start], N); //위에 for문을 쓰던지 얘를 쓰던지
		System.out.println(Arrays.toString(d));
		System.out.println();
		v[start]=true;
		for(int i=0;i<N-2;i++) {//0을 빼서 -2해야함
			int curr = getSmallIndex();
			v[curr]=true;
			for(int j=0;j<N;j++) {
				if(!v[j]) {
					if(d[j]>d[curr]+a[curr][j]) {
						d[j]=d[curr]+a[curr][j];
					}
				}
			}
			System.out.println(Arrays.toString(d));
		}
	}
	
	public static void main(String[] args) {	
		v = new boolean[N];
		d = new int[N];
		dijkstra(0);
		System.out.println();
		System.out.println(Arrays.toString(d));

	}

}
