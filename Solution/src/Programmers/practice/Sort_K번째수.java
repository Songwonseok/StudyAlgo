package Programmers.practice;

import java.util.Arrays;

public class Sort_K번째수 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
        	int start = commands[i][0] -1;
        	int end = commands[i][1] -1;
        	
        	int[] sorted = new int[end-start+1];
        	
        	for(int j=0;j<=end-start;j++) {
        		sorted[j] = array[j+start];
        	}
        	
        	Arrays.sort(sorted);
        	answer[i] = sorted[commands[i][2]-1];
        }
        
        
        return answer;
    }
	

	public static void main(String[] args) {
		
		
	}

}
