package Programmers;
import java.util.*;

public class Solution3 {
	int[] emoticons;
	int[][] users;
	int[] answer;
	int[] rates = {10, 20, 30, 40};
	int minRate;

	public int[] solution(int[][] users, int[] emoticons) {
		Arrays.sort(users, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		this.emoticons = emoticons;
		this.users = users;
		minRate = users[0][0];
		answer = new int[2];
		int[][] acc = new int[emoticons.length][2];

		dfs(0, acc);

		return answer;
	}

	public void dfs(int depth, int[][] acc) {
		if(depth == emoticons.length) {
			int members = 0;
			int total = 0;

			cal:		for(int[] user : users) {
				int sum = 0;

				for(int[] saleInfo : acc) {
					if(saleInfo[0] >= user[0]) {
						sum += saleInfo[1];
					}

					if(sum >= user[1]) {
						members++;
						continue cal;
					}
				}

				total += sum;
			}

			if(answer[0] < members) {
				answer[0] = members;
				answer[1] = total;
				return;
			}else if(answer[0] == members) {
				answer[1] = Math.max(answer[1], total);
			}

			return;
		}

		for(int rate : rates) {
			if(rate < minRate) {
				continue;
			}

			acc[depth][0] = rate;
			acc[depth][1] = (100 - rate) * emoticons[depth] / 100;

			dfs(depth + 1, acc);
		}

	}
	public static void main(String[] args) {
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emo = {7000, 9000};

		Solution2 s = new Solution2();

		// System.out.println(s.solution(users,emo));

	}

}
