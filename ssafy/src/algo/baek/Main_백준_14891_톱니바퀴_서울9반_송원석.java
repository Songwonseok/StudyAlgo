package algo.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴_서울9반_송원석{
	static int[][] gears;
	static boolean[] v;
	
	
	public static int[] rotation (int [] gear) {
		int[] rg = new int[8];
		rg[0] = gear[7];
		for(int i=1;i<8;i++) {
			rg[i] = gear[i-1];
		}
		
		return rg;
	}
	public static int[] reverse (int [] gear) {
		int[] rg = new int[8];
		
		rg[7] = gear[0];
		for(int i=6;i>=0;i--) {
			rg[i] = gear[i+1];
		}
		return rg;
	}
	public static void game(int n, int dir) {
		if(!v[n]) {
			v[n] = true;
			if(n-1 >=0 && !v[n-1]) {
				if(gears[n][6] == gears[n-1][2])
					v[n-1] = true;
				else {
					game(n-1,dir*-1);
				}
			}
			if(n+1 < 4 && !v[n+1]) {
				if(gears[n][2] == gears[n+1][6])
					v[n+1] = true;
				else {
					game(n+1,dir*-1);
				}
			}
		}
		if(dir == 1) {
			gears[n] = rotation(gears[n]);
		}else {
			gears[n] = reverse(gears[n]);
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		gears = new int[4][8]; // N = 0 , S = 1
		for(int i=0;i<4;i++) {
			String line = bf.readLine();
			for(int j=0;j<8;j++) {
				gears[i][j] = line.charAt(j)-'0';
			}
		}
		
		int score=0;
		int cnt= Integer.parseInt(bf.readLine());
		int[][] simul = new int[cnt][2]; 
		for(int i=0;i<cnt;i++) {
			StringTokenizer st= new StringTokenizer(bf.readLine());
			simul[i][0] = Integer.parseInt(st.nextToken())-1;
			simul[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<cnt;i++) {
			v = new boolean[4];
			game(simul[i][0],simul[i][1]);
		}
		
		
		for(int i=0;i<4;i++) {
			score += gears[i][0] * Math.pow(2, i);
		}
		
		System.out.println(score);
		
	}
	

}
