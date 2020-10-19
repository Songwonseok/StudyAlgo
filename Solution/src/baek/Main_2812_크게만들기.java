package baek;

import java.io.*;
import java.util.*;

public class Main_2812_크게만들기 {
	
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = N-K;
		String number = br.readLine();
		
		Deque<Character> deque = new ArrayDeque();
		
		
		deque.addFirst(number.charAt(0));
		
		for(int i=1;i<number.length();i++) {
			while(!deque.isEmpty()&& K > 0 && deque.peekLast() < number.charAt(i)) {
				K--;
				deque.pollLast();
			}
			deque.addLast(number.charAt(i));
		}
		
		 StringBuilder result = new StringBuilder();
		while(result.length() < size) {
			result.append(deque.pollFirst());
		}
		
		
		System.out.println(result);
	}

}
