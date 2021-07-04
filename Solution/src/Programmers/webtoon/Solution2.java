package Programmers.webtoon;

import java.util.ArrayList;

public class Solution2 {
	public boolean compareList(ArrayList<Character> left, ArrayList<Character> right) {
		int size = left.size() - 1;

		for (int i = 0; i <= size; i++) {
			if (left.get(i) != right.get(size - i)) {
				return false;
			}
		}

		return true;
	}

	public String toStringByList(ArrayList<Character> list, boolean isReverse) {
		StringBuilder sb = new StringBuilder();

		if (!isReverse) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}
		} else {
			for (int i = list.size() - 1; i >= 0; i--) {
				sb.append(list.get(i));
			}
		}

		return sb.toString();
	}

	public String[] solution(String s) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<>();

		int left = 0;
		int right = s.length() - 1;

		ArrayList<Character> leftWord = new ArrayList<>();
		ArrayList<Character> rightWord = new ArrayList<>();

		char startChar = '0';

		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);

			if (leftWord.size() == 0) {
				startChar = leftChar;
			}

			leftWord.add(leftChar);
			rightWord.add(rightChar);

			if (startChar == rightChar && compareList(leftWord, rightWord)) {
				String word = toStringByList(leftWord, false);
				list.add(word);

				leftWord.clear();
				rightWord.clear();
			}
			left++;
			right--;

			if (left >= right) {
				StringBuilder sb = new StringBuilder();

				if (left == right) {
					int answerSize = list.size() * 2 + 1;
					answer = new String[answerSize];

					if (leftWord.size() > 0) {
						sb.append(toStringByList(leftWord, false))
							.append(s.charAt(left))
							.append(toStringByList(rightWord, true));
					} else {
						sb.append(s.charAt(left));
					}
					answer[answerSize / 2] = sb.toString();

				} else {
					if (leftWord.size() > 0) {
						int answerSize = list.size() * 2 + 1;
						answer = new String[answerSize];

						sb.append(toStringByList(leftWord, false))
							.append(toStringByList(rightWord, true));

						answer[answerSize / 2] = sb.toString();
					} else {
						int answerSize = list.size() * 2;
						answer = new String[answerSize];
					}
				}

			}
		}

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			answer[answer.length - 1 - i] = list.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		String a = "abcxyasdfasdfxyabc";

		Solution2 s = new Solution2();

		String[] answer = s.solution(a);

		for (String str : answer) {
			System.out.println(str);
		}
	}
}
