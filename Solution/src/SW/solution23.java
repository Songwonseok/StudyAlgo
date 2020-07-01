package SW;

import java.util.Arrays;

public class solution23 {
	 public static int[] solution(int brown, int red) {
	        int[] answer = new int[2];
	        int total = brown+red;
	        int garo = 3;
	check:      while(true) {
	        	
	        	for(int i=3;i<=garo;i++) {
	        		if(total  == garo*i) {
	        			answer[0] = garo;
	        			answer[1] = i;
	        			break check;
	        		}
	        	}
	        	garo++;
	        }
	        
	        return answer;
	    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12,3)));
	}

}
