package baek;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS {
	static int N,M,V;
	static Node[] nodeArray;
	
	public static class Node {
		public int num;
		public ArrayList<Integer> linkedNode;
		
		public Node(int num) {
			this.num = num;
			this.linkedNode = new ArrayList<>();
		}
	}
	
	public static void DFS(Node[] nodeArray, int currNum, StringBuilder result, boolean[] visit) {
		visit[currNum] = true;
		result.append(currNum).append(" ");
		Collections.sort(nodeArray[currNum].linkedNode);
		for(int i=0;i<nodeArray[currNum].linkedNode.size();i++) {
			int next = nodeArray[currNum].linkedNode.get(i);
			if(!visit[next]) {
				DFS(nodeArray,next, result, visit);
			}
		}
	}
	
	public static void BFS(Node[] nodeArray, int startNum, StringBuilder result, boolean[] visit) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(nodeArray[startNum]);
		visit[startNum] = true;
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			Collections.sort(curr.linkedNode);
			result.append(curr.num).append(" ");
			for(int i=0;i<curr.linkedNode.size();i++) {
				int next = curr.linkedNode.get(i);
				if(!visit[next]) {
					visit[next] = true;
					queue.add(nodeArray[next]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		nodeArray = new Node[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(nodeArray[from] == null)
				nodeArray[from] = new Node(from);
			if(nodeArray[to] == null)
				nodeArray[to] = new Node(to);
			
			nodeArray[from].linkedNode.add(to);
			nodeArray[to].linkedNode.add(from);
		}
		
		// 시작지점과 연결된 노드가 없을 경우 런타임에러
		if(nodeArray[V] == null) {
			nodeArray[V] = new Node(V);
		}
		
		boolean[] visit = new boolean[N+1];
		StringBuilder resultDFS = new StringBuilder();
		StringBuilder resultBFS = new StringBuilder();
		DFS(nodeArray,V, resultDFS, Arrays.copyOf(visit, N+1));
		BFS(nodeArray,V, resultBFS, Arrays.copyOf(visit, N+1));
		System.out.println(resultDFS + "\n" + resultBFS);
	}
}
