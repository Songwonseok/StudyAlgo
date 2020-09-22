package Programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class solution2 {
	static HashMap<String, Integer> map;
	static boolean[] visit;
	static int[] index;

	public static void getCoure(int end,int depth, int start, char[] order) {
		if(end == depth) {
			String course = "";
			for(int idx : index) {
				course += order[idx];
			}
			map.put(course, map.getOrDefault(course, 0) +1);
			return;
		}
		for(int i=start;i<order.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				index[depth] = i;
				getCoure(end,depth+1, i, order);
				visit[i] = false;
			}
		}
	}
	public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList();
        
        for (int c : course) {
        	map = new HashMap<String,Integer>();
			for(String o : orders) {
				if(o.length() >= c) {
					char[] order = o.toCharArray();
					Arrays.sort(order);
					visit = new boolean[o.length()];
					index = new int[c];
					getCoure(c,0,0,order);
				}
			}
			int max = 1;
			for(String key: map.keySet()) {
				if(map.get(key) > max)
					max = map.get(key);
			}
			if(max >1) {
				for(String key: map.keySet()) {
					if(map.get(key) == max) {
						list.add(key);
					}
				}
			}
		}
        
        String[] answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        return answer;
    }

	public static void main(String[] args) {
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		System.out.println(Arrays.toString(solution(orders,course)));
	}

}
