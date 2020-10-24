package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	public static int leftMax(int idx, int[] blocks) {
		int max = 0;
		
		for(int i=0;i<idx;i++) {
			max = Math.max(max, blocks[i]);
		}
		return max;
	}
	
	private static int rightMax(int idx, int[] blocks) {
		int max = 0;
		for(int i=blocks.length -1;i>idx;i--) {
			max = Math.max(max, blocks[i]);
		}
		return max;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int total = 0;
		int[] building = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int j=0;j<W;j++) {
			building[j] = Integer.parseInt(st.nextToken());
		}
		
		for(int j=1;j< W-1;j++) {
			int leftHeight =  leftMax(j, building);
			if(leftHeight <= building[j])
				continue;
			
			int rightHeight = rightMax(j, building);
			if(rightHeight <= building[j])
				continue;
			
			int target =  Math.min(leftHeight, rightHeight);
			total += target - building[j];
		}
		System.out.println(total);
	}

}
