package Programmers.naver;

import java.util.Arrays;

public class solution2 {
	public static int[] solution(int[][] b) {
		int height = b.length;
		int total = (height* (height+1) / 2);
		int[] answer = new int[total];
		
		int cnt = b.length;
		
		int[][] nb = new int[height][height];
		
		for(int i=0; i<height; i++) {
			Arrays.fill(nb[i], -101);
		}
		
		for(int i=0;i<height;i++) {
			nb[i][b[i][0]] = b[i][1];
		}
		int time =1;
		
		while(cnt < total) {
			System.out.println(time++);
			System.out.println(cnt);
			for(int i=0;i<height-1;i++) {
				for(int j=0;j<=i;j++) {
					if(nb[i][j] != -101) {
						int add = nb[i][j];
						int left = nb[i+1][j];
						int right = nb[i+1][j+1];
						if((left == -101 && right == -101) || (left != -101 && right != -101)) {
							continue;
						}
						else if(left != -101) {
							nb[i+1][j+1] = add - left;
							cnt++;
						}else {
							nb[i+1][j] = add - right;
							cnt++;
						}
					}
				}
			}
			int bottom = height-1;
			for(int i=height-1; i>0;i--) {
				if(nb[bottom][i] != -101) {
					if(nb[bottom-1][i-1] != -101) {
						nb[bottom][i-1] = nb[bottom-1][i-1] - nb[bottom][i];
						cnt++;
					}
				}
			}
			
		}
		
		int idx = 0;
		for(int i=0;i<height;i++) {
			for(int j=0;j<=i;j++) {
				answer[idx++] = nb[i][j];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] b = {{0,50}, {0,22}, {2,10}, {1,4}, {4,-13}};
		int[] result = solution(b);
		
		System.out.println(Arrays.toString(result));

	}

}
