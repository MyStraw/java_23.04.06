package BaekJoon;

import java.time.LocalDate;
import java.time.ZoneId;

public class _10699_오늘날짜 {
	public static void main(String[] args) {
		//LocalDate now = LocalDate.now();
		LocalDate seoulnow = LocalDate.now(ZoneId.of("Asia/Seoul"));
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		//String formatedNow = now.format(formatter);
		
		
		//System.out.println(now);
		System.out.println(seoulnow);
		//System.out.println(formatedNow);
		
		
		//int year = now.getYear();
	//	int month = now.getMonthValue();
		//int day = now.getDayOfMonth();
		
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
		
	}

}
