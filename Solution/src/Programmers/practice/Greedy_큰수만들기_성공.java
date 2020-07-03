package Programmers.practice;

import java.util.*;

public class Greedy_큰수만들기_성공 {

    
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] nums = number.toCharArray();
        int size = nums.length-k;
        int index = 0;
        
        for(int i=size-1;i>=0;i--) {
        	char max = '0';
        	
        	for(int j=index;j<nums.length-i;j++) {
        		if(nums[j] > max) {
        			max = nums[j];
        			index=j+1;
        		}
        	}
        	answer.append(max);
        }
        
        return answer.toString();
    }
    
    public static void main(String[] args) {
    	
    	String number = "4177252841";
    	int k = 4;
    	
    	System.out.println(solution(number,k));
    	
    }
}
