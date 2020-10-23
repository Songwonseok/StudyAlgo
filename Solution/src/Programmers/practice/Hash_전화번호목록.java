package Programmers.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Hash_전화번호목록 {
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        for(int i=0;i<phone_book.length -1 ;i++){
            String curr = phone_book[i];
            for(int j=i+1;j<phone_book.length;j++){
                if(phone_book[j].substring(0,curr.length()).equals(curr)) 
                    return false;
            }
        }
        
        return answer;
    }
	public static void main(String[] args) {
		
	}

}
