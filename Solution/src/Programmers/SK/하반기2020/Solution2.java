package Programmers.SK.하반기2020;

import java.util.*;

/*
 * 포인트지급 이벤트
 * 유저 m명 중에서 1명씩 선발해서 포인트를 지급
 * 매 추첨마다 m명중 가장 포인트를 적게 지급받은 1명을 선발
 * 모든 추첨이 끝났을 때 가장 적게 받은 사람의 포인트를 출력
 */

class Solution2 {
    public long solution(int  m, int[] v) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            pq.add((long)0);
        }

        for(int i=0;i<v.length;i++){
            long curr = pq.poll();
            curr += v[i];
            pq.add(curr);
        }

        answer = pq.poll();

        return answer;
    }
    
}