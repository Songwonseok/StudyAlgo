package Programmers.naver;


// 더 해야함
import java.util.ArrayList;
import java.util.HashMap;

public class solution3 {
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap();
	static int min;
	public static void dfs(Integer parent, int cnt) {
		if(cnt > min) return;
		
		if(!map.containsKey(parent)) {
			min = Math.min(min, cnt);
			return;		
			}
		
		ArrayList<Integer> child = map.get(parent);
		if(child.size() == 1) {
			min = Math.min(min, cnt);
			return;		
		}
		
		for(int i=0;i<child.size();i++) {
			int childCnt = 0;
			for(int j=0;j<child.size();j++) {
				if(i!=j) {
					childCnt += findChildCnt(child.get(j));
				}
			}
			dfs(child.get(i), cnt+ childCnt);
		}
	}
	
	public static int findChildCnt(Integer root) {
		if(!map.containsKey(root)) {
			return 1;
		}
		
		ArrayList<Integer> child = map.get(root);
		
		int result = 0;
		for(int i=0;i<child.size();i++) {
			result += findChildCnt(child.get(i));
		}
		
		return result;
	}

	public static int solution(int n, int[][] edges) {
		int answer = 0;
		min = 1000000;
		for(int i=0;i<edges.length;i++) {
			if(map.containsKey(edges[i][0])) {
				map.get(edges[i][0]).add(edges[i][1]);
			}else {
				map.put(edges[i][0], new ArrayList<Integer>());
				map.get(edges[i][0]).add(edges[i][1]);
			}
		}
		
		dfs(0,1);
		answer = min;
		
		
		return answer;
	}

	public static void main(String[] args) {
		
		int n = 19;
		int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}, {1,5}, {2,6}, {3,7}, {3,8}, {3,9}, {4,10}, {4,11}, {5,12}, {5,13}, {6,14}, {6,15}, {6,16}, {8,17}, {8,18}};
		
		System.out.println(solution(n,edges));

	}

}


