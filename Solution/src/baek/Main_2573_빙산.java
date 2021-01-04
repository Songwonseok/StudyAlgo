package baek;

import java.io.*;
import java.util.*;

public class Main_2573_빙산 {
	static int N,M;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	
	// 빙산 녹이기
	public static int[][] meltingIceberg(int[][] iceberg){
		int[][] nextYear = new int[N][M];
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				if(iceberg[x][y] != 0) {
					int count = 0;
					for(int dir=0;dir<dx.length;dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M || iceberg[nx][ny] != 0)
							continue;
						count++;
					}
					nextYear[x][y] = (iceberg[x][y] - count > 0)? iceberg[x][y] - count : 0;
				}
			}
		}
		
		return nextYear;
	}
	
	// 빙산 갯수 세기
	public static int countingIcebergs(int[][] iceberg) {
		boolean[][] visit = new boolean[N][M];
		int count = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(iceberg[i][j] != 0 && !visit[i][j]) {
					visit[i][j] = true;
					count++;
					Queue<int[]> queue = new LinkedList<>();
					
					queue.add(new int[] {i,j});
					
					while(!queue.isEmpty()) {
						int[] curr = queue.poll();
						
						for(int dir=0;dir<dx.length;dir++) {
							int nx = curr[0] + dx[dir];
							int ny = curr[1] + dy[dir];
							if(nx <0 || nx >= N || ny < 0 || ny >= M || iceberg[nx][ny] == 0 || visit[nx][ny])
								continue;
							visit[nx][ny] = true;
							queue.add(new int[] {nx,ny});
						}
						
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] iceberg = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int years = 0;
		
		while(true) {
			int countIceberg = countingIcebergs(iceberg);
			if(countIceberg == 0) {
				// 빙산이 다 녹음
				System.out.println(0);
				return;
			}else if(countIceberg >= 2) {
				// 빙산이 2개 이상으로 나눠짐
				System.out.println(years);
				return;
			}else if(countIceberg == 1){
				// 아직 빙산이 나눠지지 않음
				int[][] meltedIceberg = meltingIceberg(iceberg);
				years++;
			}
		}
	}
}
