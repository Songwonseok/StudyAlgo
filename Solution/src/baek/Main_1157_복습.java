package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157_복습 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 0;
		int[] alphabet = new int[26];

		char[] word = br.readLine().toUpperCase().toCharArray();

		for(int i = 0; i < word.length; i++) {
			alphabet[word[i] - 'A']++;

			max = Math.max(max, alphabet[word[i] - 'A']);
		}

		boolean duplicated = false;
		char answer = '?';

		for(int i = 0; i < 26; i++) {
			if(max == alphabet[i]) {

				if(duplicated) {
					System.out.println('?');
					return;
				}

				answer = (char) (i + 'A');
				duplicated = true;
			}
		}

		System.out.println(answer);
	}

}
