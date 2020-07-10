package Programmers.practice;

import java.util.LinkedList;
import java.util.Queue;

public class DFS_네트워크 {
	public void DFS(int start,int[][] computers, boolean[] v){
        v[start] = true;
        for(int i=0;i<computers[start].length;i++){
            if(computers[start][i] == 1 && !v[i]){
                DFS(i,computers,v);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        for(int i=0;i<computers.length;i++){
            if(!v[i]){
                DFS(i,computers,v);
                answer++;
            }
        }
        
        return answer;
    }
    
	public static void main(String[] args) {

		Queue<int[]> a = new LinkedList<>();
		
	}

}
