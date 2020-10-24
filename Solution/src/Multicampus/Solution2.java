package Multicampus;

public class Solution2 {

	public static String lastLetters(String word) {
	    // Write your code here
        char last = word.charAt(word.length()-1);
        char lastSecond =  word.charAt(word.length()-2);
        String answer = last +" " + lastSecond;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
