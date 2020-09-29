package Steet_11;

/*
 * ["abc", "bbc", "vvc"] 같은 스트링배열에서 
 * 같은 자리에 같은 글자가 있는 쌍을 찾아서 [인덱스1, 인덱스2, 자리 인덱스] 아무거나리턴, 
 * 없으면 {}리턴
 * 위 예제는 [0,1,1] or [1,0,1] or [1,2,2] or [2,1,2] 가능
 */


import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
	public static int[] solution(String[] S) {
		for(int i=0;i<S[0].length();i++) {
			HashMap<Character, Integer> map= new HashMap<>();
			for(int j=0;j<S.length;j++) {
				if(map.containsKey(S[j].charAt(i))) {
					int[] result = new int[3];
					result[0] = map.get(S[j].charAt(i));
					result[1] = j;
					result[2] = i;
					return result;
				}else {
					map.put(S[j].charAt(i), j);
				}
			}
		}
		int[] result = {};
		return result;
    }

	public static void main(String[] args) {
		String[] aa = {"zzzz", "ferz","zdsr","fgtd"};
		System.out.println(Arrays.toString(solution(aa)));
	}

}
