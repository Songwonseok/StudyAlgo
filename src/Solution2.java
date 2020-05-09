import java.util.Arrays;

public class Solution2 {
	static int result=0;
	static int[] ar;
	
	//기간, 물건개수, 연속된 길이,최대개수
	public static void solve(int r, int total, int length, int max) {
		if(r== ar.length ) {
			if(total==0) {
				result++;
			}
			return;
		}
		
		if(r<length-1) {
			if(total<max) {
				for(int i=0;i<=total;i++) {
					ar[r] = i;
					solve(r+1,total-i,length,max);
				}
			}else {
				for(int i=0;i<=max;i++) {
					ar[r] = i;
					solve(r+1,total-i,length,max);
				}
			}
		}else {
			int curmax= max;
			for(int i=1;i<length;i++) {
				curmax -=ar[r-i];
			}
			if(curmax <0)
				return;
			
			for(int i=0;i<=curmax;i++) {
				ar[r] = i;
				solve(r+1,total-i,length,max);
			}
		}
		
	}
	
	public static int solution(int N,int M,int T,int K) {
		int answer = -1;
		result =0;
		ar = new int[N];
		
		solve(0,M,T,K);
		
		
		answer=result;
		
		return answer;
	}
	public static void main(String[] args) {
		
		System.out.println(solution(2,4,1,3));
		
	}

}
