package baek;

import java.io.*;
import java.util.*;

public class Main_11728_배열합치기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] leftArray = new int[N], rightArray = new int[M], answer = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			leftArray[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			rightArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx=0, leftIdx=0, rightIdx = 0;
		while(leftIdx < N && rightIdx < M) {
			if(leftArray[leftIdx] <= rightArray[rightIdx]) {
				answer[idx++] = leftArray[leftIdx++];
			}else {
				answer[idx++] = rightArray[rightIdx++];
			}
		}
		while(leftIdx < N) answer[idx++] = leftArray[leftIdx++];
		while(rightIdx < M) answer[idx++] = rightArray[rightIdx++];
		
		StringBuilder sb = new StringBuilder();
		
		for(int num: answer) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
