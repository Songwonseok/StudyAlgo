package 정올;

import java.io.*;
import java.util.*;


public class Main_정올_2543_타일채우기{
	static int[][] map;
	
	public static void tile(int si,int sj, int ei, int ej, int hi,int hj, int hv) {
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		if(si == ei && sj == ej) {
			map[si][sj] = hv;
			return;
		}
		
		if(hi <= mi && hj <=mj) {
			tile(si,sj,mi,mj,hi,hj,hv);
			tile(si,mj+1,mi,ej,mi,mj+1,1);
			tile(mi+1,sj,ei,mj,mi+1,mj,1);
			tile(mi+1,mj+1,ei,ej,mi+1,mj+1,1);
		}else if(hi <= mi && hj > mj) {
			tile(si,sj,mi,mj,mi,mj,2);
			tile(si,mj+1,mi,ej,hi,hj,hv);
			tile(mi+1,sj,ei,mj,mi+1,mj,2);
			tile(mi+1,mj+1,ei,ej,mi+1,mj+1,2);
		}else if(hi > mi && hj <= mj) {
			tile(si,sj,mi,mj,mi,mj,3);
			tile(si,mj+1,mi,ej,mi,mj+1,3);
			tile(mi+1,sj,ei,mj,hi,hj,hv);
			tile(mi+1,mj+1,ei,ej,mi+1,mj+1,3);
		}else if(hi > mi && hj > mj) {
			tile(si,sj,mi,mj,mi,mj,4);
			tile(si,mj+1,mi,ej,mi,mj+1,4);
			tile(mi+1,sj,ei,mj,mi+1,mj,4);
			tile(mi+1,mj+1,ei,ej,hi,hj,hv);
		}
	}
	
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		tile(0,0,N-1,N-1,X,Y,0);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
