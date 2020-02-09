package baek;

import java.io.*;
import java.util.*;

public class Main_17825_주사위윷놀이 {
	static int[] dice;
	static int[][] board = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },//20
			{ 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 }, // 12
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 }, // 16
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40 } }; // 22
	static int max;
	public static void visit(boolean[][] vt, int r, int i, boolean flag) {
		if(board[r][i] == 25 || board[r][i] == 30|| board[r][i] == 35|| board[r][i] == 40) {
			if(board[r][i] == 40) {
				vt[0][vt[0].length-1] = flag;
				vt[1][vt[1].length-1] = flag;
				vt[2][vt[2].length-1] = flag;
				vt[3][vt[3].length-1] = flag;
			}else {
				if(board[r][i] == 25) {
					vt[1][vt[1].length-4] = flag;
					vt[2][vt[2].length-4] = flag;
					vt[3][vt[3].length-4] = flag;
				}else if(board[r][i] == 30) {
					if(i== 15) {
						vt[r][i] = flag;
						vt[3][i] = flag;
					}else {
						vt[1][vt[1].length-3] = flag;
						vt[2][vt[2].length-3] = flag;
						vt[3][vt[3].length-3] = flag;
					}
				}else if(board[r][i]== 35) {
					vt[1][vt[1].length-2] = flag;
					vt[2][vt[2].length-2] = flag;
					vt[3][vt[3].length-2] = flag;
				}
			}
		}else if(board[r][i] == 10 || board[r][i] == 20){
			if(board[r][i] == 10) {
				vt[0][i] = flag;
				vt[1][i] = flag;
			}else {
				vt[0][i] = flag;
				vt[2][i] = flag;
			}
		}
	}
	
	
	public static void playGame(int[][] p, boolean[][] v, int turn, int total) {
		if (turn == 10) {
			max = Math.max(total, max);
			return;
		}
		boolean check = false;
		for(int i=0;i<4;i++) {
			if(p[i][2] == 0)
				check = true;
				break;
		}
		if(!check) {
			max = Math.max(total, max);
			return;
		}
		
		
		int[][] temp = new int[4][3];
		boolean[][] vt = new boolean[4][];

		for (int i = 0; i < 4; i++) {
			temp[i] = p[i].clone();
			vt[i] = v[i].clone();
		}
		int num = dice[turn];
		for (int i = 0; i < 4; i++) {
			if (temp[i][2] == 0) { // 살아있으면
				int tmpI = temp[i][0];
				int tmpR = temp[i][1];

				switch (temp[i][0]) {
				case 5:
					temp[i][1] = 1;
					break;
				case 10:
					if (temp[i][1] == 0)
						temp[i][1] = 2;
					break;
				case 15:
					if (temp[i][1] == 0)
						temp[i][1] = 3;
					break;
				default:
				}

				temp[i][0] += num;
				visit(vt,tmpR,tmpI,false);
				
				if (board[temp[i][1]].length <= temp[i][0]) {
					temp[i][2] = 1;
					playGame(temp, vt, turn + 1, total);
					temp[i][2] = 0;
				} else if (!vt[temp[i][1]][temp[i][0]]) {
					visit(vt,temp[i][1],temp[i][0],true);
					playGame(temp, vt, turn + 1, total + board[temp[i][1]][temp[i][0]]);
					visit(vt,temp[i][1],temp[i][0],false);
				}
				visit(vt,tmpR,tmpI,true);
				temp[i][0] = tmpI;
				temp[i][1] = tmpR;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		dice = new int[10];
		max = 0;
		int[][] p = new int[4][3]; // index, route, surv
		boolean[][] v = new boolean[4][];
		for (int i = 0; i < 4; i++)
			v[i] = new boolean[board[i].length];
		for (int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		playGame(p, v, 0, 0);
		System.out.println(max);

	}
}
