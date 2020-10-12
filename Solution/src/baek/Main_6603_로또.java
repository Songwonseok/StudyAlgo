package baek;

import java.io.*;
import java.util.*;

public class Main_6603_로또 {
	static int[] select;
	static boolean[] visit;
	
	public static void printLotto(int[] number, int start, int depth) {
		if(depth == 6) {
			String[] str = new String[6];
			for(int i=0;i<6;i++)
				str[i] = String.valueOf(select[i]);
			System.out.println(String.join(" ", str));
			return;
		}
		
		for(int i=start;i<number.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				select[depth] = number[i];
				printLotto(number, i,depth+1);
				visit[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = br.readLine();
			if(line.equals("0")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(line);
			
			int k = Integer.parseInt(st.nextToken());
			int[] number = new int[k];
			
			select = new int[6];
			visit = new boolean[k];
			
			for(int i=0;i<k;i++)
				number[i] = Integer.parseInt(st.nextToken());
			
			printLotto(number,0,0);
			System.out.println();
		}
	}

}
