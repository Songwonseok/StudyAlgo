package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17215_볼링점수계산 {

	public static int getScore(char curr, char prev) {
		if (curr == 'S') {
			return 10;
		} else if (curr == 'P') {
			return 10 - (prev - '0');
		}
		return curr - '0';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String bowlingScore = br.readLine().replaceAll("-", "0");

		int[] frameInfo = {1, 0}; // Frame,누적 횟수
		int sum = 0;

		Queue<Integer> strikeQueue = new LinkedList<>();
		char prev = '0';

		for (int i = 0, size = bowlingScore.length(); i < size; i++) {
			char curr = bowlingScore.charAt(i);

			int score = getScore(curr, prev);

			if (prev == 'P') {
				sum += score;
			}

			for (int j = 0, queueSize = strikeQueue.size(); j < queueSize; j++) {
				int count = strikeQueue.poll();
				sum += score;

				if (count == 0) {
					strikeQueue.offer(count + 1);
				}
			}

			if (frameInfo[0] <= 10) {
				sum += score;
				if (curr == 'S') {
					strikeQueue.offer(0);
				}
			}

			if (curr == 'S' || curr == 'P' || frameInfo[1] == 1) {
				frameInfo[0]++;
				frameInfo[1] = 0;
			} else {
				frameInfo[1]++;
			}

			prev = curr;
		}

		System.out.println(sum);
	}

}
