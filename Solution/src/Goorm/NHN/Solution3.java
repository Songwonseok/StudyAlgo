package Goorm.NHN;

import java.util.Scanner;

public class Solution3 {
	static int currIndex;
	
	private static String solve(String order) {
		
		StringBuilder result = new StringBuilder();
		
		while(currIndex < order.length()) {
			char curr = order.charAt(currIndex);
			
			if(curr == ')') {
				currIndex++;
				return result.toString();
			}
			
			if(Character.isDigit(curr)) {
				int num = curr - '0';
				currIndex++;
				char next = order.charAt(currIndex);
				
				if(next == '(') {
					StringBuilder sb = new StringBuilder();
					currIndex++;
					String str2 = solve(order);
					for(int i=0;i<num;i++){
						sb.append(str2);
					}
					result.append(sb.toString());
				}else {
					StringBuilder sb = new StringBuilder();
					String str2 = ""+next;
					for(int i=0;i<num;i++){
						sb.append(str2);
					}
					result.append(sb.toString());
				}
				continue;
			}else if(curr == '(') {
				currIndex++;
				result.append(solve(order));
				currIndex++;
			}else {
				int num = curr - '0';
				currIndex++;
				char next = order.charAt(currIndex);
				
				if(next == '(') {
					StringBuilder sb = new StringBuilder();
					currIndex++;
					String str2 = solve(order);
					for(int i=0;i<str2.length();i++){
						sb.append(result.toString() + str2.substring(i,i+1));
					}
					result.append(sb.toString());
				}else {
					StringBuilder sb = new StringBuilder();
					currIndex++;
					String str2 = solve(order);
					for(int i=0;i<str2.length();i++){
						sb.append(result.toString() + str2.substring(i,i+1));
					}
					result.append(sb.toString());
				}
				continue;
				
			}
		}
		
		return result.toString();
	}
	private static void solution(int numOfOrder, String[] orderArr) {
	    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for(int i=0;i<numOfOrder;i++) {
			currIndex = 0;
			System.out.println(solve(orderArr[i]));
		}
	  }

	  private static class InputData {
	    int numOfOrder;
	    String[] orderArr;
	  }

	  private static InputData processStdin() {
	    InputData inputData = new InputData();

	    try (Scanner scanner = new Scanner(System.in)) {
	      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

	      inputData.orderArr = new String[inputData.numOfOrder];
	      for (int i = 0; i < inputData.numOfOrder; i++) {
	        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
	      }
	    } catch (Exception e) {
	      throw e;
	    }

	    return inputData;
	  }

	  public static void main(String[] args) throws Exception {
	    InputData inputData = processStdin();

	    solution(inputData.numOfOrder, inputData.orderArr);
	  }
	}

