package baek;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N,M,D,result;
	static int[][] map;
	static int[] archer;
	static boolean[] v;
	
	public static void comb(int r,int start) {
		if(r==3) {
			attack();
			return;
		}
		for(int i=start;i<M;i++) {
			if(!v[i]) {
				v[i] = true;
				archer[r] = i;
				comb(r+1,i);
				v[i] = false;
			}
		}
	}
	public static void move(int[][] m) {
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(m[i][j] == 1) {
					m[i][j] =0;
					if(i != N-1) {
						m[i+1][j] = 1;
					}
				}
			}
		}
	}
	
	public static boolean checkEnd(int[][] temp) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 1)
					return true;
			}
		}
		
		return false;
	}
	
	public static void attack() {
		int[][] temp = new int[N][M];
		int cnt=0;
		
		
		for(int i=0;i<N;i++)
			temp[i] = map[i].clone();
		
		while(checkEnd(temp)) {
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int t=0;t<3;t++) {
				int[] min = {100,0};
				for(int i=N-1;i>=0;i--) {
					for(int j=0;j<M;j++) {
						if(temp[i][j] ==1) {
							int dis = N-i + Math.abs(archer[t]-j);
							if(dis <= D && dis < min[0]) {
								min[0] = dis;
								min[1] = i*M+j;
							}
						}
					}
				}
				if(min[0] != 100 && !list.contains(min[1])) {
					list.add(min[1]);
				}
			}
			
			for(int i=0;i<list.size();i++) {
				int x = list.get(i)/M;
				int y = list.get(i)%M;
				temp[x][y] = 0;
				cnt++;
			}
			
			move(temp);
		}
		result = Math.max(result, cnt);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[M];
		archer = new int[3];
		result =0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(result);
		
	}

}