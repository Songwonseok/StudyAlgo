package 정올;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution2 {
	
	static int result;
	
	
	public static void solve(ArrayList<String> list,String s, int n,int r){
		if(r==n) {
			HashSet<Character> set = new HashSet<>();
			for(int j=0;j<s.length();j++){
				set.add(s.charAt(j));
			}
			if(s.length() > set.size())
				return;
			
			if(s.length()>result)
				result = s.length();
			return;
		}
		solve(list,s+list.get(n),n+1,r);
		solve(list,s,n+1,r);
	}
	
	public static int solution(String[] A) {
		ArrayList<String> list = new ArrayList<>();
		result =0;
		for(int i=0;i<A.length;i++) {
			HashSet<Character> set = new HashSet<>();
			for(int j=0;j<A[i].length();j++){
				set.add(A[i].charAt(j));
			}
			if(A[i].length() > set.size())
				continue;
			list.add(A[i]);
		}
		solve(list,"",0,list.size());
		return result;
	}
	
	public static void main(String[] args) {
		
		
	}

}
