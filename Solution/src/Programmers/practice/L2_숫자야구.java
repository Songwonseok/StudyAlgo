package Programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class L2_숫자야구 {
	public int BP(int[][] baseball,String num){
        boolean check = true;
        for(int i=0;i<baseball.length;i++){
            int strike =0;
            int ball = 0;
            String question = Integer.toString(baseball[i][0]);
            for(int j=0;j<3;j++){
                if(num.charAt(j) == question.charAt(j))
                    strike ++;
                if(question.contains(String.valueOf(num.charAt(j)))){
                    ball++;
                }                
            }
            ball -= strike;
            if(strike != baseball[i][1] || ball != baseball[i][2]){
                check = false;
                break;
            }
        }
        if(check) return 1;
        else return 0;
    }
    public int solution(int[][] baseball) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                for(int k=1;k<=9;k++){
                    if(i != j && i != k && j != k){
                        list.add(Integer.toString(i*100+j*10+k));
                    }
                }
            }
        }
        
        for(int i=0;i<list.size();i++)
            answer += BP(baseball,list.get(i));
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
