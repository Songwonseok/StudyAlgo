package array1;

import java.util.Arrays;
import java.util.Scanner;

public class NextLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*int i = Integer.parseInt(sc.nextLine());
		//sc.nextLine();
		String s1 = sc.nextLine(); //next는 공백을 구분자로 해서 불러내는 것. nextLine은 한 줄씩 받아옴.
		String s2 = sc.nextLine();
		System.out.println(i + " ["+s1+"]["+s2+"]");*/
		
		String line = sc.nextLine();
		String[] sa = line.split(" ");
		System.out.println(Arrays.toString(sa));
		
		String s = sc.next();
		char[] ca = s.toCharArray();
		System.out.println(Arrays.toString(ca));
		}

}
