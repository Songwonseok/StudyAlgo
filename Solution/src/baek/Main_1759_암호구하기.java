package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호구하기 {
	public static final String VOWELS= "aeiou";
	public static boolean[] visit;
	public static char[] password;
	public static char[] alphabet;
	public static StringBuilder answer;

	public static void comb(int start, int depth, int length, int vowelCount, int consonantCount) {
		if(depth == length){
			if(vowelCount < 1 || consonantCount < 2){
				return;
			}

			answer.append(String.valueOf(password)).append("\n");
			return;
		}

		for(int i = start, size = alphabet.length; i < size; i++){
			if(!visit[i]){
				visit[i] = true;
				password[depth] = alphabet[i];

				if(VOWELS.contains(Character.toString(alphabet[i]))){
					comb(i, depth+1, length, vowelCount+1, consonantCount);
				}else{
					comb(i, depth+1, length, vowelCount, consonantCount+1);
				}

				visit[i] = false;
			}
		}

	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		password = new char[L];
		alphabet = new char[C];
		visit = new boolean[C];
		answer = new StringBuilder();

		for(int i=0;i<C;i++){
			alphabet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alphabet);

		comb(0, 0, L, 0, 0);

		System.out.println(answer.toString());
	}
}
