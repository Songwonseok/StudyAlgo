package algo.baek;

import java.io.*;
import java.util.*;

public class Main_백준_14888_연산자끼워넣기_서울9반_송원석 {
	static int N,max,min;
	static int[] operator,nums;
	//+,-,*,/
	public static void operation(int result, int r) {
		if(r==N-1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		int num= result;
		for(int i=0;i<4;i++) {
			num = result;
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
				case 0: num += nums[r+1];
				break;
				case 1: num -= nums[r+1];
				break;
				case 2: num *= nums[r+1];
				break;
				default:
					num /= nums[r+1];
				}
				operation(num,r+1);
				operator[i]++;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		operator = new int[4];
		N = Integer.parseInt(bf.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		operation(nums[0],0);
		
		System.out.println(max);
		System.out.println(min);
		
	}

}
