package baek;

import java.io.*;
import java.util.*;

public class Main_1516_게임개발_02 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N+1];
		ArrayList<Integer>[] nextList = new ArrayList[N+1];
		int[] memo = new int[N+1];
		int[] in = new int[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++)
			nextList[i] = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			String[] str = br.readLine().split(" ");
			time[i] = Integer.parseInt(str[0]);
			
			for(int idx=1;idx<str.length-1; idx++) {
				int from = Integer.parseInt(str[idx]);
				nextList[from].add(i);
				in[i]++;
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(in[i] == 0) {
				queue.add(i);
				memo[i] = time[i];
			}
		}
		
		while(!queue.isEmpty()) {
			
			int from = queue.poll();
			
			for(int to : nextList[from]) {
				memo[to] = Math.max(memo[to], time[to] + memo[from]);
				in[to]--;
				if(in[to] == 0)
					queue.add(to);
			}
		}
		
		for(int i=1;i<=N;i++)
			System.out.println(memo[i]);
	}

}
