package baek;

import java.io.*;
import java.util.*;

public class Main_16112_5차전직 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long exp = 0;
		long active = 0;
		
		long[] quest = new long[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			quest[i] = Long.parseLong(st.nextToken());
		
		
		Arrays.sort(quest);
		
		for(int i=0;i<quest.length;i++) {
			exp += active * quest[i];
			if(active < k) {
				active++;
			}
		}
		
		System.out.println(exp);
		
	}

}
