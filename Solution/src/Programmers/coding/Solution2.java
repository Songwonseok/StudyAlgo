package Programmers.coding;
import java.util.*;
/*
다음과 같은 배열을 가진 두 수열 s1, s2가 있습니다.
. s1, s2는 자연수로 된 수열입니다.
. s1을 구성하는 숫자들의 위치를 뒤바꾸어 수열 s2를 만들 수 있습니다.

다음은 수열 s1, s2의 예시입니다.
. s1 = [1,1,3,3,3,6]
. s2 = [6,3,1,3,1,3]

이때 수열에 있는 자연수 중 하나를 선택한 후, 각 수열에서 선택한 숫자들의 위치가 모두 같아지도록
이동시켜려합니다.
숫자를 이동시킬때는 서로 붙어있는 숫자끼리 교환하는 방식을 이용합니다.

다음은 s1과 s2를 구성하는 숫자의 위치 이용하는 예시입니다.

. s1 = [1,1,3,3,3,6] => [1,3,1,3,3,6] => [1,3,3,1,3,6] => [3,1,3,1,3,6]
. s2 = [6,3,1,3,1,3] => [6,3,1,1,3,3] => [6,1,3,1,3,3]
이때 아래와 같이 두 수열 s1, s2에서 숫자 1의 위치가 모두 같아졌음을 확인할 수 있습니다.
따라서 s1,s2에서 숫자 1의 위치가 모두 같아지도록 하려면 숫자들을 적어도 5번 이동해야합니다. 
s1,s2 중 언디에 있는 숫자를 움직이던 관계없으며, 숫자를 움직여 특정 숫자의 위치가 모두 같아지만 하면됩니다.

만약 숫자 3의 위치가 모두 같아지도록 한다면 다음과 같이 숫자들을 적어도 2번 이동해야합니다.
. s1 = [1,1,3,3,3,6] => [1,3,1,3,3,6]
. s2 = [6,3,1,3,1,3] => [6,3,1,3,3,1]

이때 숫자 3의 위치가 다음과 같이 같아졌습니다.

제한 사항
. s1의 길이는 1이상 500,000 이하입니다.
. s2의 길이는 s1과 같습니다.
. s1과 s2의 원소는 1이상 10,000이하인 자연수입니다.
. 정답이 존재하지 않는 경우의 입력은 주어지지 않습니다.
. 정답 배열은 [선택한 숫자, 이동 횟수의 최소값] 순으로 담아 return해주세요.
. 만약 이동 횟수가 최소인 숫자가 여러개라면 그중 가장 작은 수를 담으면 됩니다.

입출력 예

s1                           s2                            result
[1,1,3,3,6]              [6,3,1,3,1,3]             [3, 2]
[9,3,7,7,5,5,3,3]      [3,3,5,7, 5,7,3,9]      [5, 3]
[4,8,8,2]                 [2,8,8,4]                  [8, 0]

 */

public class Solution2 {
	public static int[] solution(int[] s1, int[] s2) {
		HashMap<Integer, ArrayList<Integer>> map1 = new HashMap();
        HashMap<Integer, ArrayList<Integer>> map2 = new HashMap();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0;i<s1.length;i++){
            if(!map1.containsKey(s1[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map1.put(s1[i], list);
                numbers.add(s1[i]);
            }else{
                map1.get(s1[i]).add(i);
            }
            
            if(!map2.containsKey(s2[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map2.put(s2[i], list);
                numbers.add(s2[i]);
            }else{
                map2.get(s2[i]).add(i);
            }
            
        }
        int minNum = Integer.MAX_VALUE;
        int minCnt = Integer.MAX_VALUE;
        
        for(int num : numbers){
            int cnt =0;
            ArrayList<Integer> list1 = map1.get(num);
            ArrayList<Integer> list2 = map2.get(num);
            
            for(int i=0;i<list1.size();i++){
                cnt += Math.abs(list1.get(i) - list2.get(i));
            }
            if(cnt < minCnt){
                minNum = num;
                minCnt = cnt;
            } else if (cnt == minCnt){
                if(num < minNum)
                    minNum = num;
            }
        }
		
        int[] answer = {minNum, minCnt};
        
        
		return answer;
	}
	public static void main(String[] args) {
		int[] s1 = {4,8,8,2};
		int[] s2 = {2,8,8,4};
		System.out.println(Arrays.toString(solution(s1,s2)));
	}

}
