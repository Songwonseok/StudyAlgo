package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	//상 우 하 좌
	//세로면 dir =1 / dir+1%4 dir+ 3%4
	//가로면 dir = 0 / dir+1%4 dir +3%4
	
	static int N;
	static int[][] map;
	static boolean[][][] v;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[2][N][N];
		int cnt=0;
		int index=0;
		int[] log = new int[3]; //중앙, 방향, cnt
		int[] end = new int[3];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				if(line.substring(j, j+1).contains("B")) {
					cnt++;
					
					if(cnt==2) {
						log[0] = i*N+j;
					}else if(cnt ==1) {
						map[i][j] = 2;
					}
				}else if(line.substring(j, j+1).contains("E")) {
					end[index++] = i*N + j;
				}else {
					map[i][j] = Integer.parseInt(line.substring(j, j+1));
				}
			}
		}
		// 1 4 / 0 3
		for(int i=0;i<2;i++) {
			int nx= log[0]/N + dx[i];
			int ny = log[0]%N + dy[i];
			if(nx >=0 && nx <N && ny >=0 && ny <N && map[nx][ny] ==2 ) {
				map[nx][ny] =0;
				log[1] = i;
				break;
			}
			nx= log[0]/N + dx[(i+2)%4];
			ny= log[0]%N + dy[(i+2)%4];
			if(nx >=0 && nx <N && ny >=0 && ny <N && map[nx][ny] ==2 ) {
				map[nx][ny] =0;
				log[1] = i;
				break;
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		
		que.add(log);
		int result=0;
		v[log[1]][log[0]/N][log[0]%N] = true;
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			int x = curr[0]/N;
			int y = curr[0]%N;
			int dir = curr[1];
			if(x == end[1]/N && y == end[1]%N) {
				int nx = x+ dx[dir];
				int ny = y + dy[dir];
				if(nx == end[0]/N || nx == end[2]/N || ny == end[0]%N || ny == end[2]%N) {
					result = curr[2];
					break;
				}
			}
			//상,하,좌,우,90도
			
			for(int i=0;i<4;i++) {
				int nx = x+ dx[i];
				int ny = y+ dy[i];
				if(nx <0 || nx >=N || ny <0 || ny >=N || map[nx][ny] == 1 || v[dir][nx][ny])
					continue;
				if(checkside(nx,ny,dir)) {
					que.add(new int[] {nx*N+ny, dir, curr[2]+1});
					v[dir][nx][ny] = true;
				}
			}
			if(checkturn(x,y) 
					&& !v[(dir+1)%2][x][y]) {
				que.add(new int[] {x*N+y,(dir+1)%2,curr[2]+1});
				v[(dir+1)%2][x][y] = true;
			}
		}
		
		System.out.println(result);
		
		
	}
	public static boolean checkside(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx <0 || nx >=N || ny <0 || ny >=N || map[nx][ny] ==1)
			return false;
		nx = x + dx[(dir+2)%4];
		ny = y + dy[(dir+2)%4];
		if(nx <0 || nx >=N || ny <0 || ny >=N || map[nx][ny] ==1)
			return false;
		
		return true;
	}
	public static boolean checkturn(int x,int y) {
		int[] dx = {-1,-1,0,1,1,1,0,-1}, dy = {0,1,1,1,0,-1,-1,-1};
		
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <0 || nx >= N || ny <0 || ny >=N || map[nx][ny] ==1)
				return false;
		}
		
		return true;
	}
	
	

}
