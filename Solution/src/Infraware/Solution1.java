package Infraware;

import java.util.HashSet;

public class Solution1 {
	static int max;

	public static int solution(String s) {
		int answer = 0;
		HashSet<String> set = new HashSet();
		loop: for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s.substring(i, i + 1));
			set.add(sb.toString());

			for (int j = i + 1; j < s.length(); j++) {
				String sub = s.substring(j, j + 1);
				if (sb.toString().contains(sub)) {
					continue loop;
				} else {
					sb.append(sub);
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
