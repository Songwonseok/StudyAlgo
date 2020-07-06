package Programmers.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_가장큰수 {
	public static String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for(int i=0;i<str.length;i++) {
        	str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			}
        });
        
        
        for(String s: str) {
        	answer += s;
        }
        
        if(answer.charAt(0) == '0')
        	answer = "0";
        
        return answer;
    }

	public static void main(String[] args) {
		
		int[] number = {3, 30, 34, 5, 9};
		
		System.out.println(solution(number));
		
	}

}
