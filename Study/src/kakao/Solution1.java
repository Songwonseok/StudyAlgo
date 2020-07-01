package kakao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int level = 0;
		HashSet<Character> set = new HashSet<>();
		
		Pattern num = Pattern.compile("[0-9]");
		Pattern lower = Pattern.compile("[a-z]");
		Pattern upper = Pattern.compile("[A-Z]");
		
		if(input.length() >= 10)
			level++;	
		
		for(int i=0;i<input.length();i++) {
			if(set.size()== 4)
				break;
			
			Matcher m = num.matcher(input.substring(i, i+1));
			if(m.find()) {
				set.add('0');
				continue;
			}
			
			m = lower.matcher(input.substring(i, i+1));
			if(m.find()) {
				set.add('a');
				continue;
			}
			
			m = upper.matcher(input.substring(i, i+1));
			if(m.find()) {
				set.add('A');
				continue;
			}
			
			set.add('#');
		}
		
		level += set.size();
		
		
		System.out.println("LEVEL"+level);
	}

}
