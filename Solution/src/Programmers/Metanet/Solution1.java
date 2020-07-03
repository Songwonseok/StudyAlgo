package Programmers.Metanet;

import java.util.Arrays;

public class Solution1 {
	
	public void rotation(int[] arr) {
		int[] temp = arr.clone();
		
		arr[0] = temp[temp.length-1];
		
		for(int i=1;i<arr.length;i++) {
			arr[i] = temp[i-1];
		}
	}
	

	public boolean solution(int[] arrA, int[] arrB) {
        boolean answer = false;
        
        if(Arrays.equals(arrA, arrB))
        	return true;
        
        for(int i=0;i<arrA.length-1;i++) {
        	rotation(arrA);
        	if(Arrays.equals(arrA, arrB))
        		return true;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {

	}

}
