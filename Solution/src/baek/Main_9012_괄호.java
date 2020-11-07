package baek;

import java.io.*;
import java.util.*;

public class Main_9012_괄호 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			boolean check = true;
			
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				
				if(c== ')') {
					if(stack.isEmpty()) {
						check = false;
						break;
					}else {
						stack.pop();
					}
				}else 
					stack.push(c);
				
			}
			
			if(stack.isEmpty() && check)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
