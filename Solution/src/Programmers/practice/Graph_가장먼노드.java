package Programmers.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_가장먼노드 {

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++)
            list[i] = new ArrayList<Integer>();
        
        for(int i=0;i<edge.length;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        
        queue.add(new int[]{1,0});
        visit[1] = true;
        int max = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[1] > max){
                max = curr[1];
                answer=1;
            }else if(curr[1] == max){
                answer++;
            }
            
            for(int i=0;i<list[curr[0]].size();i++){
                int next = list[curr[0]].get(i);
                if(!visit[next]){
                    queue.add(new int[] {next, curr[1] +1});
                    visit[next] = true;
                }
            }
        }
        
        return answer;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] a = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n,a));
	}

}
