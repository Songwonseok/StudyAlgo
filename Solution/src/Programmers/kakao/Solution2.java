package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	static class Team{
		int vict;
		int win;
		int lose;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int teamCount = Integer.parseInt(br.readLine());
		HashMap<String,Team> map = new HashMap<>();
		
		for(int i = 0; i<teamCount*(teamCount-1); i++) {
			String line = br.readLine();
			String[] match  = line.split(" ");
			
			Team team1 = map.getOrDefault(match[0], new Team());
			Team team2 = map.getOrDefault(match[2], new Team());
			
			if(Integer.parseInt(match[1]) > Integer.parseInt(match[3]))
				team1.vict++;
			else 
				team2.vict++;
			
			team1.win += Integer.parseInt(match[1]);
			team2.win += Integer.parseInt(match[3]);
			
			team1.lose += Integer.parseInt(match[3]);
			team2.lose += Integer.parseInt(match[1]);
			
			map.put(match[0], team1);
			map.put(match[2], team2);
		}
		
		List<Map.Entry<String, Team>> list = new ArrayList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Team>>() {
            @Override
            public int compare(Map.Entry<String, Team> o1, Map.Entry<String, Team> o2) {
                if(o1.getValue().vict > o2.getValue().vict)
                	return -1;
                else if(o1.getValue().vict < o2.getValue().vict)
                	return 1;
                else {
                	int p1 = o1.getValue().win - o1.getValue().lose;
                	int p2 = o2.getValue().win - o2.getValue().lose;
                	
                	if(p1 > p2)
                		return -1;
                	else if(p1 < p2)
                		return 1;
                	else 
                		return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        
        for(Map.Entry<String, Team> r: list) {
        	System.out.println(r.getKey() +" " +r.getValue().vict +" "+ (r.getValue().win-r.getValue().lose));
        }
		
	}

}
