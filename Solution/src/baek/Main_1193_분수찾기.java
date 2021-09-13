package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1193_분수찾기{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int n = 1;
		int count = 0;

		int offset = 0;

		for(int i= 1; i<= X; i++) {
			int range = i * (i+1) / 2;

			if(range >= X) {
				n = i;
				count = offset + 1;
				break;
			}
			offset = range;
		}

		int min = 1;
		int max = n;

		while(count != X){
			max--;
			min++;
			count++;
		}

		if(n % 2 == 0){
			System.out.println(min + "/" + max);
		}else {
			System.out.println(max + "/" + min);
		}
	}
}
