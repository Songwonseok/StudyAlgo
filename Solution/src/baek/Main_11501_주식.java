package baek;

import java.io.*;
import java.util.*;

public class Main_11501_주식 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long profit = 0;
			Stack<Integer> stack = new Stack();
			
			for(int i=0;i<N;i++) {
				stack.add(Integer.parseInt(st.nextToken()));
			}
			int sale = stack.pop();
			while(!stack.isEmpty()) {
				int price = stack.pop();
				if(price < sale) {
					profit += sale - price;
				}else {
					sale = price;
				}
			}
			System.out.println(profit);
		}
	}

}
