package Programmers.practice;

public class Greedy_조이스틱 {
	static char[] alpha = { 'A','B','C','D','E',
            'F','G','H','I','J',
            'K','L','M','N','O',
            'P','Q','R','S','T',
            'U','V','W','X','Y','Z'};
	static boolean[] v;
	static int idx;
	
	public static int[] greedy(String name){
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		
		for(int i=0;i<name.length();i++){
			if(!v[i]){
			    if(i == 0){
			        return new int[] {0, 0};
			    }
			    
			    int move = Math.abs(idx-i);
			    move = (move <= name.length()/2)?  move : name.length() - move;
			    
			    if(move < min){
			        min = move;
			        minIdx = i;
			    }
			    
			}
		}
		return new int[] {minIdx, min};
	
	}
	public static int solution(String name) {
        int answer = 0;
        int changeCnt = 0;
        idx = 0;
        
        v = new boolean[name.length()];
        for(int i=0;i<name.length();i++)
            if(name.charAt(i) == 'A') {
                v[i] = true;
                changeCnt++;
            }
        
        while(changeCnt < name.length()){
            int[] next = greedy(name);
            
            int cnt = (name.charAt(next[0]) - 'A');
            cnt = (cnt >= 13)? 26- cnt: cnt;
            answer += cnt + next[1];
            
            v[next[0]] = true;
            
            changeCnt++;
            idx = next[0];
        }      
        return answer;
    }
	public static void main(String[] args) {
		String name = "JAZ";
		System.out.println(solution(name));
	}

}
