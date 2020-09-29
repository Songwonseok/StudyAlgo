package Steet_11;

/*
 * 문자열을 abc -> aabaacaa
 * a가 연속으로 3개 있으면 -1
 */
public class Solution1 {
	public static int solution(String S) {
        String result = "";
		if(S.contains("aaa"))
			return -1;
		
		int length = S.length();
		
		for(int i=0;i<S.length();i++) {
			String curr = S.substring(i, i+1);
			if(curr.equals("a")) {
				if(i+1 < length && S.substring(i+1, i+2).equals("a"))
					i++;
				
				result += "aa";
			}else {
				if(i == 0) 
					result += "aa";
				
				if(i+1 < length && S.substring(i+1, i+2).equals("a")) {
					result += curr;
				}else 
					result += curr +"aa";
			}
		}
		
		return result.length() - S.length();
    }
	public static void main(String[] args) {
		
		
		String b = "baaaa";
		
		System.out.println(solution(b));

	}

}
