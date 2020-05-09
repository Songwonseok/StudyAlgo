import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public static int[] solution(int n, int min, int max, int[] position) {
		
		int[] answer= {};
		answer = new int[n-position.length];
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<position.length;i++) {
			set.add(position[i]);
		}
		
		int size = Math.abs(min)+Math.abs(max)+1;
		int jump = size/(n-1);
		
		int index=0;
		
		for(int i=0;i<n-1;i++) {
			if(set.contains(min+jump*i))
				continue;
			answer[index++] = min+jump*i;
		}
		return answer;
	}
	

	public static void main(String[] args) {
		
		
		System.out.println(Arrays.toString(solution(5,-5,3,new int[] {-1,-3,3})));
	}

}
