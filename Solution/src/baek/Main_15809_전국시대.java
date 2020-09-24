package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15809_전국시대 {
	static int N;
	static int[] power;
	static int[] nations;
	
	public static int find(int num) {
		if(nations[num] == num)
			return num;
		return find(nations[num]);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nations = new int[N+1];
		power = new int[N+1];
		for(int i=1;i<=N;i++) {
			nations[i] = i;
			power[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			int P = find(Integer.parseInt(st.nextToken()));
			int Q = find(Integer.parseInt(st.nextToken()));
			
			if(O == 1) {
				nations[Q] = P;
				power[P] += power[Q];
				power[Q] = 0;
			}else {
				int result = 0;
				if(power[P] > power[Q]) {
					result = power[P] - power[Q];
					nations[Q] = P;
					power[Q] = 0;
					power[P] = result;
				}else{
					result = power[Q] - power[P];
					nations[P] = Q;
					power[P] = 0;
					power[Q] = result;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(power[i] != 0) {
				list.add(power[i]);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int n : list) {
			System.out.print(n+" ");
		}
	}

}
