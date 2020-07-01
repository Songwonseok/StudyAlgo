package string2;

import java.io.*;
import java.util.*;

public class KMP {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_str.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++){
			String text=br.readLine();
			int len=text.length();
			
			String patn=br.readLine();
			int siz=patn.length();

			int[] skip=new int[siz];
			int i=0;
			int j=-1;
			skip[i]=-1;
			while(i<siz) {
				while(j>=0 && patn.charAt(i)!=patn.charAt(j)) {
					j=skip[j];
				}
				i++;
				if(i>=siz) break;
				j++;
				skip[i]=j;
			}
			//System.out.println(Arrays.toString(skip));
			
			int ans=-1;
			i=0;
			j=0;
			while(i<len) {
				while(j>=0 && text.charAt(i)!=patn.charAt(j)) {
					j=skip[j];
				}
				i++;
				if(i>=len) break;
				j++;
				if(j==siz) {
					ans=i-j;
					break;
				}
			}
			System.out.println("#"+tc+" "+(i-j));
		}
		br.close();
	}
}
