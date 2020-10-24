package Multicampus;

import java.util.ArrayList;
import java.util.List;

public class solution5 {

	// X값에서 시작하여 주어진 배열을 왼쪽에서 더 해가면서 우측으로 갔을 때
	// 모든 누계는 1보다 작으면 안될때 X의 최소값은?
	public static int minX(List<Integer> arr) {
	    // Write your code here
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i= 0; i<arr.size();i++) {
			sum += arr.get(i);
			min = Math.min(min, sum);
		}
		
		
		return (-1)*min + 1;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<>();
//		arr.add(10);
		arr.add(-5);
		arr.add(4);
		arr.add(-2);
		arr.add(3);
		arr.add(1);
		arr.add(-1);
		arr.add(-6);
		arr.add(-1);
		arr.add(0);
		arr.add(5);

		System.out.println(minX(arr));

	}

}
