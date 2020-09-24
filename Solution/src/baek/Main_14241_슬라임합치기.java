package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14241_슬라임합치기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int score = 0;
		
		while(pq.size()>1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			score += num1 * num2;
			pq.add(num1+num2);
		}
		
		System.out.println(score);
	}

}
