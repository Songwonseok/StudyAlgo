package Programmers.practice;

import java.util.HashMap;

public class Hash_위장 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        
        for(int v : map.values()){
            answer *= v;
        }
        answer--;
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
