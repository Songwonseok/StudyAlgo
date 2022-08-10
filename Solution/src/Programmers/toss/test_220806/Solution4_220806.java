package Programmers.toss.test_220806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution4_220806 {
	public long getScore(int depth, long currHost, HashMap<Long, HashSet> map) {
		if(depth == 2) {
			HashSet guests = map.getOrDefault(currHost, new HashSet());
			return (long)guests.size();
		}

		HashSet<Long> hosts = map.getOrDefault(currHost, new HashSet());

		long sum = hosts.size() * 10;

		for(Long nextHost : hosts) {
			HashSet set = map.getOrDefault(nextHost, new HashSet());

			if(set.size() == 0) {
				continue;
			}

			sum += set.size() * 3;
			sum += getScore(depth + 1, nextHost, map);
		}

		return sum;
	}

	public long[] solution(long[][] invitationPairs) {
		HashMap<Long, HashSet> map = new HashMap<>();


		for(int i = 0; i < invitationPairs.length; i++) {
			long host = invitationPairs[i][0];
			long guest = invitationPairs[i][1];

			HashSet<Long> set = map.getOrDefault(host, new HashSet());
			set.add(guest);

			map.put(host, set);
		}

		HashSet<Long> visit = new HashSet<>();
		List<long[]> scoreList = new ArrayList<>();
		int order = 0;

		for(int i = 0; i < invitationPairs.length; i++) {
			long host = invitationPairs[i][0];

			if(visit.contains(host)) {
				continue;
			}

			visit.add(host);

			long score = getScore(1, host, map);
			scoreList.add(new long[] {order, host, score});
		}

		Collections.sort(scoreList, (o1, o2) -> {
			if(o1[2] == o2[2]) {
				return Long.compare(o1[0], o2[0]);
			}

			return -Long.compare(o1[2], o2[2]);
		});

		List<Long> hostList = new ArrayList<>();

		for(int i = 0; i < 3 && i < scoreList.size(); i++) {
			hostList.add(scoreList.get(i)[1]);
		}

		long[] answer = new long[hostList.size()];

		for(int i = 0; i < answer.length; i++) {
			answer[i] = hostList.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution4_220806 solve = new Solution4_220806();

		System.out.println(Arrays.toString(solve.solution(new long[][] {{1, 2}, {1, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 6}})));

	}
}
