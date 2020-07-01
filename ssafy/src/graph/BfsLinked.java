package graph;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import graph.DfsLiked.Node;


public class BfsLinked {
	public static class Node{
		int data;
		Node link;
	}
	
	public static int V; //vertex
	public static int E; //edge
	public static Node[] graph;
	public static boolean[] visit;
	public static Queue<Node> queue;

	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bfs.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new Node[V];
		queue = new LinkedList<Node>();
		
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
		for(int i=0;i<V;i++) {
			System.out.print(i + ":->");
			if(graph[i]!=null) {
				Node t = graph[i];
				while(t.link!=null) {
					System.out.print(t.data + "->");
					t=t.link;
				}
				System.out.println(t.data);
			}
		}
		
		bfs2(0);
//		visit = new boolean[V];
//		bfs(0);
		
	}

	public static void bfs(int node) {
		visit = new boolean[V];
		Node n = new Node();
		n.data = node;
		queue.offer(n);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(visit[curr.data] == false) {
				visit[curr.data] = true;
				System.out.print(curr.data + " ");
				
//				for(Node t=graph[curr.data];t!=null;t=t.link) {
//					if(visit[t.data] == false) {
//						queue.offer(t);
//					}
//						
//				}
				
				
				Node t = graph[curr.data];
				while(t.link!=null) {
					if(!visit[t.data]) {
						queue.offer(t);
					}
					t=t.link;
				}
				if(visit[t.data] == false)
					queue.offer(t);
			}
		}
		
	}
	
	public static void bfs2(int node) {
	int cnt = 0; //자식 갯수 세기
	visit = new boolean[V];
	visit[node] = true;
	Node n = new Node();
	n.data = node;
	queue.offer(n);
	while(!queue.isEmpty()) {
		int size = queue.size(); //내밑에 자식이 몇명인가
		for(int i=0;i<size;i++) {
		Node curr = queue.poll();				
			System.out.print(curr.data + " ");			
			
			Node t = graph[curr.data];
			while(t.link!=null) {
				if(!visit[t.data]) {
					visit[t.data]=true;
					queue.offer(t);
				}
				t=t.link;
			}
			if(visit[t.data] == false) {
				visit[t.data]=true;
				queue.offer(t);
			}
//			for(Node t=graph[curr.data];t!=null;t=t.link) {
//			if(visit[t.data] == false) {
//				queue.offer(t);
//			}
//				
//		}
			
		}
		System.out.println("cnt = " + cnt++);
	
		}		
	}

}
