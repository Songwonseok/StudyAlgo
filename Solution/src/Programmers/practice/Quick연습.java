package Programmers.practice;

import java.util.Arrays;

public class Quick연습 {
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];
		
		while(left<=right) {
			while(pivot >arr[left]) left++;
			while(pivot < arr[right]) right--;
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
		
	}

	static void quick(int[] arr, int left, int right) {
		if(left >= right) return;
		
		int mid = partition(arr, left, right);
		
		quick(arr,left,mid-1);
		quick(arr,mid,right);
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3,5,1,2,51,23};
		quick(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
