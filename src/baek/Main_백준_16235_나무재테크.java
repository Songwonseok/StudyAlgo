package baek;

import java.util.*;
import java.io.*;

class Tree {
	int x;
	int y;
	int age;

	Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}
}

public class Main_백준_16235_나무재테크 {
	static int N, M, K;
	static PriorityQueue<Tree> pq;
	static int[][] A, map;

	public static void season() {
		int[] di = {-1,-1,0,1,1,1,0,-1};
		int[] dj = {0,1,1,1,0,-1,-1,-1};
		ArrayList<Tree> treelist = new ArrayList<>();
		ArrayList<Tree> die = new ArrayList<>();
		//봄
		while(!pq.isEmpty()) {
			Tree curr = pq.poll();
			if(curr.age<= map[curr.x][curr.y]) {
				map[curr.x][curr.y] -= curr.age;
				treelist.add(new Tree(curr.x,curr.y,curr.age+1));
			}else {
				die.add(new Tree(curr.x,curr.y,curr.age));
			}
		}
		//여름
		for(int i=0;i<die.size();i++) {
			map[die.get(i).x][die.get(i).y] += die.get(i).age/2;
		}
		
		//가을
		int size = treelist.size();
		for(int i=0;i<size;i++) {
			if(treelist.get(i).age%5 == 0) {
				for(int dir=0;dir<di.length;dir++) {
					int nx = treelist.get(i).x + di[dir];
					int ny = treelist.get(i).y + dj[dir];
					if(nx >=0 && nx < N && ny >= 0 && ny < N ) {
						treelist.add(new Tree(nx,ny,1));
					}
				}
			}
		}
		
		//살아남은 모든 트리를 pq에 넣어줌
		for(int i=0;i<treelist.size();i++) {
			pq.offer(treelist.get(i));
		}
		
		//겨울
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] += A[i][j];
			}
		}
		
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		map = new int[N][N];
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			Arrays.fill(map[i], 5);
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pq = new PriorityQueue<Tree>(new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return Integer.compare(o1.age,o2.age);
			}
		});

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x,y,age));
		}
		for (int i = 0; i < K; i++) {
			season();
		}
		System.out.println(pq.size());

	}

}
