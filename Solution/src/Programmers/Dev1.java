package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Dev1 {

	public String solution(String[] registered_list, String new_id) {
		Set<String> set = new HashSet<>();

		for(String id : registered_list) {
			set.add(id);
		}

		String answer = new_id;

		while(set.contains(answer)) {
			int numberIndex = getStartNumberIndex(answer);

			String S = answer.substring(0, numberIndex);
			int N;

			if(numberIndex == answer.length()) {
				N = 0;
			}else {
				N = Integer.parseInt(answer.substring(numberIndex));
			}

			answer = S + (N + 1);

		}
		return answer;

	}

	public int getStartNumberIndex(String id) {
		for(int i = 0; i < id.length(); i++) {
			char curr = id.charAt(i);
			if(curr < 'a' || curr > 'z') {
				return i;
			}
		}

		return id.length();
	}

	public static void main(String[] args) {
		String[] re = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
		String new_id = "cow";

		Dev1 s = new Dev1();

		String answer = s.solution(re, new_id);

		System.out.println(answer);
	}
}
