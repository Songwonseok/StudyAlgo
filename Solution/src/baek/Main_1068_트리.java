package baek;

import java.io.*;
import java.util.*;

public class Main_1068_트리 {
	static class Node {
		public int number;
		public ArrayList<Node> children;
		
		Node(int number){
			this.number = number;
			this.children = new ArrayList<Node>();
		}
	}
	
	public static int countingLeaf(Node curr, int removed) {
		if(curr.children.size() == 0) {
			return 1;
		}else {
			int count = 0;
			for(Node child : curr.children) {
				if(child.number == removed) {
					if(curr.children.size() == 1)
						return 1;
					continue;
				}
				count += countingLeaf(child, removed);
			}
			return count;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node[] tree = new Node[N];
		Node root = null;
		
		for(int i=0;i<N;i++) {
			tree[i] = new Node(i);
		}
		
		for(int i=0;i<N;i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = tree[i];
			}else {
				tree[parent].children.add(tree[i]);
			}
		}
		int removed = Integer.parseInt(br.readLine());
		int result = 0;
		
		if(removed != root.number) {
			result = countingLeaf(root, removed);
		}
		System.out.println(result);
	}

}
