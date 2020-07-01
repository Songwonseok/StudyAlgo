package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14503_로봇청소기 {
	static int[] dx = {-1,0,1,0}, dy= {0,1,0,-1};
	
	static class Robot{
		int x,y, dir;
		
		public Robot(int x,int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
		
		void changeDir() {
			this.dir = (this.dir+3)%4;
		}
			
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int cnt =0;
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(r,c,d);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			
			if(!visit[robot.x][robot.y]) {
				visit[robot.x][robot.y]= true; 
				cnt++;
			}
			boolean check = false; // 네 방향 탐색 끝났는지 체크
			
			for(int i=0;i<4;i++) {
				robot.changeDir();//왼쪽으로 방향이동
				int nx = robot.x + dx[robot.dir];
				int ny = robot.y + dy[robot.dir];
				if(nx >=0 && nx <N && ny >=0 && ny <M && !visit[nx][ny] && map[nx][ny] != 1) {
					check = true;
					robot.x = nx;
					robot.y = ny;
					break;
				}
			}
			if(!check) { //네 방향 다 없다면
				int bx = robot.x - dx[robot.dir];
				int by = robot.y - dy[robot.dir];
				if(map[bx][by] ==1) {
					break;
				}else {
					robot.x = bx;
					robot.y = by;
					continue;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
