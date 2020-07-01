package algo.baek;

import java.io.*;
import java.util.*;

public class Main_16234_인구이동_송원석 {
	static int N, L, R;
	static int[][] A;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	
	//���ո����
	public static void union(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		que.offer(new int[] { x, y }); //bfs ���� ť
		list.add(new int[] { x, y }); //���� ��ġ ����Ʈ
		visit[x][y] = true;
		int sum = A[x][y]; //������ ����
		while (!que.isEmpty()) {
			int[] curr = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + di[i];
				int ny = curr[1] + dj[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
					int sub = Math.abs(A[curr[0]][curr[1]] - A[nx][ny]);
					if(sub >= L && sub <=R) {
						visit[nx][ny] = true;
						sum += A[nx][ny];
						que.offer(new int[] {nx,ny});
						list.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		for(int i=0;i<list.size();i++) {
			A[list.get(i)[0]][list.get(i)[1]] = sum / list.size(); //������ ������ ����Ʈ�� �����ŭ ���� 
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while (true) {
			int cnt = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//�湮���� �ʾҴٸ� 
					if (!visit[i][j]) {
						for (int k = 0; k < 4; k++) {
							int nx = i + di[k];
							int ny = j + dj[k];
							//�ֺ��� ������ ������ �ϳ��� �ִ��� ����
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && Math.abs(A[i][j] - A[nx][ny]) >= L
									&& Math.abs(A[i][j] - A[nx][ny]) <= R) {
								union(i, j);
								cnt++;
								
								break; // ������ �����Ǹ� 4���� �� �ȵ��Ƶ� �ǹǷ� break
							}
						}

					}
				}
			}
			//���̻� ������ �ȸ���� break
			if (cnt == 0)
				break;
			//�ѹ��̶� ������ٸ� time�� �߰�
			else
				time++;
		}

		System.out.println(time);

	}

}
