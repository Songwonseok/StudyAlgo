package Programmers.toss.test_240427;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4_240427 {
	public static int[][] solution(int servers, boolean sticky, int[] requests) {
		List<Integer>[] answerList = new List[servers];

		for(int i = 0; i< servers; i++) {
			answerList[i] = new ArrayList<>();
		}

		int currentServer = 0;

		Map<Integer, Integer> stickyMap = new HashMap<>();

		for(int request: requests) {
			if(sticky) {
				if(stickyMap.containsKey(request)) {
					answerList[stickyMap.get(request)].add(request);
					continue;
				}else {
					stickyMap.put(request, currentServer);
				}
			}

			answerList[currentServer++].add(request);

			if(currentServer == servers) {
				currentServer = 0;
			}

		}

		int[][] answer = new int[servers][];

		for (int i = 0; i < answerList.length; i++) {
			List<Integer> list = answerList[i];
			answer[i] = list.stream().mapToInt(v -> v).toArray();
		}


		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, true, new int[] {1,2,2,3,4,1}));
	}


}
