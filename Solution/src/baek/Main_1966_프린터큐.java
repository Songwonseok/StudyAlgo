package baek;

import java.io.*;
import java.util.*;

public class Main_1966_프린터큐 {
	public static boolean check(int[] values, int value){
        value = Math.abs(value);
        for(int i=1;i<values.length;i++){
            if(values[i] > 0 && i > value)
                return false;
        }
        return true;
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int[] values = new int[10];
        Queue<Integer> queue = new LinkedList<>();     
        
        for(int i=0;i<priorities.length;i++){
            values[priorities[i]]++;
        }
        priorities[location] *= -1;
        
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(check(values, curr)){
                answer++;
                values[Math.abs(curr)]--;
                if(curr < 0) 
                    return answer;    
            }else{
                queue.add(curr);
            }
        }
        
        return answer;
    }
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] priorities = new int[N];
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				priorities[i] = Integer.parseInt(st.nextToken());
				
			
	        int[] values = new int[10];
	        Queue<Integer> queue = new LinkedList<>();     
	        
	        for(int i=0;i<priorities.length;i++){
	            values[priorities[i]]++;
	        }
	        priorities[M] *= -1;
	        
	        for(int i=0;i<priorities.length;i++){
	            queue.add(priorities[i]);
	        }
	        while(!queue.isEmpty()){
	            int curr = queue.poll();
	            if(check(values, curr)){
	                answer++;
	                values[Math.abs(curr)]--;
	                if(curr < 0) 
	                    break;
	            }else{
	                queue.add(curr);
	            }
	        }
	        System.out.println(answer);
		}
	}
}
