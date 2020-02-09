package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1123{

    public static void main(String[] args) throws Exception{
     	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++){
        	int result =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<10;i++){
             	result += Integer.parseInt(st.nextToken());
            }
            
        
            
            
            System.out.println("#"+tc+" "+(result/10));
        }
        
    }
    
}
