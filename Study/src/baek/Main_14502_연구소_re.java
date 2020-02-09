package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_re {
	static int[][] lab, column;
	static boolean[][] v;
	static int max,N,M;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static ArrayList<Integer> list;
	
	public static void spread() {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++)
			temp[i] = lab[i].clone();
		for(int i=0;i<3;i++) {
			temp[column[i][0]][column[i][1]] = 1;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<list.size();i++)
			que.add(list.get(i));
		
		
		while(!que.isEmpty()) {
			int x = que.peek()/M;
			int y = que.poll()%M;
			
			for(int dir=0;dir<4;dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx >=0 && nx <N && ny >=0 && ny <M && temp[nx][ny] ==0) {
					temp[nx][ny] = 2;
					que.add(nx*M+ny);
				}
			}
		}
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}
	
	public static void solve(int r,int si, int sj) {
		if(r==3) {
			spread();
			return;
		}
		
		for(int i=si;i<N;i++) {
			for(int j=sj;j<M;j++) {
				if(!v[i][j] && lab[i][j] == 0) {
					column[r][0] = i;
					column[r][1] = j;
					v[i][j] = true;
					solve(r+1,i,j);
					v[i][j] = false;
				}
			}
			sj=0;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max=0;
		lab = new int[N][M];
		column = new int[3][2];
		v = new boolean[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					list.add(i*M+j);
				}
			}
		}
		solve(0,0,0);
		System.out.println(max);
	}
}
