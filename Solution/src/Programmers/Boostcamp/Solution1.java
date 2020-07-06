package Programmers.Boostcamp;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution1 {
	public static boolean solution(String[] name_list) {
		boolean answer = false;
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<name_list.length;i++) {
			set.add(name_list[i]);
		}
		
		if(set.size() != name_list.length) {
			answer = true;
		}else {
			ArrayList<String> list = new ArrayList<>(set);
flag:		for(int i=0;i<list.size();i++) {
				for(int j=0;j<list.size();j++) {
					if(i != j && list.get(i).contains(list.get(j))) {
						answer = true;
						break flag;
					}
				}
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		String[] a = {"봄","여울","봄봄"};
		System.out.println(solution(a));
	}

}
