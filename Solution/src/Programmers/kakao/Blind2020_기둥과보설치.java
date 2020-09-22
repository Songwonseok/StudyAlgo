package Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class Blind2020_기둥과보설치 {
	// 0: ���, 1: ��  
	public static int[][] solution(int n, int[][] build_frame) {
		int[][] structure = new int[n+1][n+1];
		
		for(int i=0;i<n+1;i++)
			Arrays.fill(structure[i], -1);
		
		// x,y,a,b 
		for(int i=0;i<build_frame.length;i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];
			
			if(a == 0) {
				boolean valid = validPilar(structure,x,y);
				if(valid) {
					structure[x][y] = (b==1)? 0 : -1;
				}
			}else {
				boolean valid = validBo(structure,x,y,n);
				if(valid) {
					structure[x][y] = (b==1)? 1 : -1;
				}
			}
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(structure[i][j] != -1) {
					list.add(new int[] {i,j,structure[i][j]});
				}
			}
		}
		
		
		
        int[][] answer = new int[list.size()][3];
        
        for(int i=0;i<list.size();i++) {
        	answer[i][0] =  list.get(i)[0];
        	answer[i][1] =  list.get(i)[1];
        	answer[i][2] =  list.get(i)[2];
        }
        
        return answer;
    }
	public static boolean validPilar(int[][] structure, int x, int y) {
		if(y==0) 
			return true;
		else if(x-1 >= 0 && structure[x-1][y] == 1)
			return true;
		else 
			return false;
	}
	
	public static boolean validBo(int[][] structure, int x, int y, int n) {
		int[] dx = {-1,1,0,-1,1}, dy = {0,0,-1,-1,-1}; // ��, ��, ��, �»�, ����
		
		if(y == 0){
			return false;
		}else if(x+dx[2] >=0 && structure[x+dx[2]][y+dy[2]] == 0) {
			return true;
		}else if(x+dx[0] >=0 && y+dy[0] >=0 && x+dx[1] <= n && y+dy[1] <=n){
			if(structure[x+dx[0]][y+dy[0]] == 1 && structure[x+dx[1]][y+dy[1]] ==1)
				return true;
			else if(x+dx[2] >=0){
				if(structure[x+dx[0]][y+dy[0]] == 1 && structure[x+dx[4]][y+dy[4]] ==0)
					return true;
				else if(structure[x+dx[1]][y+dy[1]] == 1 && structure[x+dx[3]][y+dy[3]] ==0)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int n = 5;
		int[][] result = solution(n,build_frame);
		for(int i=0;i<result.length;i++)
			System.out.println(Arrays.toString(result[i]));
	}

}
