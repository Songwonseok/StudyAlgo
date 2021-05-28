package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2753_윤년 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int years = Integer.parseInt(br.readLine());

		if(years % 400 == 0 || (years % 4 == 0 && years % 100 != 0)){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}
}
