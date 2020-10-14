package baek;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1965_상자넣기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[n];
		
		cnt[0] = 1;
		int result = 1;
		
		for(int i=1;i<n;i++) {
			int max = 1;
			for(int j=i-1;j>=0;j--) {
				if(num[j] < num[i]) {
					max = Math.max(max, cnt[j] + 1);
				}
			}
			cnt[i] = max;
			result = Math.max(result, cnt[i]);
		}
		
		System.out.println(result);
	}

}
