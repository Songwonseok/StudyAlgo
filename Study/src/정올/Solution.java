package 정올;

public class Solution {

	public static String solution(String s) {
		
		char[] word = s.toCharArray();
		boolean check = true;
		for(int i=0;i<word.length;i++) {
			char c1 = word[i];
			char c2 = word[word.length-i-1];
			
			if(c1 == c2 && c1=='?'&& c2=='?' ) {
				word[i] = 'a';
				word[word.length-i-1] = 'a';
			}else if(c1 != c2) {
				if(c1 == '?') {
					word[i] = c2;
				}else if(c2 =='?') {
					word[word.length-i-1] = c1;
				}else {
					check = false;
					break;
				}
			}
		}
		if(check) {
			String result = new String(word);
			return result;
		}
		return "NO";
		
	}
	public static void main(String[] args) {
		String result = "bab??a";
		
		System.out.println(solution(result));
	}

}
