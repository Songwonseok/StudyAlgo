package Programmers.Boostcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	 
	
	
	public static void main(String[] args) {
		int[] answer = new int[5];
		
		List<Integer> setA = new ArrayList<>();
		List<Integer> setB = new ArrayList<>();
		int[] arrayA = {1,2,3,2};
		int[] arrayB = {1,3};
		
		for(int i=0;i<arrayA.length;i++) {
			if(!setA.contains(arrayA[i]))
				setA.add(arrayA[i]);
		}
		for(int i=0;i<arrayB.length;i++) {
			if(!setB.contains(arrayB[i]))
				setB.add(arrayB[i]);
		}
		
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		
		List<Integer> list = new ArrayList<>(setA);
		
		list.add(6);
		System.out.println(list.toString());
		list.remove(setA.get(0));
		
		System.out.println(setA.toString());
		System.out.println(list.toString());
		System.out.println(setA.size());
	}

}
