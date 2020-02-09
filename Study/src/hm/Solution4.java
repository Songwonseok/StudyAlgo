package hm;

import java.util.HashSet;

public class Solution4 {
	static int[] start = {1,6};
	static char[][] key = {{'Q','W','E','R','T','Y','U','I','O','P'},
			{'A','S','D','F','G','H','J','K','L','0'},
			{'Z','X','C','V','B','N','M','0','0'}};
	static HashSet<String> set = new HashSet<>();
	static long result=0;
	
	public static void dfs(int x,int y,int T,String word) {
		if(T==0) {
			if(x == start[0] && y == start[1]) {
				result++;
			}
			return;
		}
		if((Math.abs((x-start[0])+(y-start[1]))%2 == 0 && T%2==1))
				return;
		
		
		set.add(word);
		int[] di = {-1,1,0,0,}, dj= {0,0,-1,1};
		
		for(int dir=0;dir<4;dir++) {
			int ni = x+di[dir];
			int nj = y+dj[dir];
			
			if(ni >=0 && ni<3 && nj >= 0 && nj<10 && key[ni][nj] != '0' 
					&& !(Math.abs((ni-start[0])+(nj-start[1]))>T-1) && !set.contains(word+key[ni][nj])) {
				String nword = word + key[ni][nj];
				dfs(ni,nj,T-1,nword);
			}
		}
		
		
	}
	
	public static int solution(int T) {
		if(T%2 == 1)
			return 0;
		
		dfs(start[0],start[1],T,"J");
        return (int) (result%1000000007);
    }

	public static void main(String[] args) {
		System.out.println(solution(14));
		
	}

}
