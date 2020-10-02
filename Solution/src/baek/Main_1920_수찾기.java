package baek;

import java.io.*;
import java.util.*;

public class Main_1920_수찾기 {
    public static boolean findNum(int num, int[] nums){
        int left = 0;
        int right = nums.length - 1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == num)
                return true;
            else if(nums[mid] > num)
                right = mid - 1;
            else{
                left = mid + 1;
            }
        }
        return false;
    }

   public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(findNum(num, nums))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}