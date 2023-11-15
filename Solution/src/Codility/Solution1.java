package Codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {
	public static int solution(int[] T) {
		Set<Integer> set = new HashSet(Arrays.stream(T).boxed().collect(Collectors.toList()));
		int N = T.length;

		if(set.size() >= N / 2) {
			return N / 2;
		}

		return set.size();
	}

	public static void main(String[] args) {
		int[] T = {3, 4, 7, 7, 6, 6};

		System.out.println(solution(T));
	}
}
