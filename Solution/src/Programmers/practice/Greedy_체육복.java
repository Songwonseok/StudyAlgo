package Programmers.practice;

public class Greedy_체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        
        for(int i=0;i<lost.length;i++)
            students[lost[i]-1]--;
        
        for(int i=0;i<reserve.length;i++)
            students[reserve[i]-1]++;
        
        for(int i=0;i<n;i++){
            if(students[i]>0){
                if(i>0 && students[i-1] <0){
                    students[i]--;
                    students[i-1]++;
                }else if(i<n-1 && students[i+1] <0){
                    students[i]--;
                    students[i+1]++;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(students[i] >= 0)
                answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		
	}

}
