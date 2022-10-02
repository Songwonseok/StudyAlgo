package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dev3 {
	char[][] world;
	boolean[][] visit;
	int h, w;
	int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public int solution(String[] maps) {
		h = maps.length;
		w = maps[0].length();

		world = new char[h][];
		visit = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			world[i] = maps[i].toCharArray();
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!visit[i][j] && world[i][j] != '.') {
					visit[i][j] = true;
					war(i,j);
				}
			}
		}

		List<Character> winners = getWinners(visit);
		char winner = winners.get(0);
		int answer = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (world[i][j] == winner) {
					answer++;
				}
			}
		}

		return answer;
	}

	public void war(int x, int y) {
		boolean[][] range = getRange(x,y);
		List<Character> winners = getWinners(range);
		drawMap(winners.get(0), range, winners);
	}

	public boolean[][] getRange(int x, int y) {
		boolean[][] range = new boolean[h][w];
		Queue<Integer> queue = new LinkedList<>();
		range[x][y] = true;
		queue.add(x * w + y);

		while(!queue.isEmpty()) {
			int cx = queue.peek() / w;
			int cy = queue.poll() % w;

			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if(nx < 0 || nx >= h || ny < 0 || ny >= w || range[nx][ny] || world[nx][ny] == '.') {
					continue;
				}

				range[nx][ny] = true;
				visit[nx][ny] = true;
				queue.add(nx * w + ny);
			}
		}

		return range;
	}

	public List<Character> getWinners(boolean[][] range) {
		HashMap<Character, Integer> infoMap = new HashMap<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (range[i][j]) {
					infoMap.put(world[i][j], infoMap.getOrDefault(world[i][j], 0) + 1);
				}
			}
		}

		int max = 0;

		for(char key : infoMap.keySet()) {
			max = Math.max(infoMap.get(key), max);
		}
		List<Character> winners = new ArrayList<>();

		for(char key : infoMap.keySet()) {
			if(infoMap.get(key) == max) {
				winners.add(key);
			}
		}

		Collections.sort(winners, Collections.reverseOrder());

		return winners;
	}

	public void drawMap(char winner, boolean[][] range, List<Character> winners) {
		HashSet set = new HashSet(winners);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (range[i][j] && !set.contains(world[i][j])) {
					world[i][j] = winner;
				}
			}
		}
	}

}
