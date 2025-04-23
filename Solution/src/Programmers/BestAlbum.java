package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAlbum {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, List<int[]>> map = new HashMap();
		HashMap<String, Integer> sumMap = new HashMap();

		for(int i = 0; i< genres.length; i++) {
			if(!map.containsKey(genres[i])) {
				map.put(genres[i], new ArrayList<>());
			}

			map.get(genres[i]).add(new int[] {i, plays[i]});
			sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<Map.Entry<String, Integer>> entryList  = sumMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toList());

		List<Integer> answer = new ArrayList<>();

		for(int i = 0; i < entryList.size(); i++ ){
			List<int[]> list = map.get(entryList.get(i).getKey());

			Collections.sort(list, (v1, v2) -> {
				if(v1[1] == v2[1]) {
					return Integer.compare(v1[0], v2[0]);
				}

				return Integer.compare(v1[1], v2[1]);
			} );

			for(int j = 0; j < list.size() && j < 2; j++) {
				answer.add(list.get(j)[0]);
			}

		}

		return answer.stream().mapToInt(v-> v).toArray();
	}
	public static void main(String[] args) {

	}
}
