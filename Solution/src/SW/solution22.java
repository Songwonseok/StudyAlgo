package SW;
import java.util.*;

public class solution22 {
	public static int timeGet(String start, String end) {
		int t1 = Integer.parseInt(start.substring(0,2))*60 + Integer.parseInt(start.substring(3));
		int t2 = Integer.parseInt(end.substring(0,2))*60 + Integer.parseInt(end.substring(3));
		return (t2-t1);
	}
	
	public static String solution(String m, String[] musicinfos) {
	      String answer = "`(None)`";
	      m=m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
	      int max=-1;
	      
	      for(int i=0;i<musicinfos.length;i++) {
	    	  String[] s = musicinfos[i].split(",");
	    	  int time = timeGet(s[0],s[1]);
	    	  String music = "";
	    	  s[3]= s[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
	    	  int size = s[3].length();
	    	  for(int j=0;j<time;j++) {
	    		  music += s[3].charAt(j%size);
	    	  }
	    	  if(music.contains(m) && time > max){
	    		  answer = s[2];
	    		  max=time;
	    	  }
	      }
	      
	      return answer;
	  }
	public static void main(String[] args) {
		String m ="ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m,musicinfos));
	}

}
