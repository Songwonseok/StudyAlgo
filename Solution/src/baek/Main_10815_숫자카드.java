package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean nums[][] = new boolean[2][10000001];
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0)
				nums[0][num] = true;
			else
				nums[1][-num] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				if(nums[0][num]) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			else
				if(nums[1][-num]) System.out.print(1 + " ");
				else System.out.print(0 + " ");
		}
	}

}
