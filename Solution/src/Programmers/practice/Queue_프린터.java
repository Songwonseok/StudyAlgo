package Programmers.practice;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_프린터 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
