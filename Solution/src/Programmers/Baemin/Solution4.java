package Programmers.Baemin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution4 {
	public String[] solution(int maxSize, String[] actions) {
		List<String> answer = new ArrayList<>();
		Stack<String> back = new Stack<>();
		Stack<String> forward = new Stack<>();
		Stack<String> history = new Stack<>();

		HashSet<String> set = new HashSet<>();

		String curr = null;

		for (String action: actions) {
			switch (action) {
				case "B" : {
					if(back.isEmpty() || curr == null) {
						continue;
					}

					forward.push(curr);
					history.push(curr);
					curr = back.pop();
					continue;
				}
				case "F" : {
					if(forward.isEmpty() || curr == null) {
						continue;
					}

					back.push(curr);
					history.push(curr);
					curr = forward.pop();
					continue;
				}

				default: {
					if(curr != null) {
						back.push(curr);
					}

					curr = action;
					history.push(curr);
					forward.clear();
				}
			}
		}

		while(!history.isEmpty() && answer.size() < maxSize) {

			String str = history.pop();

			if(set.contains(str)) {
				continue;
			}

			answer.add(str);
			set.add(str);
		}



		return answer.toArray(new String[answer.size()]);
	}

	public static void main(String[] args) {
		Solution4 s4 = new Solution4();

		System.out.println(s4.solution(3, new String[] {"1", "3", "2", "B", "4", "F"}));

	}
}
