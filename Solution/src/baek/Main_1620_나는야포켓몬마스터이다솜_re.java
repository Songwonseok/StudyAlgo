package baek;

import java.io.*;
import java.util.*;

public class Main_1620_나는야포켓몬마스터이다솜_re {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			String pokemon = br.readLine();
			map.put(pokemon, Integer.toString(i));
			map.put(Integer.toString(i), pokemon);
		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			String question = br.readLine();
			result.append(map.get(question)).append("\n");
		}
		System.out.println(result);
		
	}

}
