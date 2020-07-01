package baek;

import java.io.*;
import java.util.*;

class Shark{
	int x;
	int y;
	int size;
	int cnt;
	Shark(int x, int y, int size, int cnt) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.cnt = cnt;
	}
}
public class Main_백준_16236_아기상어 {
	static int N,time =0;
	static int[][] map;
	static Shark baby;
	static ArrayList<int[]> list;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					baby = new Shark(i,j,2,0);
					map[i][j] = 0;
				}
			}
		}
		
		int prex;
		int prey;
		while(true) {
			if(!callMom())
				break;
			prex = baby.x;
			prey= baby.y;
			hunt(prex,prey);
			if(prex == baby.x && prey ==baby.y)
				break;
		}
		System.out.println(time);
		
	}
	public static void hunt(int x, int y) {
		int[] di = {-1,1,0,0}, dj = {0,0,-1,1};
		list = new ArrayList<>();
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {x,y,0});
		boolean[][] visit = new boolean[N][N];
		
		visit[x][y] = true;
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				int[] curr= que.poll();
				for(int dir=0;dir<4;dir++) {
					int nx= curr[0] + di[dir];
					int ny= curr[1] + dj[dir];
					if(nx >=0 && nx <N && ny >= 0 && ny <N && !visit[nx][ny] && map[nx][ny] <= baby.size) {
						visit[nx][ny] = true;
						que.offer(new int[] {nx,ny,curr[2]+1});
						if(map[nx][ny] > 0 && map[nx][ny] < baby.size)
							list.add(new int[] {nx,ny,curr[2]+1});
					}
				}
			}
			if(list.size() != 0)
				break;
		}
		if(list.size() == 0)
			return;
		Collections.sort(list,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1],o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		baby.x = list.get(0)[0];
		baby.y = list.get(0)[1];
		baby.cnt++;
		time += list.get(0)[2];
		map[baby.x][baby.y]=0;
		
		if(baby.cnt == baby.size) {
			baby.size++;
			baby.cnt = 0;
		}
	}
	public static boolean callMom() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] < baby.size && map[i][j] != 0)
					return true;
			}
		}
		return false;
	}
	
	
	

}
