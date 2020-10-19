package baek;

import java.io.*;
import java.util.*;

public class Main_1516_게임개발_DP {
	static int[] memo;
	static Building[] buildings;
	static int N;
	
	static class Building {
		int time;
		ArrayList<Integer> prev;
		public Building(int time) {
			this.time = time;
			this.prev = new ArrayList<>();
		}
	}
	
	public static int build(int idx) {
		if(buildings[idx].prev.size() ==0) {
			return memo[idx] = buildings[idx].time;
		}
		
		int max = 0;
		for(int num : buildings[idx].prev) {
			if(memo[num] == 0) build(num);
			max = Math.max(max, (memo[num] == 0)? build(num): memo[num]);
		}
		return memo[idx] = max + buildings[idx].time;
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		buildings = new Building[N+1];
		memo = new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			String[] str = br.readLine().split(" ");
			buildings[i] = new Building(Integer.parseInt(str[0]));
			
			for(int idx=1;idx<str.length-1; idx++) {
				buildings[i].prev.add(Integer.parseInt(str[idx]));
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(memo[i] == 0) {
				build(i);
			}
			System.out.println(memo[i]);
		}
	}

}
