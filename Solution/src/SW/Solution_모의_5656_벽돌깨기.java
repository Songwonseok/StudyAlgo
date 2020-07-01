package SW;

import java.io.*;
import java.util.*;

public class Solution_모의_5656_벽돌깨기 {
	static int N,W,H,total,result,min;
	static int[] permNum,dx= {-1,1,0,0}, dy= {0,0,-1,1};
	static int[][] map,temp;
	
	
	public static void perm(int r) {
		if(min ==0)
			return;
		if(r == N) { //공 떨구기
			temp = new int[H][W];
			for(int i=0;i<H;i++)
				temp[i] = map[i].clone();
			game();
			return;
		}
		for(int i=0;i<W;i++) {
			permNum[r] = i;
			perm(r+1);
		}
	}
	
	public static void game() {
		for(int i=0;i<N;i++) {
			//부수기
			for(int j=0;j<H;j++) {
				if(temp[j][permNum[i]] !=0) {
					if(temp[j][permNum[i]] ==1) {
						temp[j][permNum[i]] = 0;
					}
					else
						smash(j,permNum[i]);
					break;
				}
			}
			//내려보내기
			for(int w=0;w<W;w++) {
				for(int h=H-2;h>=0;h--) {
					if(temp[h][w] != 0) {
						for(int down =h+1;down<H;down++) {
							if(down ==H-1) {
								if(temp[down][w] ==0) {
									int tmp = temp[h][w];
									temp[h][w]=0;
									temp[down][w] = tmp;
								}else {
									int tmp = temp[h][w];
									temp[h][w]=0;
									temp[down-1][w] = tmp;
								}
							}else {
								if(temp[down][w] != 0) {
									int tmp = temp[h][w];
									temp[h][w]=0;
									temp[down-1][w] = tmp;
									break;
								}
							}
						}
					}
				}
			}
		}
		result=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(temp[i][j] !=0)
					result++;
			}
		}
		min= Math.min(min,result);
		
	}
	public static void smash(int x,int y){
		int val = temp[x][y]-1;
		temp[x][y] =0;
		for(int dir=0;dir<4;dir++) {
			int nx=x;
			int ny=y;
			for(int v=0;v<val;v++) {
				nx = nx + dx[dir];
				ny = ny + dy[dir];
				if(nx >=0 && nx < H && ny >= 0 && ny < W) {
					if(temp[nx][ny] == 1) {
						temp[nx][ny] =0;
					}else if(temp[nx][ny] == 0) {
						continue;
					}else {
						smash(nx,ny);
					}
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5656.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			permNum = new int[N];
			min = Integer.MAX_VALUE;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] !=0)
						total++;
				}
			}
			
			perm(0);
			
			
			System.out.println("#"+tc+" "+min);
		}
		
	}

}
