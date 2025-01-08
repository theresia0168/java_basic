package chapter03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class D_Package03 {

	public static void main(String[] args) {
		// Date 클래스: 날짜를 다루는 클래스
		// Date 클래스의 대부분의 메소드는 Java 1.1부터 사용하지 않도록 권장
		// Date 클래스가 날짜의 데이터 타입으로 자주 사용됨 (실제 날짜를 관리할 때는 문자열이 편함)
		Date dateNow = new Date();
		System.out.println(dateNow);
		System.out.println(dateNow.getDate());	// getDate에 취소선이 그이는 이유는 deprecated 되었기 때문
		
		// LocalDateTime 클래스: Date 클래스를 대체하기 위해 사용되는 클래스
		// LocalDate 클래스, LocalTime 클래스, LocalDateTime 클래스
		LocalDateTime dateStatus = LocalDateTime.now();
		LocalDate nowDate = LocalDate.now();
		System.out.println(dateStatus);
		System.out.println(nowDate);
		
		// 특정 시간 및 날짜의 인스턴스 생성
		LocalDateTime date1 = LocalDateTime.of(2025, 1, 5, 16, 30 ,0);
		System.out.println(date1);

		LocalDateTime now = LocalDateTime.now();
		
		// 특정 날짜 및 시간의 요소 불러오기
		// .getXXX()
		int month = now.getMonthValue();
		System.out.println(month);
		int day = now.getDayOfMonth();
		System.out.println(day);
		
		// 특정 날짜 및 시간의 요소 변경하기
		// .withXXX()
		// 인스턴스가 직접 변경되는 것이 아니고 변경된 인스턴스를 생성하여 반환
		System.out.println(now.withYear(2020));
		
		// 날짜 및 시간 계산하기
		// plusXXX(), minusXXX()
		// 인스턴스가 직접 변경되지 않고 변경된 인스턴스를 생성하여 반환
		now = now.plusHours(18).minusMinutes(20);
		System.out.println(now);
		
		// LocalDateTime을 Date로 변경
		// Date 클래스의 from 메소드와 LocalDateTime 인스턴스의 toInstant라는 메소드를 활용
		Date localToDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(localToDate);
		
		// Date를 LocalDateTime으로 변경
		// Date 인스턴스의 toInstant, toLocalDateTime 메소드 사용
		LocalDateTime dateToLocal = dateNow.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(dateToLocal);
		
		// Date를 String으로 변경
		// SimpleDateFormat 클래스를 사용하여 지정한 문자열 포멧으로 변경 가능
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		String stringDate = simpleDateFormat.format(localToDate);
		System.out.println(stringDate);
		
		// y: 연도, M: 월, d: 일, a: 오전/오후, H: 시간(24), h: 시간(12), m: 분, s: 초, E: 요일
		// 오후 5:14 2025-01-06
		simpleDateFormat = new SimpleDateFormat("a hh:mm yyyy-MM-dd");
		stringDate = simpleDateFormat.format(new Date());
		System.out.println(stringDate);
		
		// LocalDateTime을 String으로 변경
		// DateTimeFormatter 클래스를 이용해서 변경 가능
		stringDate = now.format(DateTimeFormatter.ofPattern("a hh:mm yyyy-MM-dd"));
		System.out.println(stringDate);
	}

}
