import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

public class TestClass {
	public static void main(String[] args) {
		Timestamp t = Timestamp.valueOf("2021-05-17 23:23:32.914468");
		
		LocalDateTime local = 
				LocalDateTime.ofInstant(t.toInstant(), ZoneId.systemDefault());
		
		String st = local.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
		
		int y = t.toLocalDateTime().toLocalDate().getYear();
		int M = t.toLocalDateTime().toLocalDate().getMonthValue();
		int d = t.toLocalDateTime().toLocalDate().getDayOfMonth();
		int h = t.toLocalDateTime().toLocalTime().getHour();
		int m = t.toLocalDateTime().toLocalTime().getMinute();
		int s = t.toLocalDateTime().toLocalTime().getSecond();
		
		
		System.out.println(st);
	}
}
