package Programmers.practice;

import java.math.*;
import java.util.*;

public class Greedy_큰수만들기_BigInteger실패 {

	
	static boolean[] v;
	static BigInteger max;
    static char[] nums;
    
    public static void getComb(int start, int depth){
        if(depth == 0){
            String result="";
            for(int i=0;i<nums.length;i++){
                if(!v[i])
                    result += nums[i];
            }
            BigInteger a = new BigInteger(result);
            
            if(max.compareTo(a) == -1)
            	max = a;
            
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
        max = BigInteger.ZERO;
        v = new boolean[nums.length];
        
        getComb(0,k);
        
        answer = max.toString();
        return answer;
    }
    
    public static void main(String[] args) {
    	
    	String number = "99999999999999999999999999999999999999999999999999999999999999999999999999999";
    	int k = 2;
    	
    	System.out.println(solution(number,k));
    	
    }
}
