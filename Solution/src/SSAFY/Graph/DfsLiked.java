package SSAFY.Graph;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DfsLiked {
	public static class Node{
		int data;
		Node link;
	}
	public static int V; //vertex
	public static int E; //edge
	public static Node[] graph;
	public static boolean[] visit;
	public static Stack<Node> stack;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_dfs.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new Node[V];
		stack = new Stack<Node>();
		
		for(int i=0;i<E;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			//양방향
			Node n1 = new Node();
			n1.data = v2;
			if(graph[v1]==null) {
				n1.link=graph[v1];
				graph[v1]=n1;
			}else{
				Node t = graph[v1];
				while(t.link!=null) {
					t=t.link;
				}
				t.link=n1;
			}		
			
			Node n2 = new Node();
			n2.data = v1;
			if(graph[v2]==null) {
				n2.link=graph[v2];
				graph[v2]=n2;
			}else{
				Node t = graph[v2];
				while(t.link!=null) {
					t=t.link;
				}
				t.link=n2;
			}//인접 리스트가 만들어진다!
			
		}
//		for(int i=0;i<V;i++) {
//			System.out.print(i + ":->");
//			if(graph[i]!=null) {
//				Node t = graph[i];
//				while(t.link!=null) {
//					System.out.print(t.data + "->");
//					t=t.link;
//				}
//				System.out.println(t.data);
//			}
//		}
		visit = new boolean[V];
		dfs(0);
		//dfsr(0);
		
	}
	
//	for(Node t=graph[i];t!=null;t=t.link) {
//		System.out.print(t.data"->);
//	}System.out.print();
	
	public static void dfs(int node) {
		visit = new boolean[V];
		Node n = new Node();
		n.data = node;
		stack.push(n);
		while(!stack.empty()) {
			Node curr = stack.pop();
			if(visit[curr.data] == false) {
				visit[curr.data] = true;
				System.out.print(curr.data + " ");
				
//				Node t = graph[curr.data];
//				while(t.link!=null) {
//					if(!visit[t.data]) {
//						stack.push(t);
//					}
//					t=t.link;
//				}
//				if(visit[t.data] == false)
//					stack.push(t);
			}
			for(Node t=graph[curr.data];t!=null;t=t.link) {
				if(visit[t.data] == false)
					stack.push(t);
			}
			
		}
		
	}

	private static void dfsr(int node) {
		visit[node] = true;
		System.out.print(node + " ");
		
		for(Node t=graph[node];t!=null;t=t.link) {
			if(visit[t.data] == false)
			dfsr(t.data);
			}
		}
		
//		Node t = graph[node];
//		while(t.link!=null) {
//			if(!visit[t.data]) {
//				dfsr(t.data);
//			}
//			t=t.link;
//		}
//		if(visit[t.data] == false)
//			dfsr(t.data);
//	}

		
	
}
