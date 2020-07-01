package string2;

import java.io.*;
import java.util.*;

public class BoyerMoore{
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_str.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			String text=br.readLine();
			int len=text.length();
			
			String patn=br.readLine();
			int siz=patn.length();

			int[] skip=new int[26];
			Arrays.fill(skip,siz);
			for(int i=0; i<siz; i++) {
				skip[patn.charAt(i)-'A']=siz-i-1;
			}
			
			int ans=-1;
	        int i=siz-1;
	        loop:while(i<len){
	        	int j=siz-1;
	            while(text.charAt(i)==patn.charAt(j)){
	                //처음 문자까지 일치했다면 탐색은 성공이다
	                if(j==0) { 
	                	ans=i;
	                	break loop;
	                }
	                i--; j--;
	            }
	            i=i+Math.max(skip[text.charAt(i)-'A'], siz-j);
	        }
			System.out.println("#"+tc+" "+ans);
		}
		br.close();
	}
}