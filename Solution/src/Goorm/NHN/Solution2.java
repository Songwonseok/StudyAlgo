package Goorm.NHN;

import java.util.Scanner;

public class Solution2 {
	private static int leftMax(int idx, int[] blocks) {
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
	
	private static void solution(int day, int width, int[][] blocks) {
	    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		
		int total = 0;
		int[] building = new int[width];
		
		for(int i=0; i<day;i++) {
			for(int j=0;j<width;j++) {
				building[j] += blocks[i][j];
			}
			
			for(int j=1;j< width-1;j++) {
				int leftHeight =  leftMax(j, building);
				if(leftHeight <= building[j])
					continue;
				
				int rightHeight = rightMax(j, building);
				if(rightHeight <= building[j])
					continue;
				
				int target =  Math.min(leftHeight, rightHeight);
				total += target - building[j];
				building[j] = target;
			}
		}
		System.out.println(total);
	  }

	private static class InputData {
	    int day;
	    int width;
	    int[][] blocks;
	  }

	private static InputData processStdin() {
	    InputData inputData = new InputData();

	    try (Scanner scanner = new Scanner(System.in)) {
	      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
	      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
	      
	      inputData.blocks = new int[inputData.day][inputData.width];
	      for (int i = 0; i < inputData.day; i++) {
	        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
	        for (int j = 0; j < inputData.width; j++) {
	          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
	        }
	      }
	    } catch (Exception e) {
	      throw e;
	    }

	    return inputData;
	  }

	  public static void main(String[] args) throws Exception {
		  InputData inputData = processStdin();

		  solution(inputData.day, inputData.width, inputData.blocks);
	  }
}
