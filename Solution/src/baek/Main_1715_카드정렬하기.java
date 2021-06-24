package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(int i=0;i<N;i++){
			pq.add(Long.parseLong(br.readLine()));
		}

		int count = 0;

		while(pq.size() > 1){
			long firstCard = pq.poll();
			long secondCard = pq.poll();

			long shuffledCard = firstCard + secondCard;

			count += shuffledCard;
			pq.add(shuffledCard);
		}

		System.out.println(count);
	}
}
