package baek;

import java.io.*;
import java.util.*;

public class Main_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack();
		int[] answer = new int[N];
		int[] towers = new int[N];
		
		for(int i=0;i<N;i++) {
			towers[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(stack.isEmpty()) {
					answer[i] = 0;
					stack.push(i);
					break;
				}else {
					if(towers[i] > towers[stack.peek()]) {
						stack.pop();
					}else {
						answer[i] = stack.peek() +1;
						stack.push(i);
						break;
					}
				}
			}
		}
		for(int t : answer) {
			System.out.print(t+" ");
		}
		
	}

}
