package baek;

import java.io.*;
import java.util.*;

public class Main_10816_숫자카드2_Hash {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(num, 0)).append(" ");
		}
		System.out.println(sb);

	}

}
