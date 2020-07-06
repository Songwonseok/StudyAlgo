package Programmers.practice;

import java.util.Arrays;

public class Sort_K번째수_copyOfRange {
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
        	
        	int[] sorted = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
        	
        	Arrays.sort(sorted);
        	answer[i] = sorted[commands[i][2]-1];
        }
        
        return answer;
    }
	

	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] c = {{2,5,3},{4,4,1},{1,7,3}};
		
		System.out.println(Arrays.toString(solution(arr,c)));
		
	}

}
