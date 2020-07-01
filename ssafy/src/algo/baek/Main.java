package algo.baek;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static int N,M,num,min, INF = Integer.MAX_VALUE/2;
	
	static int[] di = {-1,1,0,0}, dj = {0,0,-1,1};
	static int[][] map,graph;
	
	
	public static void prim(int n) {
		boolean[] v = new boolean[num];
		int sum=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int next=0;next<num;next++) {
			pq.offer(new int[] {graph[n][next],next});
		}
		v[n] = true;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int dis = cur[0];
			int curr = cur[1];
			if(dis == 10000)
				continue;
			if(!v[curr]) {
				v[curr] = true;
				sum += dis;
				for(int next=0;next<num;next++) {
					pq.offer(new int[] {graph[curr][next],next});
				}
			}
		}
		
		
		for(int i=0;i<num;i++) {
			if(!v[i])
				return;
		}
		min = Math.min(min, sum);
	}
	
	public static void findIsland(Point a) {
		int x = a.x;
		int y = a.y;
		map[x][y] =num;
		for(int i=0;i<4;i++) {
			int nx = x+di[i];
			int ny = y+dj[i];
			if(nx>=0 && nx<N && ny >=0 && ny < M && map[nx][ny] == -1) {
				findIsland(new Point(nx,ny));
			}
		}
	}
	
	public static void distance(Point a) {
		int x= a.x;
		int y= a.y;
		int start = map[x][y];
		
		for(int i=0;i<4;i++) {
			int nx= x+di[i];
			int ny= y+dj[i];
			if(nx>=0 && nx<N && ny >=0 && ny < M && map[nx][ny] != start) {
				int cnt=1;
				while(true) {
					nx += di[i];
					ny += dj[i];
					cnt++;
					if(nx<0 || nx>=N || ny <0 || ny >= M)
						break;
					
					if(map[nx][ny] != 0) {
						if(cnt == 2)
							break;
						if(cnt-1 < graph[start-1][map[nx][ny]-1]) {
							graph[start-1][map[nx][ny]-1] = cnt-1;
							graph[map[nx][ny]-1][start-1] = cnt-1;
						}
						break;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st =new StringTokenizer(bf.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int[N][M];
		num=1;
		min = INF;
		
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())* -1;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==-1) {
					findIsland(new Point(i,j));
					num++;
				}
			}
		}
		
		graph = new int[--num][num];
		for(int i=0;i<num;i++)
			Arrays.fill(graph[i], 10000);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) {
					distance(new Point(i,j));
				}
			}
		}
		for(int i=0;i<num;i++) {
			prim(i);
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		if(min == INF)
			System.out.println(-1);
		else
			System.out.println(min);
		
	}

}
