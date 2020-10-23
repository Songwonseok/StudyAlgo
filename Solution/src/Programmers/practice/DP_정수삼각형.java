package Programmers.practice;

public class DP_정수삼각형 {
	public static int solution(int[][] triangle) {
        int N = triangle.length;

        for(int i=N-1;i>0;i--){
            for(int j=i;j>0;j--){
                triangle[i-1][j-1] = triangle[i-1][j-1] + Math.max(triangle[i][j], triangle[i][j-1]); 
            }
        }
        return triangle[0][0];
    }
	public static void main(String[] args) {
		
	}

}
