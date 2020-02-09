package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static int N;
	static int[][] fertilizer;
	//12시부터 시계방향
	static int[] dx = {-1,-1,0,1,1,1,0,-1}, dy = {0,1,1,1,0,-1,-1,-1};
	static PriorityQueue<Tree> que;
	
	static class Tree{
		int x,y,age;
		public Tree(int x,int y, int z){
			this.x =x;
			this.y =y;
			this.age =z;
		}
	}
	
	public static void solve(int K) {
		ArrayList<Tree> die = new ArrayList<>();
		ArrayList<Tree> list = new ArrayList<>();
		int[][] map =new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				map[i][j] =5;
			}
		
		int year=0;
		
		while(year <K) {
			//봄
			while(!que.isEmpty()) {
				Tree t = que.poll();
				if(t.age > map[t.x][t.y]) {
					die.add(t);
				}else {
					map[t.x][t.y] -= t.age;
					t.age++;
					list.add(t);
				}
			}
			
			//여름
			for(int i=0;i<die.size();i++) {
				Tree t = die.get(i);
				map[t.x][t.y] += t.age/2;
			}
			//가을
			
			for(int i=0;i<list.size();i++) {
				que.add(list.get(i));
				if(list.get(i).age%5 ==0) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					for(int j=0;j<dx.length;j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx <0 || nx >= N || ny <0 || ny >= N)
							continue;
						que.add(new Tree(nx,ny,1));
					}
				}
			}
			
			//겨울
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] += fertilizer[i][j];
				}
			}
			list.clear();
			die.clear();
			year++;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		fertilizer = new int[N][N];
		que =  new PriorityQueue<>(new Comparator<Tree>() {
			public int compare(Tree o1, Tree o2) {
				return Integer.compare(o1.age, o2.age);
			}
		});
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				fertilizer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			que.add(new Tree(x,y,z));
		}
		
		solve(K);
		
		System.out.println(que.size());
		
	}
}
