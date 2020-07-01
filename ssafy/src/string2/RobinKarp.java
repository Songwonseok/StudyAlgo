package string2;

import java.io.*;
import java.util.*;

public class RobinKarp{
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_str.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			int code=0;
			String text=br.readLine();
			int len=text.length();
			int[] ta=new int[len];
			for(int i=0; i<len; i++){
				ta[i]=text.charAt(i)-'A';
			}
			
			int hash=0;
			String patn=br.readLine();
			int siz=patn.length();
			int[] pa=new int[siz];
			for(int i=0; i<siz; i++){
				pa[i]=patn.charAt(i)-'A';
				hash+=pa[i];
			}
			
			int ans=-1;
			for(int i=0; i<len-siz; i++) {
				if(i==0){
					for(int j=i; j<siz; j++) {
						code+=ta[j];
					}
				}else{
					code+=ta[i+siz-1];
				}
				if(hash==code) {
					if(patn.equals(text.substring(i,i+siz))) {
						ans=i;
						break;
					}
				}
				code-=ta[i];
			}
			System.out.println("#"+tc+" "+ans);
		}
		br.close();
	}
}