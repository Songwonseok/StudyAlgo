package baek;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class abc {
	private static final String EVENT_ID_PREFIX = "friday_";
	private static final DateTimeFormatter EVENT_YMD_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

	public static void main(String[] args) {
		LocalDateTime lastFriday = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

		System.out.println(lastFriday.format(EVENT_YMD_FORMATTER));
	}

	public static List<String> call(List<Method> methods, aParam param) {
		return methods.stream().map(m -> {
			try{
				return m.process(param);
			}catch (Exception e) {
				return "EMPTY";
			}
		}).collect(Collectors.toList());
	}

	interface Method {
		String process(aParam param);
	}

	private static String getEventId() {
		LocalDateTime lastFriday = LocalDateTime.of(2023, 2, 23, 22, 10, 10).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

		return EVENT_ID_PREFIX + lastFriday.format(EVENT_YMD_FORMATTER);
	}
}