package hm;

import java.util.*;

class Car{
	String plate;
	int odo;
	public Car(String plate, int odo) {
		super();
		this.plate = plate;
		this.odo = odo;
	}
	
}


class Solution2 {
    public static String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
        PriorityQueue<Car> que = new PriorityQueue<>(new Comparator<Car>() {
				@Override
				public int compare(Car o1, Car o2) {
                    if(o1.odo == o2.odo)
                        return o1.plate.compareTo(o2.plate);
					return Integer.compare(o1.odo, o2.odo);
				}
			});
	        for(int i=0;i<n;i++) {
	        	que.offer(new Car(plates[i],odo[i]));
	        }
	        
	    	for(int i=0;i<k;i++) {
	    		Car c = que.poll();
	    		c.odo += drives[i];
	    		que.offer(c);
	    	}
	    	String answer = que.peek().plate;
	        return answer;
	    }
	public static void main(String[] args) {
		
		int n=6, k=8;
		String[] plates = {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"};
		int[] odo = {20, 16, 18, 20, 24, 19};
		int[] drives = {3, 7, 5, 8, 6, 5, 10, 2};	
		
		System.out.println(solution(n,plates,odo,k,drives));
	}

}
