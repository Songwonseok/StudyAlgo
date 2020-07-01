package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트_BR {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			
			values = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				values[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0);
			System.out.println("#"+tc+" "+sum);
		}
		
		
	}

}
