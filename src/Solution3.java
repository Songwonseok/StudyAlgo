import java.util.*;

public class Solution3 {
	//요청시간 처리시간
	//HH:MM:SS.SSS S.SSS
	public static String solve(int numServer, String[] logs) {
		//round
		ArrayList<String>[] list = new ArrayList[numServer]; 
		for(int i=0;i<logs.length;i++) {
			list[i%numServer].add(logs[i]);
		}
		
		for(int i=0;i<numServer;i++) {
			String[] com = list[i].get(0).split(":");
			String[] time = com[0].split(":");
			double h = Integer.valueOf(time[0]);
			double m = Integer.valueOf(time[1]);
			double s = Double.valueOf(time[2]);
			
			for(int j=0;j<list[i].size();j++) {
				String[] temp = list[i].get(0).split(":");
				double ss = Double.valueOf(temp[1]);
				s += ss;
			}
			m += s/60;
			h += m/60;
			s = s%60;
		}
		
		
		//least
		Queue<String>[] que = new LinkedList[numServer]; 
		
		
		
		return null;
	}
	
	
	public static int[] solution(int numServer, String[] logs) {
		int[] answer = {};
		
		
		return answer;
	}
	
	public static void main(String[] args) {

	}

}
