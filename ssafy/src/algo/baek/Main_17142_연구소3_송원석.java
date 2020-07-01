package algo.baek;


import java.io.*;
import java.util.*;

public class Main_17142_연구소3_송원석{
	static int N,M,min;
	static int[][] lab,ar;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static ArrayList<int[]> list;
	static boolean[] v;
	static boolean flag;
	
	public static void comb(int si,int r) {
		if(r==M) {
			spread();
			return;
		}
		
		for(int i=si;i<list.size();i++) {
			if(!v[i]) {
				v[i] = true;
				ar[r][0] = list.get(i)[0];
				ar[r][1] = list.get(i)[1];
				comb(i,r+1);
				v[i] = false;
			}
		}
	}
	
	public static void spread() {
		Queue<int[]> q = new LinkedList<>();
		int[][] temp = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(temp[i], -1);
			for(int j=0;j<N;j++) {
				if(lab[i][j] == 1) {
					temp[i][j] =1;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			q.offer(new int[] {ar[i][0], ar[i][1]});
			visit[ar[i][0]][ar[i][0]] = true;
			temp[ar[i][0]][ar[i][0]] = 0;
		}
		
		int check=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(lab[i][j] ==0) {
					check++;
				}
			}
		}
		if(check ==0) {
			flag = true;
			min = 0;
			return;
		}
			
		

		int size = q.size();
		int time=1;
		int cnt=0;
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			cnt++;
			
			for(int i=0;i<4;i++) {
				int nx = curr[0] + di[i];
				int ny = curr[1] + dj[i];
				if(nx>=0 && nx <N && ny >=0 && ny<N && lab[nx][ny] !=1 && !visit[nx][ny]) {
					if(lab[nx][ny] == 2) {
						temp[nx][ny] = 0;
					}else
						temp[nx][ny] = time;
					
					visit[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
			
			//�̷ο��� �ִܰŸ� ���Ҷ� �Ÿ��� ������ 
			if(cnt == size) {
				size = q.size();
				cnt=0;
				time++;
			}
		}
		int max = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(temp[i][j] > max) {
					max = temp[i][j];
				}
				if(temp[i][j] ==-1) {
					return;
				}
			}
		}
		
		
		min = Math.min(max, min);
		flag= true;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		ar = new int[M][2];
		lab = new int[N][N];
		list = new ArrayList<>();
		flag = false;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		v = new boolean[list.size()];
		comb(0,0);
		if(flag) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
		
		
		
		
		
	}

}
