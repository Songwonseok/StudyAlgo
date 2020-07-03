package SW;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1859_백만장자프로젝트 {
	static int[] values;
	static int N;
	static long sum;
	
	public static void solve(int start) {
		if(start == N)
			return;
		
		int max = -1;
		int index = 0;
		
		for(int i = N-1; i >= start;i--) {
			if(values[i] > max) {
				max = values[i];
				index = i;
			}
		}
		for(int i=start ; i < index; i++) {
			sum += max - values[i];
		}
		solve(index+1);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1859.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.next());
		
		for(int tc = 1 ; tc <= T; tc++) {
			N = Integer.parseInt(sc.next());
			sum = 0;
			
			values = new int[N];
			
			for(int i=0;i<N;i++) {
				values[i] = Integer.parseInt(sc.next());
			}
			
			
			solve(0);
			
			System.out.println("#"+tc+" "+sum);
		}
		
		
	}

}
