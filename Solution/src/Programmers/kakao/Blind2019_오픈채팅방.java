package Programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class Blind2019_오픈채팅방 {

		
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        
        for(int i=0; i<record.length;i++) {
        	String[] command = record[i].split(" ");
        	if(command[0].equals("Enter")) {
        		list.add(new String[] {command[1], "님이 들어왔습니다."});
        		map.put(command[1], command[2]);
        	}else if(command[0].equals("Leave")) {
        		list.add(new String[] {command[1], "님이 나갔습니다."});
        	}else {
        		map.put(command[1], command[2]);
        	}
        }
        
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
        	answer[i] = map.get(list.get(i)[0])+list.get(i)[1];
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
	}	

}
