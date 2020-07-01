package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산2 {
	static int r, c, k, R, C;

	public static int[][] rOper(int[][] ar) {
		int[][] temp = new int[ar.length][];
		int max = 0;
		ArrayList<int[]>[] list = new ArrayList[temp.length];
		for (int i = 0; i < temp.length; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> indexs = new ArrayList<>();
			for (int j = 0; j < ar[i].length; j++) {
				list[i] = new ArrayList<>();
				if (!map.containsKey(ar[i][j])) {
					map.put(ar[i][j], 1);
					indexs.add(ar[i][j]);
				} else {
					map.put(ar[i][j], map.get(ar[i][j]) + 1);
				}
			}

			for (int j = 0; j < indexs.size(); j++) {
				list[i].add(new int[] { indexs.get(j), map.get(indexs.get(j)) });
			}
			Collections.sort(list[i], new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});
			max = Math.max(max, list[i].size() * 2);
		}
		for (int i = 0; i < ar.length; i++) {
			temp[i] = new int[max];
			for (int j = 0; j < list[i].size(); j++) {
				temp[i][j*2] = list[i].get(j)[0];
				temp[i][j*2+1] = list[i].get(j)[1];
			}
		}
		
		return temp;
	}
	public static int[][] cOper(int[][] ar) {
		int max = 0;
		ArrayList<int[]>[] list = new ArrayList[ar[0].length];
		for (int i = 0; i < ar[0].length; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> indexs = new ArrayList<>();
			for (int j = 0; j < ar.length; j++) {
				list[i] = new ArrayList<>();
				if (!map.containsKey(ar[j][i])) {
					map.put(ar[j][i], 1);
					indexs.add(ar[j][i]);
				} else {
					map.put(ar[j][i], map.get(ar[j][i]) + 1);
				}
			}

			for (int j = 0; j < indexs.size(); j++) {
				list[i].add(new int[] { indexs.get(j), map.get(indexs.get(j)) });
			}
			Collections.sort(list[i], new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return Integer.compare(o1[0], o2[0]);
					}
					return Integer.compare(o1[1], o2[1]);
				}
			});
			max = Math.max(max, list[i].size() * 2);
		}
		int[][] temp = new int[max][ar[0].length];
		
		for (int i = 0; i < temp[0].length; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				temp[j*2][i] = list[i].get(j)[0];
				temp[j*2+1][i] = list[i].get(j)[1];
			}
		}
		
		return temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());

		int[][] ar = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		R = ar.length;
		C = ar[0].length;
		int time = 0;
		int result = -1;
		while (time <= 100) {
			if (ar[r][c] == k) {
				result = time;
				break;
			}
			if (R >= C) {
				ar = rOper(ar);
				C = ar[0].length;
			} else {
				ar = cOper(ar);
				R = ar.length;
			}
			time++;
		}

		System.out.println(result);

	}

}