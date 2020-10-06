package baek;

import java.io.*;

public class Main_2138_전구와스위치 {

	public static int solve(char[] switchs, char[] goal, int N) {
		int cnt =0;
		for(int i=1;i<N;i++) {
			if(i == N-1) {
				if(switchs[i-1] != goal[i-1]) {
					switchs[i-1] = (switchs[i-1] == '0')? '1' : '0';
					switchs[i] = (switchs[i] == '0')? '1' : '0';
					cnt++;
				}
			}else {
				if(switchs[i-1] != goal[i-1]) {
					switchs[i-1] = (switchs[i-1] == '0')? '1' : '0';
					switchs[i] = (switchs[i] == '0')? '1' : '0';
					switchs[i+1] = (switchs[i+1] == '0')? '1' : '0';
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String origin= br.readLine();
		char[] goal = br.readLine().toCharArray();
		
		
		char[] fisrtOn =  origin.toCharArray();
		fisrtOn[0] = (fisrtOn[0] == '0')? '1' : '0';
		fisrtOn[1] = (fisrtOn[1] == '0')? '1' : '0';
		
		char[] firstOff = origin.toCharArray();
		int result = -1;
		
		int cnt1 = solve(fisrtOn,goal,N) + 1;
		int cnt2 = solve(firstOff,goal,N);
		
		if(String.valueOf(fisrtOn).equals(String.valueOf(goal))) {
			result = cnt1;
		}
		if(String.valueOf(firstOff).equals(String.valueOf(goal))) {
				result = (result != -1)? Math.min(result, cnt2): cnt2;
		}
		
		System.out.println(result);
	}

}
