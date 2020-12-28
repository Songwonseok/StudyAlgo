package baek;

import java.io.*;
import java.util.*;

public class Main_1620_나는야포켓몬마스터이다솜 {
	
	public static boolean isNumeric(String s) throws Exception{
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> stringToInt = new HashMap<>();
		String[] intToString = new String[N+1];
		
		for(int i=1;i<=N;i++) {
			String pokemon = br.readLine();
			stringToInt.put(pokemon, i);
			intToString[i] = pokemon;
		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			String question = br.readLine();
			if(isNumeric(question)) {
				result.append(intToString[Integer.parseInt(question)]).append("\n");
			}else {
				result.append(stringToInt.get(question)).append("\n");
			}
		}
		System.out.println(result);
		
	}

}
