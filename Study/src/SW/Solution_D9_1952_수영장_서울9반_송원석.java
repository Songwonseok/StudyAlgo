package SW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D9_1952_수영장_서울9반_송원석 {
	static int min;
	static int[] fee, plan;
	public static void solve(int r,int total) {
		if(total > min)
			return;
		if(r>=12) {
			min = Math.min(min, total);
			return;
		}
		
		if(plan[r]*fee[0] > fee[1])
			solve(r+1,fee[1]+total);
		else {
			solve(r+1,plan[r]*fee[0]+total);
		}
		solve(r+3,fee[2]+total);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1952.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			fee = new int[3];
			plan = new int[12];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for(int i=0;i<3;i++)
				fee[i] = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken()); // 1년치는 최솟값
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<12;i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			solve(0,0);
			
			
			System.out.println("#"+tc+" "+min);
		}//tc
	
	
	}

}
