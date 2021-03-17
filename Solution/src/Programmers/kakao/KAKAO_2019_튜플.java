package Programmers.kakao;

import java.util.*;
public class KAKAO_2019_튜플 {

	public static int[] solution(String s) {
		int[] answer = {};
		String line = s.substring(1, s.length() - 1);
		ArrayList<String> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '{') {
				sb = new StringBuilder();
			} else if (line.charAt(i) == '}') {
				list.add(sb.toString());
				i++;
			} else {
				sb.append(line.charAt(i));
			}
		}

		String[][] tuple = new String[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			tuple[i] = list.get(i).split(",");
		}

		// Arrays.sort(tuple, new Comparator<String[]> (){
		// 	public int compare(String[] o1, String[] o2){
		// 	return o1.length - o2.length;
		// }
		// });
		Arrays.sort(tuple, (a, b) -> a.length - b.length);
		
		answer = new int[tuple.length];
		int index = 0;
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < tuple.length; i++) {
			for (int j = 0; j < tuple[i].length; j++) {
				if (!set.contains(tuple[i][j])) {
					set.add(tuple[i][j]);
					answer[index++] = Integer.parseInt(tuple[i][j]);
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
