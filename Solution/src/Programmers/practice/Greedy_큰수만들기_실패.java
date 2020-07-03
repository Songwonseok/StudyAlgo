package Programmers.practice;

import java.util.*;

public class Greedy_큰수만들기_실패 {

	
	static boolean[] v;
    static long N, max;
    static char[] nums;
    
    public static void getComb(int start, int depth){
        if(depth == 0){
            String result="";
            for(int i=0;i<nums.length;i++){
                if(!v[i])
                    result += nums[i];
            }
            max = Math.max(max, Long.parseLong(result));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(!v[i]){
                v[i] = true;
                getComb(i,depth-1);
                v[i] = false;
            }
        }
        
    }
    
    public static String solution(String number, int k) {
        String answer = "";
        nums = number.toCharArray();
        max = 0;
        v = new boolean[nums.length];
        
        getComb(0,k);
        
        answer = Long.toString(max);
        return answer;
    }
    
    public static void main(String[] args) {
    	
    	String number = "922909800000";
    	int k = 3;
    	
    	System.out.println(solution(number,k));
    	
    }
}
