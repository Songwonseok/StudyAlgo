package baek;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11505_구간곱구하기 {
	static int MOD = 1000000007;
	static class SegmentTree{
		private long[] tree;
		public long[] arr;
		public SegmentTree(int N, long[] arr) {
			int size = 1 << (int)Math.ceil(Math.log10(N)/ Math.log10(2)) + 1;
			this.tree = new long[size+1];
			this.arr = arr;
			this.init(1,0,arr.length-1);
		}
		
		private long init(int node, int start, int end) {
			if(start == end) {
				return this.tree[node] = arr[start];
			}
			int mid = (start+end)/2;
			return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end))% MOD;
		}
		
		public long multiply(int node, int start, int end, int mulStart, int mulEnd) {
			if(mulEnd < start || mulStart > end) {
				return 1;
			}else if(mulStart <= start && end <= mulEnd) {
				return tree[node];
			}else {
				int mid = (start + end) / 2;
				return (multiply(node*2, start, mid, mulStart, mulEnd) * multiply(node*2 + 1, mid+1, end, mulStart, mulEnd)) % MOD;
			}
		}
		
		public long update(int node, int index,int start, int end, int value) {
			if(index < start || end < index)
				return tree[node];
			
			if(start == end) {
				return tree[node] = value;
			}
			
			int mid = (start+end)/2;
			return tree[node] = (update(node*2, index, start, mid, value) * update(node*2 + 1, index, mid+1, end, value))%MOD;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree stree = new SegmentTree(N,arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i< M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			if(command == 1) {
				int index = Integer.parseInt(st.nextToken()) - 1;
				int value = Integer.parseInt(st.nextToken());
				stree.update(1, index, 0, N-1, value);
			}else {
				int mulStart = Integer.parseInt(st.nextToken()) - 1;
				int mulEnd = Integer.parseInt(st.nextToken()) - 1;
				sb.append(stree.multiply(1, 0, N-1, mulStart, mulEnd)).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
