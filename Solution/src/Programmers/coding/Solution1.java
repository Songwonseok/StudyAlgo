package Programmers.coding;

import java.util.*;
/*
수학 시험을 잘 본 학생은 영어 시험도 잘 봤는지 알아보기 위해 
다음과 같이 순위 순서가 일치하는 학생 쌍은 얼마나 되는지구하려 합니다.

. 학생들에게 수학 시험 등수를 부여합니다.
. 학생들에게 영어 시험 등수를 부여합니다.
. (A 학생의 수학 시험등수 < B 학생의 수학 시험 등수) 이면서 
  (A 학생의 영어시험 등수 < B 학생의 영어 시험 등수)인 학생 쌍의 수를 셉니다.

학생들의 수학 시험 점수가 담긴 배열 math_scores, 
영어 시험 점수가 담긴 배열 english_scores 가 매개변수로 주어질때
순위 순서가 일치하는 학생 쌍의 수를 return 하도록 solution함수를 완성해주세요.

제한사항
. math_scores의 길이는 2이상 100이하입니다.
. math_scores의 원소는 0이상 100이하인 정수이며, 동점은 없습니다.
. english_scores의 길이는 math_scores의 길이와 같습니다.
. english_scores의 원소는 0이상 100이하의 정수이며, 동점은 없습니다.
. math_scores[i]와 english_scores[i]는 각각 i번 학생의 수학, 영어 시험 점수 입니다.

  math_scores       english_scores       result
[70,65,90,80,50]    [40,20,30,60,50]         5
[90,91,95,99,100]  [20,40,60,80,100]      10
[80,50,30,20,10]    [24,39,47,63,75]         0
 */

public class Solution1 {
	public static int solution(int[] math_scores, int[] english_scores) {
		int answer = 0;
		int[] math = new int[101];
        int[] english = new int[101];
        
        
        for(int i=0;i<math_scores.length;i++){
            math[math_scores[i]] = i+1;
            english[english_scores[i]] = i+1;
        }
        
        Arrays.sort(math_scores); 
        Arrays.sort(english_scores);
        
        for(int i=0;i<math_scores.length-1;i++){
            int num = math[math_scores[i]];
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<math_scores.length;j++)
                set.add(math[math_scores[j]]);
            boolean check = false;
            for(int j=0;j<english_scores.length;j++){
                if(check){
                    if(set.contains(english[english_scores[j]]))
                        answer++;
                }
                if(english[english_scores[j]] == num)
                    check = true;
            }
        }
		return answer;
	}
	public static void main(String[] args) {
		int[] math_scores = {80,50,30,20,10};
		int[] english_scores = {24,39,47,63,75};
		System.out.println(solution(math_scores, english_scores));
	}

}
