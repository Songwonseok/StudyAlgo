package stack1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Dfs2 {
	public static int V; //vertex
	public static int E; //edge
	public static int[][] graph;
	public static boolean[] visit;
	public static Stack<Integer> stack;

	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_dfs.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		stack = new Stack<Integer>();
		
		for(int i=0;i<E;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		//for(int[] a:graph) System.out.println(Arrays.toString(a));
		//dfs(0);
		//System.out.println();
		visit = new boolean[V];
		dfsr(0);
		
	}
	

	public static void dfs(int node) {
		visit = new boolean[V];
		stack.push(node);
		while(!stack.empty()) {
			int curr = stack.pop();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.print(curr + " ");
				for(int next=V-1;next>=0;next--) {
					if(visit[next] == false && graph[curr][next] == 1)
						stack.push(next);
				}
			}
		}
		
	}

	private static void dfsr(int node) {
		visit[node] = true;
		System.out.print(node + " ");
		for(int next=0;next<V;next++) {
			if(visit[next] == false && graph[node][next] == 1)
				dfsr(next);
		}
		
	}


}
