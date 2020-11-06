package baek;

import java.io.*;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] node = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++)
			node[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			node[from].add(to);
		}
		
		boolean[] visit = new boolean[N+1];
		
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {X,0});
		visit[X] = true;
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[1]>K) 
				break;
			
			if(curr[1] == K)
				answer.add(curr[0]);
			
			for(int i=0;i<node[curr[0]].size();i++) {
				int next = node[curr[0]].get(i);
				if(!visit[next]) {
					visit[next] = true;
					queue.add(new int[] {next, curr[1]+1});
				}
			}
		}
		if(answer.size()==0)
			System.out.println(-1);
		else {
			Collections.sort(answer);
			for(int a : answer)
				System.out.println(a);
		}
	}

}
