package baek;

import java.io.*;
import java.util.*;

public class Main_2617_구슬찾기 {
	static int[] heavy, light;
	static boolean[] visit;
	static int N;
	static Marble[] marbles;
	
	static class Marble {
		int num;
		ArrayList<Integer> heavy;
		ArrayList<Integer> light;
		public Marble(int num) {
			this.num = num;
			this.heavy = new ArrayList<>();
			this.light = new ArrayList<>();
		}
	}
	
	public static void getHeavy(int idx) {
		visit[idx] = true;
		if(marbles[idx].heavy.size() == 0) {
			return;
		}
		int cnt = 0;
		for(int i=0;i<marbles[idx].heavy.size();i++) {
			int num = marbles[idx].heavy.get(i);
			if(!visit[num]) getHeavy(num);
		}
		return;
	}
	
	public static void getLight(int idx) {
		visit[idx] = true;
		if(marbles[idx].light.size() == 0) {
			return;
		}
		for(int i=0;i<marbles[idx].light.size();i++) {
			int num = marbles[idx].light.get(i);
			
			if(!visit[num]) getLight(num);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		marbles = new Marble[N+1];
		heavy = new int[N+1];
		light = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			marbles[i] = new Marble(i);
		}
					
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());
			
			marbles[heavy].light.add(light);
			marbles[light].heavy.add(heavy);
		}
		int result = 0;
		for(int i=1; i<=N;i++) {
			visit = new boolean[N+1];
			getHeavy(i);
			int heavyCnt = -1;
			for(boolean flag : visit) {
				if(flag) heavyCnt++;
			}
			if(heavyCnt > N/2) {
				result++;
				continue;
			}
			
			visit = new boolean[N+1];
			getLight(i);
			int lightCnt = -1;
			for(boolean flag : visit) {
				if(flag) lightCnt++;
			}
			
			if(lightCnt > N/2) {
				result++;
			}
		}
		System.out.println(result);
	}
}
