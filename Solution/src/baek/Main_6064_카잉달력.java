package baek;

import java.io.*;
import java.util.*;

public class Main_6064_카잉달력 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(M > N) {
				int temp = M;
				M = N;
				N = temp;
				
				temp = x;
				x = y;
				y = temp;
			}
			
			
			int time = x;
			int answer = x;
			if(x == y)
				System.out.println(x);
			else {
				boolean check = true;
				for(int i=0;i<N;i++) {
					time += M;
					answer = (answer+M)%N;
					if(answer == 0)
						answer = N;
					if(answer == y) {
						System.out.println(time);
						check = false;
						break;
					}
				}
				if(check)
					System.out.println(-1);
			}		
		}
	}

}
