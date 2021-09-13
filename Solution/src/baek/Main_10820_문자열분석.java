package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10820_문자열분석 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		StringBuilder sb = new StringBuilder();

		while((input = br.readLine()) != null){
			int[] count = new int[4];

			for(int i=0;i<input.length();i++){
				char c = input.charAt(i);

				if(c >= 'a' && c <= 'z'){
					count[0]++;
				}else if(c >= 'A' && c <= 'Z'){
					count[1]++;
				}else if(c >= '0' && c <= '9'){
					count[2]++;
				}else{
					count[3]++;
				}
			}

			sb.append(count[0]).append(" ")
				.append(count[1]).append(" ")
				.append(count[2]).append(" ")
				.append(count[3]).append(" ")
				.append("\n");
		}

		System.out.println(sb);
	}
}
