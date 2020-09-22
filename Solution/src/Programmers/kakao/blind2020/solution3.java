package Programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Arrays;

public class solution3 {
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx = 0;
        ArrayList<String[]> list = new ArrayList();
        for(String s : info) {
        	String[] sArr = s.split(" ");
        	list.add(sArr);
        }
        
        for(String s : query) {
        	int count = 0;
        	
        	String[] qArr = s.replaceAll(" and","").split(" ");
        	for(int i=0;i<list.size();i++) {
        		String[] applicant = list.get(i);
        		if(Integer.parseInt(applicant[4]) >= Integer.parseInt(qArr[4])) {
					count++;
				}
        		if(qArr[0].equals("-") || applicant[0].equals(qArr[0])) {
        			if(qArr[1].equals("-") || applicant[1].equals(qArr[1])) {
        				if(qArr[2].equals("-") || applicant[2].equals(qArr[2])) {
        					if(qArr[3].equals("-") || applicant[3].equals(qArr[3])) {
        						if(Integer.parseInt(applicant[4]) >= Integer.parseInt(qArr[4])) {
        							count++;
        						}
        					}
        				}
        			}
        		}
        	}
        	
        	answer[idx++] = count;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		System.out.println(Arrays.toString(solution(info,query)));
		
	}

}
