package Programmers.webtoon;

public class Solution3 {
	public int solution(String s, String t) {
		int result = 0;
		String reg = "(.*)" + t + "(.*)";

		while (s.matches(reg)) {
			result++;
			s = s.replace(t, "");
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "aaabbb";
		String t = "ab";
		String reg = "(.*)" + t + "(.*)";

		int count = 0;
		System.out.println(s.matches(reg));

		s = s.replace(t, "");
		System.out.println(s);
	}
}
