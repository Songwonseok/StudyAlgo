package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110_더하기사이클 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();

		String left = first.length() == 1 ? new String("0" + first) : new String(first);
		int times = 0;

		while(true){
			int leftFirst = left.charAt(0) - '0';
			int leftSecond = left.charAt(1) - '0';

			String right = String.valueOf(leftFirst + leftSecond);

			left = new StringBuilder()
				.append(leftSecond)
				.append(right.charAt(right.length()-1))
				.toString();

			times++;

			if(Integer.parseInt(left) == Integer.parseInt(first)){
				break;
			}
		}

		System.out.println(times);

	}
}
