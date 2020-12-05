package baek;

import java.io.*;

public class Main_1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		
		int zero = 0;
		int one = 0;
		
		char num = nums.charAt(0);
		if(num == '0') {
			zero++;
		}else
			one++;
		
		for(int i=1;i<nums.length();i++) {
			if(nums.charAt(i-1) == nums.charAt(i)) 
				continue;
			
			if(nums.charAt(i) == '0')
				zero++;
			else
				one++;
		}
		
		int min = Math.min(one, zero);
		
		System.out.println(min);
	}

}
