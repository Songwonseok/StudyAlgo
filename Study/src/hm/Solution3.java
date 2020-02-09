package hm;

class Solution3 {
	public static int solution(String[] board) {
		int N = board.length;
		char[][] arr = new char[N][N];
		int[] di = { -1, 1, 1, -1 }, dj = { 1, 1, -1, -1 };

		for (int i = 0; i < N; i++) {
			arr[i] = board[i].toCharArray();
		}
		int max = 0;
		int gap = 1;
		for (int i = 1; i < N - gap; i++) {			
				for (int j = 1; j < N - gap; j++) {
					if (j < gap )
						continue;
						char alph = arr[i][j];
						if (alph == arr[i + di[0]][j + dj[0]] && alph == arr[i + di[1]][j + dj[1]]
								&& alph == arr[i + di[2]][j + dj[2]] && alph == arr[i + di[3]][j + dj[3]]) {
							int min = 1001;
							for (int dir = 0; dir < 4; dir++) {
								int cnt = 1;
								int ni = i + di[dir];
								int nj = j + dj[dir];
								while (true) {
									if (ni < 0 || ni >= N || nj < 0 || nj >= N)
										break;
									if (arr[ni][nj] != alph)
										break;
									ni += di[dir];
									nj += dj[dir];
									cnt++;

								}
								min = Math.min(min, cnt - 1);
							}
							if (min * 2 + 1 > max) {
								max = min * 2 + 1;
								gap = min;
							}
						}
					
				}
			if(i >= N-gap-1)
				break;
		}
		return max;
	}

	public static void main(String[] args) {
		String[] board = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};
//		String[] board = { "ABCBA", "DABAG", "ENABH", "FAJAI", "AKLMO" };

		System.out.println(solution(board));
	}

}
