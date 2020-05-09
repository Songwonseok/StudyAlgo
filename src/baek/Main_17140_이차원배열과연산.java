package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	static int r, c, k, R, C;

	public static int[][] rOper(int[][] ar) {
		int[][] temp = new int[100][100];
		int max = 0;
		for (int i = 0; i < R; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> indexs = new ArrayList<>();
			ArrayList<int[]> list = new ArrayList<>();
			for (int j = 0; j < C; j++) {
				if (ar[i][j] != 0) {
					if (!map.containsKey(ar[i][j])) {
						map.put(ar[i][j], 1);
						indexs.add(ar[i][j]);
					} else {
						map.put(ar[i][j], map.get(ar[i][j]) + 1);
					}
				}
			}
			for (int j = 0; j < indexs.size(); j++) {
				list.add(new int[] { indexs.get(j), map.get(indexs.get(j)) });
			}
			max = Math.max(max, list.size() * 2);
			Collections.sort(list, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				temp[i][j * 2] = list.get(j)[0];
				temp[i][j * 2 + 1] = list.get(j)[1];
			}
		}
		C = max;
		return temp;
	}

	public static int[][] cOper(int[][] ar) {
		int[][] temp = new int[100][100];
		int max = 0;
		for (int i = 0; i < C; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> indexs = new ArrayList<>();
			ArrayList<int[]> list = new ArrayList<>();
			for (int j = 0; j < R; j++) {
				if (ar[j][i] != 0) {
					if (!map.containsKey(ar[j][i])) {
						map.put(ar[j][i], 1);
						indexs.add(ar[j][i]);
					} else {
						map.put(ar[j][i], map.get(ar[j][i]) + 1);
					}
				}
			}
			for (int j = 0; j < indexs.size(); j++) {
				list.add(new int[] { indexs.get(j), map.get(indexs.get(j)) });
			}
			max = Math.max(max, list.size() * 2);
			Collections.sort(list, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				temp[j * 2][i] = list.get(j)[0];
				temp[j * 2 + 1][i] = list.get(j)[1];
			}
		}
		R = max;
		return temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());

		int[][] ar = new int[100][100];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		R = 3;
		C = 3;
		int time = 0;
		int result = -1;
		while (time <= 100) {
			if (ar[r][c] == k) {
				result = time;
				break;
			}
			if (R >= C) {
				ar = rOper(ar);
			} else {
				ar = cOper(ar);
			}
			time++;
		}

		System.out.println(result);

	}

}