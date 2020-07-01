package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalTest {
	public static int N=7;
	public static List<int[]> v;
	public static int[] p;
	
	public static int findSet(int x) {
		if(p[x]==x) return x;
		else return p[x]=findSet(p[x]);
	}
	
	public static void union(int a, int b) {
		a=findSet(a);
		b=findSet(b);
		p[b]=a;
		
	}
	
	public static int kruskal() {
		Collections.sort(v, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int[] e:v) System.out.println(Arrays.toString(e));
		
		p = new int[N+1]; //makeset을 얘로 대신한다.
		for(int i=0;i<N+1;i++) p[i]=i;
		
		int sum=0;
		for(int i=0;i<v.size();i++) {
			if(findSet(v.get(i)[0])!=findSet(v.get(i)[1])) { //이쪽 부모와 저쪽 부모가 다르면
				System.out.println("->"+Arrays.toString(v.get(i)));
				sum+=v.get(i)[2]; //가중치를 더하고
				union(v.get(i)[0], v.get(i)[1]);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {	
		v = new ArrayList<>();
		v.add(new int[]{1,7,12});
		v.add(new int[]{1,4,28});
		v.add(new int[]{1,2,67});
		v.add(new int[]{1,5,17});
		v.add(new int[]{2,4,24});
		v.add(new int[]{2,5,62});
		v.add(new int[]{3,5,20});
		v.add(new int[]{3,6,37});
		v.add(new int[]{4,7,13});
		v.add(new int[]{5,6,45});
		v.add(new int[]{5,7,73});
		System.out.println(kruskal());

	}

}
