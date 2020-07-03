package Programmers.Metanet;

public class Solution3 {
	static int min;
	static boolean[] v;
	
	public static void dfs(int start, int[] lines, int[] dots, int count) {
		if(count >= min) {
			return;
		}else if(start > dots[dots.length-1] ) {
			min = Math.min(min, count);
			return;
		}
		
		for(int i=0;i<dots.length;i++) {
			if(start <= dots[i]) {
				start = dots[i];
				break;
			}
		}
		
		for(int i=0;i<lines.length;i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(start+lines[i]+1,lines, dots, count+1);
				v[i] = false;
			}
		}
		
		
	}
	
	public static int solution(int[] dots, int[] lines) {
		min = 11;
		v= new boolean[lines.length];
        int answer = 0;
        
        dfs(dots[0],lines,dots,0);
        
        if(min == 11)
        	answer = -1;
        else
        	answer = min;
        
        return answer;
    }

	public static void main(String[] args) {
		
		int[] dots = {1};
		int[] lines = {1};
		System.out.println(solution(dots,lines));
		
	}

}
