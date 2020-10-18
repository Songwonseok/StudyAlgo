package baek;

import java.io.*;
import java.util.Arrays;

public class Main_3273_두수의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		String[] str = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(str[i]);
		}
		int target = Integer.parseInt(br.readLine());
		
		Arrays.sort(numbers);
		
		int left = 0;
		int right = N-1;
		int cnt =0;
		while(left < right) {
			int sum = numbers[left] + numbers[right];
			if(target == sum) {
				cnt++;
			}
			if(sum <= target)
				left++;
			else
				right--;
		}
		
		System.out.println(cnt);
	}

}
