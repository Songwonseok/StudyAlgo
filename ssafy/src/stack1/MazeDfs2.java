package stack1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MazeDfs2 {
	public static int[][] maze = {
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0},
	};
	
	public static int[] di= {0,0,-1,1};
	public static int[] dj= {-1,1,0,0};
	
	public static int N=maze.length;
	public static int cnt=0;
	public static Stack<int[]> stack;
	public static int[][] visit;
	
	public static void main(String[] args) throws Exception{
		stack = new Stack<int[]>();
		visit = new int[N][N];
		
		//dfsr(0,0,1);
		dfs(0,0,1);
		
//		System.out.println();
//		for(int[] a:maze) System.out.println(Arrays.toString(a));
//		System.out.println();
//		for(int[] a:visit) System.out.println(Arrays.toString(a));
	}

	public static void dfs(int i, int j, int cnt) {
		stack.push(new int[] {i,j,cnt});
		while(!stack.empty()) {
			int[] curr = stack.pop();
			i=curr[0];
			j=curr[1];
			cnt = curr[2];
			if(visit[i][j] != 1) { //시작점을 -1로 둬서 이렇게 한 거 같은데 그렇게 안하면 ==0 이라고 해도 무방
				visit[i][j] = 1;
				if(i==N-1 && j==N-1) {
					System.out.println("i=" + i + ", j=" + j + ", cnt=" + cnt);
					return;
				}
				for(int d=0;d<di.length;d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj] == 0 && visit[ni][nj] == 0) {
						stack.push(new int[] {ni,nj, cnt+1});
					}
				}
			}
		}
		
	}
	
	
	private static void dfsr(int i, int j, int cnt) {
		visit[i][j] = 1;
		if(i==N-1 && j==N-1) {
			System.out.println("i=" + i + ", j=" + j + ", cnt=" + cnt);
			return;
		}
		
		for(int d=0;d<di.length;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj] == 0 && visit[ni][nj] == 0) {
				visit[ni][nj] = visit[i][j] = 1;
				dfsr(ni,nj,cnt+1);
			}				
		}	
		visit[i][j]=0;
	}	
}