import java.util.*;

class Solution {
	HashMap<String, Integer> map;


	public int[] solution(String today, String[] terms, String[] privacies) {
		map = new HashMap<String, Integer>();

		String[] todayYMD = today.split("\\.");

		int currDays = dateToDays(Integer.parseInt(todayYMD[0]), Integer.parseInt(todayYMD[1]), Integer.parseInt(todayYMD[2]));

		for(String term : terms) {
			String[] s = term.split(" ");

			map.put(s[0], Integer.parseInt(s[1]));
		}

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < privacies.length; i++) {
			String[] s = privacies[i].split(" ");

			String[] ymd = getExpireDate(s[0], s[1]).split("\\.");

			if(currDays > dateToDays(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]))) {
				answer.add(i + 1);
			}
		}


		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public int dateToDays(int year, int month, int day) {
		int days = 28 * 12 * (year - 1);
		days += 28 * (month - 1);
		days += day;

		return days;
	}

	public String getExpireDate(String date, String type) {
		String[] ymd = date.split("\\.");
		int period = map.get(type);

		int year = Integer.parseInt(ymd[0]);
		int month = Integer.parseInt(ymd[1]);
		int day = Integer.parseInt(ymd[2]);

		day--;
		month += period;

		if(day == 0) {
			month--;
			day = 28;
		}

		if(month == 0) {
			year--;
			month = 12;
		}

		if(month > 12) {
			year += month / 12;
			month %= 12;
		}

		return year + "." + month + "." + day;
	}
}
