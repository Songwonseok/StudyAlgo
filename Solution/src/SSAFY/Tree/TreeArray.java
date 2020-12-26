package SSAFY.Tree;

import java.util.Arrays;

public class TreeArray {
	public static int N=13;
	public static char[] a;
	
	public static void preorder(int i) {
		if(i<=N && a[i] != 0) { //a[i] != '\u0000'
			System.out.print(a[i] + " ");
			preorder(2*i); //left
			preorder(2*i+1); //right
		}
	}
	public static void inorder(int i) {
		if(i<=N && a[i] != 0) { //a[i] != '\u0000'
			inorder(2*i);
			System.out.print(a[i] + " ");
			inorder(2*i+1);
		}
	}
	public static void postorder(int i) {
		if(i<=N && a[i] != 0) { //a[i] != '\u0000'
			postorder(2*i);
			postorder(2*i+1);
			System.out.print(a[i] + " ");
		}
	}
	public static void main(String[] args) {
		a=new char[N+1];
		for(int i=1;i<=N;i++) {
			a[i] = (char)('A'+(i-1));
		}
		//System.out.println(Arrays.toString(a));
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
	}

}
