package Codility;

public class Solution2 {
	static int visibleCount;

	public static int solution(Tree T) {
		if(T == null) {
			return 0;
		}

		visibleCount = 0;

		checkTree(T.x, T);

		return visibleCount;
	}

	public static void checkTree(int V, Tree T) {
		if(T == null) {
			return;
		}

		if(T.x >= V) {
			V = T.x;
			visibleCount++;
		}

		checkTree(V, T.l);
		checkTree(V, T.r);
	}

	public static void main(String[] args) {
		Tree t = new Tree(2);
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(1);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);

		t.l = t1;
		t.r = t2;
		t1.l = t3;
		t1.r = t4;

		System.out.println(solution(t4));

	}

	static class Tree {
		public int x;
		public Tree l;
		public Tree r;

		Tree(int x) {
			this.x = x;
			l = null;
			r = null;
		}
	}
}
