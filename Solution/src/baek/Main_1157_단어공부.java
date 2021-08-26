package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1157_단어공부 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] alphabetCount = new int[26];
		int max = 0;
		char[] word = br.readLine().toUpperCase().toCharArray();

		for(char c : word) {
			int idx = c - 'A';

			alphabetCount[idx]++;
			max = Math.max(alphabetCount[idx], max);
		}

		char answer = '?';

		for(int i=0; i < 26; i++){
			if(max == alphabetCount[i]){
				if(answer != '?'){
					answer = '?';
					break;
				}

				answer = (char)('A' + i);
			}
		}

		System.out.println(answer);
	}
}
