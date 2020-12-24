package baek;

import java.io.*;
import java.util.*;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] array = new int[2][10000001];
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				array[0][num]++;
			}else {
				array[1][-num]++;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				sb.append(array[0][num]).append(" ");
			}else {
				sb.append(array[1][-num]).append(" ");
			}
		}
		System.out.println(sb);
	}
}
