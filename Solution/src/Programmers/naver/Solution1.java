package Programmers.naver;

public class Solution1 {
	public static void main(String[] args) {
		String a = "acbbcdc";
		
		String b = "abc";
		char[] c = a.toCharArray();
		int idx =0;
		for(int i=0;i<c.length;i++) {
			if(c[i] == b.charAt(idx)) {
				c[i] = '\u0000';
				idx++;
				if(idx == b.length())
					break;
			}
		}
		
		
		String answer = new String(c);
		System.out.println(answer);
	}

}
