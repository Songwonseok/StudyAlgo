package SSAFY.Queue;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Bfs {
	public static int V; //vertex
	public static int E; //edge
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;

	public static void bfs2(int node) {
		int cnt = 0; //자식 갯수 세기
		visit = new boolean[V];
		visit[node] = true;
		queue.offer(node);
		while(!queue.isEmpty()) {
			//int size = queue.size(); //내밑에 자식이 몇명인가
			//for(int i=0;i<size;i++) {
				int curr = queue.poll();				
				System.out.print(curr + " ");
				
				for(int next=0;next<V;next++) {
					if(visit[next] == false && graph[curr][next] == 1) {
						visit[next] = true;
						queue.offer(next);
					}
				}
			//}
			//System.out.println("cnt = " + cnt++);
		
		}		
	}
	
	
	public static void bfs(int node) {
		visit = new boolean[V];
		queue.offer(node);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.print(curr + " ");
				for(int next=0;next<V;next++) {
					if(visit[next] == false && graph[curr][next] == 1)
						queue.offer(next);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bfs1.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		queue = new LinkedList<Integer>();
		
		for(int i=0;i<E;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		//for(int[] a:graph) System.out.println(Arrays.toString(a));
		bfs2(0);
		System.out.println();
//		visit = new boolean[V];
//		dfsr(0);
		
	}

	private static void bfsr(int node) {
		visit[node] = true;
		System.out.print(node + " ");
		for(int next=0;next<V;next++) {
			if(visit[next] == false && graph[node][next] == 1)
				bfsr(next);
		}
		
	}


}
