package Multicampus;

import java.util.List;
/*
 * 중간 피벗을 기준으로 왼쪽 오른쪽 합이 같게 되는 pivot의 인덱스를 찾는 문제
 * [1,2,3,4,6] =>> pivot의 인덱스 : 3
 */


public class Solution1 {
	public static int balancedSum(List<Integer> arr) {
	    // Write your code here
		int pivot = arr.size()/2;
		int left = 0;
		int right = 0;
		
		for(int i=0;i<pivot;i++) {
			left += arr.get(i);
		}
		for(int i=pivot+1;i< arr.size();i++)
			right += arr.get(i);
		
		while(left != right) {
			if(left > right) {
				right += arr.get(pivot);
				pivot--;
				left -= arr.get(pivot);
			}else {
				left += arr.get(pivot);
				pivot++;
				right -= arr.get(pivot);
			}
		}
		
		return pivot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
