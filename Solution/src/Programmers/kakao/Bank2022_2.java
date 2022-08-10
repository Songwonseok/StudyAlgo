package Programmers.kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Arrays;
public class Bank2022_2 {

	public void checkPrev(int index, int[] colors, List<Integer> removeList) {
		if(colors[index - 2] == 0) {
			return;
		}

		removeList.add(index);
		colors[index] = colors[index - 2] == 1 ? 2 : 1;
	}

	public void checkNext(int index, int[] colors, List<Integer> removeList) {
		if(colors[index + 2] == 0) {
			return;
		}

		removeList.add(index);
		colors[index] = colors[index + 2] == 1 ? 2 : 1;
	}

	public int[] solution(int[] black_caps) {
		int[] colors = new int[black_caps.length];

		for (int i = 0; i < black_caps.length; i++) {
			if (i == 0) {
				colors[i + 1] = black_caps[i] == 0 ? 2 : 1;
				continue;
			}

			if (i == black_caps.length - 1) {
				colors[i - 1] = black_caps[i] == 0 ? 2 : 1;
				continue;
			}

			if (black_caps[i] == 2) {
				colors[i - 1] = 1;
				colors[i + 1] = 1;
			}

			if (black_caps[i] == 0) {
				colors[i - 1] = 2;
				colors[i + 1] = 2;
			}
		}

		Set<Integer> indexSet = new HashSet<>();

		for (int i = 0; i < colors.length; i++) {
			if(colors[i] == 0) {
				indexSet.add(i);
			}
		}

		while (indexSet.size() > 0) {
			List<Integer> removeList = new ArrayList<>();

			for(int i : indexSet) {
				if (i == 0) {
					checkNext(i, colors, removeList);
					continue;
				}

				if(i == colors.length - 1) {
					checkPrev(i, colors, removeList);
					continue;
				}

				checkPrev(i, colors, removeList);

				if(colors[i] == 0) {
					checkNext(i, colors, removeList);
				}
			}

			if (removeList.size() == 0) {
				break;
			}

			indexSet.removeAll(removeList);
		}

		return colors;
	}

	public static void main(String[] args) {
		Bank2022_2 solution = new Bank2022_2();
		// int[] black_caps = {1, 1, 2, 0}; // [1, 1, 2, 1]
		int[] black_caps = {1, 1, 2, 1, 1, 1}; // [1, 1, 2, 1]
		// int[] black_caps = {1, 1, 1}; // [0, 1, 0]
		System.out.println(Arrays.toString(solution.solution(black_caps)));
	}

}
