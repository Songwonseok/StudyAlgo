package Programmers.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_더맵게 {
	static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() > 1) {
        	int first = pq.poll();
        	int second= pq.poll();
        	
        	pq.add(first+(second*2));
        	answer++;
        }
        if(pq.peek() < K)
        	return -1;
        
        return answer;
    }

	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville,K));
	}

}
