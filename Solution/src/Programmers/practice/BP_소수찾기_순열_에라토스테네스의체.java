package Programmers.practice;

public class BP_소수찾기_순열_에라토스테네스의체 {
	static boolean[] prime;
    static boolean[] v, permCheck;
    static int result;
    static char[] selected,perm, number;
    
    //소수 확인법
//    public boolean isPrime(int n){
//        if(n==0 || n==1) return false;
//        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//    
    
    static void permutation(int d, int end){
        if(d==end){
            if(perm.length == 0)
                return;
            
            String str = "";
            for(int i=0;i<perm.length;i++)
                str += perm[i];
            
            if(!prime[Integer.parseInt(str)]) {
            	prime[Integer.parseInt(str)] = true;
            	System.out.println(str);
            	result++;
            }
            return;
        }
        
        for(int i=0;i<selected.length;i++){
            if(!permCheck[i]){
                permCheck[i] = true;
                perm[d] = selected[i];
                permutation(d+1,end);
                permCheck[i] = false;
            }
        }
    }
    
    static void BP(int depth){
       
    	
    }
    
    public static int solution(String numbers) {
        int answer = 0;
        result =0;
        prime = new boolean[10000000];
        number = new char[numbers.length()];
        
        
        
        for(int i=0;i<number.length;i++)
            number[i] = numbers.charAt(i);
        
        v = new boolean[number.length];
        
        prime[0] = true;
        prime[1] = true;
        
        for(int i=2;i<Math.sqrt(prime.length);i++){
        	if(!prime[i]) {
        		for(int j=i*i;j<10000000;j+=i){
        			prime[j] = true;
        		}
        	}
            
        }
        BP(0);
        answer = result;
        return answer;
    }
	public static void main(String[] args) {
		String str = "011";
		System.out.println(solution(str));

	}

}
