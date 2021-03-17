package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int[][] paper;
	static int ONE = 0, ZERO = 0, MINUS = 0;
	
	public static void addCount(int num) {
		if(num == 1) {
			ONE++;
		}else if(num == 0) {
			ZERO++;
		}else {
			MINUS++;
		}
	}
	
	public static boolean isSame(int sx, int sy, int size) {
		int num = paper[sx][sy];
		for(int i = sx;i<sx + size;i++) {
			for(int j=sy;j<sy + size; j++) {
				if(num != paper[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void cutPaper(int sx, int sy, int size) {
		if(isSame(sx,sy,size)) {
			addCount(paper[sx][sy]);
		}else {
			int newSize = size/3;
			for(int i=sx;i<sx + size;i += newSize) {
				for(int j=sy;j<sy + size; j += newSize) {
					cutPaper(i,j,newSize);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutPaper(0,0,N);
		sb.append(MINUS+"\n").append(ZERO+"\n").append(ONE);
		
		System.out.println(sb);
	}

}
