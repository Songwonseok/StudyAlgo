package Multicampus;

public class Solution6 {
	static int result;
	static char[] start = {'a','e','i','o','u'};
	// 문자열 길이 n을 줌
	// {a,e,i,o,u}
	// 1) a 다음엔 e
	// 2) e 다음엔 i or a
	// 3) i 다음에 not i
	// 4) o 다음에 i or u
	// 5) u 다음에 a
	// 길이가 n인 만들수 있는 문자열의 개수를 return (값이 크니까 1000000007 로 modulo 연산하여 리턴) 
	public static void dfs(int n, int depth, char c) {
		if(n == depth) {
			result = (result+1)%1000000007;
			return;
		}
		switch(c){
			case 'a':
				dfs(n, depth+1, 'e');
				break;
			case 'e':
				dfs(n, depth+1, 'a');
				dfs(n, depth+1, 'i');
				break;
			case 'i':
				for(int i=0;i<start.length;i++)
					if(start[i] != 'i') dfs(n, depth+1, start[i]);
				break;
			case 'o':
				dfs(n, depth+1, 'i');
				dfs(n, depth+1, 'u');
				break;
			case 'u':
				dfs(n, depth+1, 'a');
				break;
				
		}
	}

	public static int countPerms(int n) {
	    // Write your code here
		result = 0;
		
		
		for(int i=0;i<start.length;i++)
			dfs(n, 1, start[i]);
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPerms(50));

	}

}
