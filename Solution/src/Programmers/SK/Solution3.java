package Programmers.SK;

/*
문자열 s가 주어집니다. s의 부분 문자열 중에서, "1씩 증가하는 수열"로 나눌 수 있는 가장 긴 부분 문자열의 길이를 구하려고합니다.

"1씩 증가하는 수열"의 조건

. [조건1] "1씩 증가하는 수열"에 포함된 모든 수들은 5자리 이하인 음이 아닌 정수여야합니다.(0~99999)
. [조건2] 0을 제외한 나머지 수는 0으로 시작할 수 없습니다. 즉 01, 010, 0234 등은 "1씩 증가하는 수열"에 포함될 수 없습니다.
. [조건3] 단 하나의 수로 구성된 수열은 "1씩 증가하는 수열"이라고 보지 않습니다. 최소 2개 이상의 수들이 1씩 증가하면서 나열할때, "1씩 증가하는 수열"이라고 정의합니다.

예시번호        s                               s의 부분 문자열            부분 문자열의 길이         "1씩 증가하는 수열"
1                   8234235238239240     234235236                     9                                  234, 235, 236
2                   123499100                  99100                            5                                  99, 100
3                   01020304                    01                                 2                                   0, 1
4                   999910000                  999910000                     9                                  9999,10000
5                   9999899999100000     9999899999                   10                                 99998, 99999
6                  99999100000               999910000                     9                                   9999,10000
7                   12356                         123                                3                                  1,2,3
8                   13579                           null                              0                                  없음 
9                    4                                 null                              0                                  없음


. 3번예시에서 01,02,03,04는 [조건2]에 의하여 수열에 포함될 수 없습니다. 하지만 0, 1은 수열에 포함될 수 있습니다.
. 5번 예시에서 100000은 [조건1]에 의하여 수열에 포함될 수 없습니다.
. 6번 예시에서 99999는 5자리 숫자이지만, 100000는 6자리 숫자입니다. 따라서 [조건1]에 의해 
  99999와 100000로는 수열을 만들 수 없습니다. 하지만 9999와 10000는 모두 5자리 이하의 숫자이므로 수열을 만들 수 있습니다.

문자열 s가 매개변수로 주어졌을 때, 1씩 증가하는 수열로 나눌 수 있는 가장 긴 부분 문자열의 길이를 return 하도록 solution 함수를 완성해주세요

제한 사항 
. 문자열 s의 길이는 1이상 500,000 이하입니다.
. 문자열 s는 0부터 9까지의 숫자들로만 구성되어 있습니다.
 */

public class Solution3 {
public static int getLength(int start, int length, String str){
	int prev = -1;
    int cnt = 0;
    int size = length;
    
    for(int i=start;i<str.length();i+=length){
    	if(size != length)
    		length = size;
    	
        if(i+size > str.length()) return cnt;
        
        int num = Integer.valueOf(str.substring(i, i+size));
        if(str.charAt(i) == '0' && length > 1) return cnt;
        if(prev == -1){
            prev = num;
            if(num == 9 || num == 99 || num == 999 || num == 9999 || num == 99999){
            	size++;
            	if(size == 6) return cnt;
            }
            continue;
        }
        
        if(prev +1 == num){
            cnt = i+size - start;
        }else{
            return cnt;
        }
        
        if(num == 9 || num == 99 || num == 999 || num == 9999 || num == 99999){
        	size++;
        	if(size == 6) return cnt;
        }
        prev = num;
    }
    
    return cnt;
    }
	public static int solution(String str) {
		int answer = 0;
        for(int idx = 0;idx<str.length();idx++){
            for(int length = 1;length<=5;length++){
                answer = Math.max(answer, getLength(idx, length, str));
            } 
        }      
		return answer;
	}
	public static void main(String[] args) {
		String[] str = {"8234235238239240", "123499100", "01020304", "999910000","9999899999100000","99999100000", "12356", "13579", "4"};
		for(String s : str)
			System.out.println(solution(s));
	}

}
