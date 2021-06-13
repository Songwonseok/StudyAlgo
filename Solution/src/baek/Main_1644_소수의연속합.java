package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1644_소수의연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());

		if(number == 1){
			System.out.println(0);
			return;
		}

		ArrayList<Integer> primeList = new ArrayList<>();
		boolean[] eratosthenes = new boolean[number+1];

		for(int i=2;i<= Math.sqrt(number); i++){
			if(!eratosthenes[i]){
				for(int j = i * 2; j <= number; j += i){
					eratosthenes[j] = true;
				}
			}
		}

		for(int i=2;i<=number;i++){
			if(!eratosthenes[i]){
				primeList.add(i);
			}
		}

		int left = 0;
		int right = 0;
		int answer = 0;

		int sum = primeList.get(0);

		while(left <= right){
			if(sum < number){
				if(right+1 == primeList.size()){
					break;
				}

				sum += primeList.get(++right);
			}else {
				if(sum == number){
					answer++;
				}
				sum -= primeList.get(left++);

			}
		}

		System.out.println(answer);
	}
}
