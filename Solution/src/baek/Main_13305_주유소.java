package baek;

import java.util.*;
import java.io.*;

public class Main_13305_주유소 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		long[] distance = new long[N-1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			queue.add(Integer.parseInt(st.nextToken()));
		
		int min = queue.poll();
		long result = (long)min * distance[0];
		
		for(int i=1;i<N-1;i++) {
			min = Math.min(min, queue.poll());
			result += (long)min * distance[i];
		}
		
		System.out.println(result);
	}

}
