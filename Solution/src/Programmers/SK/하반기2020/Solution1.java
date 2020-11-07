package Programmers.SK.하반기2020;


/*
 * 
 * 섬에서 섬으로 배로 물건을 실어서 총 m만큼 옮기는 문제
 * 각 배마다 최대 실을 수 있는 무게가 담긴 d를 줌
 * 하지만 배마다 최대 하중은 모르는 상태라서 물건의 무게를 1, 2, 4, 8... 2배씩 증가시키면서 옮김
 * 배가 가라앉으면 다시 다음은 1부터 시작, 물건의 양은 무한하다고 가정 
 * 모두 다 옮기는데 얼마나 걸리는지 값을 구함, 못옮기는 경우엔 -1 return
 * m이상으로 옮겨도 괜찮음
 */

class Solution1 {
    public int solution(int[] d, int m) {
        int answer = 0;
        int total = 0;
        int item = 1;    
        for(int i=0;i<d.length;i++){
            answer++;
            if(d[i] < item){
                item = 1;
                continue;
            }else{
                total += item;
                if(total >= m)
                    break;       

                item *= 2;
            }
        }
        if(total >= m)
            return answer;
        return -1;
    }
}