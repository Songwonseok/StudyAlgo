package Programmers.practice;

import java.util.Collections;
import java.util.PriorityQueue;


// 최대한 버틸 수 있는 stock중에 가장 많은 공급을 받을 수 있는 순으로 받음
// 그 이후 또 부족하면 남은 공급 기회중에 가장 많이 공급 받을 수 있는 것을 받음
public class Heap_라면공장 {
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index =0;
        while(stock < k){
            while(index < dates.length && stock >= dates[index]){
                pq.add(supplies[index]);
                index++;
            }
            stock += pq.poll();
            answer++;
        }

        return answer;
    }

	public static void main(String[] args) {
		
		int[] date = {4,10,15};
		int[] sp = {20,5,10};
		int k =30;
		System.out.println(solution(4,date,sp,k));
	}

}
