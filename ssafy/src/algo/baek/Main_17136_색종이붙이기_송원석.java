package algo.baek;

import java.io.*;
import java.util.*;

public class Main_17136_색종이붙이기_송원석 {
	static boolean[][] visit;
	static int[] size = {0,5,5,5,5,5};
	static int[][] paper;
	static int min,allcheck,total,result;
	
	public static boolean check(int x, int y,int r) {
		for(int i=x;i<x+r;i++) {
			for(int j=y;j<y+r;j++) {
				if(i <0 || i >= 10 || j <0 || j >= 10 ||paper[i][j] ==0 ||visit[i][j] || size[r] ==0) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	public static void checkAll() {
		if(allcheck == total) {
			min = Math.min(min, result);
			return;
		}
		
		boolean flag = false;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				
				if(paper[i][j] == 1 && !visit[i][j]) {
					for(int r=5;r>0;r--) {
						flag = check(i,j,r);
						if(flag) {
							for(int k=i;k < i+r;k++)
								Arrays.fill(visit[k], j, j+r, true);
							size[r]--;
							result++;
							allcheck += r*r;
							checkAll();
							
							for(int k=i;k < i+r;k++)
								Arrays.fill(visit[k], j, j+r, false);
							size[r]++;
							allcheck -= r*r;
							result--;
						}
					}
					return;
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		//Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		paper = new int[10][10];
		visit = new boolean[10][10];
		total=0;
		allcheck=0;
		result=0;
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<10;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				//paper[i][j] =sc.nextInt();
				if(paper[i][j]==1)
					total++;
			}
		}
		min = 100;
		checkAll();
		if(min == 100) {
			System.out.println(-1);
		}else
			System.out.println(min);
		
		
		
	}

}
