package Metanet;

public class Solution2 {

	public class Solution {
	    public int solution(int N, int[] sequence) {
	        int answer = 0;
	        int curr = 1;
	        
	        for(int i=0;i<sequence.length;i++) {
	        	int next = sequence[i];
	        	int distance = Math.abs(curr-next);
	        	
	        	if(distance > N/2) 
	        		answer += N-distance;
	        	else
	        		answer += distance;
	        	curr = next;
	        }
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
