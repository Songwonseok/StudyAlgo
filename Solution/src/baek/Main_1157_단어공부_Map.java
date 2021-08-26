package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1157_단어공부_Map {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Character, Integer> map = new HashMap<>();
		String word = br.readLine().toUpperCase();

		int max = 0;

		for(int i=0; i<word.length(); i++){
			char alphabet = word.charAt(i);
			map.put(alphabet,map.getOrDefault(alphabet, 0) + 2);

			max = Math.max(map.get(alphabet), max);
		}

		char answer = '?';

		for(char key : map.keySet()){
			if(map.get(key) == max){
				if(answer != '?'){
					answer = '?';
					break;
				}
				answer = key;
			}
		}

		System.out.println(answer);
	}
}
