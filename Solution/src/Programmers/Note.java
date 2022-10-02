package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Note {
	public int[] solution(int[] answers) {
		int[][] mathGivers = {
			{1,2,3,4,5},
			{2,1,2,2,2,3,2,4,2,5},
			{3,3,1,1,2,2,4,4,5,5}
		};

		int[] scores = new int[3];

		for(int i = 0; i < answers.length; i++) {
			int answer = answers[i];

			for(int j = 0; j < 3; j++) {
				if(answer == mathGivers[j][i % mathGivers[j].length]) {
					scores[j]++;
				}
			}
		}

		int max = Arrays.stream(scores).max().getAsInt();

		List<Integer> highest = new ArrayList<>();

		for(int i = 0; i < 3; i++) {
			if(scores[i] == max) {
				highest.add(i + 1);
			}
		}

		return highest.stream().mapToInt(Integer::intValue).toArray();
	}
}
