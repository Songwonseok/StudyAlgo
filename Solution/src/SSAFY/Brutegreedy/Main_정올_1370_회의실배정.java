package SSAFY.Brutegreedy;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_정올_1370_회의실배정{
	public static class Meeting implements Comparable<Meeting>{
		private int num;
		private int start;
		private int end;
		
		Meeting(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(end, o.end); //end를 기준으로 오름차순 정렬
		}

	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1370.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Meeting[] m = new Meeting[N];
		for(int i=0;i<N;i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(m); //compareTo를 기준으로 정렬.
		System.out.println(Arrays.toString(m));
		
		List<Meeting> li = new ArrayList<>();
		li.add(m[0]);
		for(int i=1;i<m.length;i++) {
			if(li.get(li.size()-1).end<=m[i].start) li.add(m[i]);
		}
		System.out.println(li.size());
		for (Meeting meet:li) System.out.print(meet.num+" ");
	}

}
