import java.util.Calendar;
import java.util.Date;

public class GetDay {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 1 && (year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0)
			System.out.println(29 + " days");

		else
			System.out.println(days[month] + " days");
	}
}