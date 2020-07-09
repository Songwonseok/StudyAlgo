package Programmers.practice;

import java.util.ArrayList;

public class BP_모의고사 {
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] result = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(supo1[i%supo1.length] == answers[i])
                result[0]++;
            if(supo2[i%supo2.length] == answers[i])
                result[1]++;
            if(supo3[i%supo3.length] == answers[i])
                result[2]++;
        }
        int max= Math.max(result[0], result[1] > result[2] ? result[1]:result[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            if(result[i] == max){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);
        
        return answer;
    }

	public static void main(String[] args) {

	}

}
