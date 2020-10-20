package Programmers.practice;

import java.util.*;

public class Queue_기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
       for(int i=0;i<N;i++) {
    	   queue.add((int)(Math.ceil((100.0 - progresses[i])/speeds[i])));
       }
       while(!queue.isEmpty()) {
    	   int time = queue.peek();
    	   int cnt = 0;
    	   while(!queue.isEmpty() && queue.peek() <= time) {
    		   queue.poll();
    		   cnt++;
    	   }
    	   list.add(cnt);
       }
       
       int[] answer = new int[list.size()];
       
       for(int i=0;i<list.size();i++)
    	   answer[i] = list.get(i);
        
        return answer;
    }
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses, speeds)));

	}

}
