package chapter03;

import java.util.ArrayList;

class ExamClass {
	int a;
	int b;
}

public class B_Package01 {

	public static void main(String[] args) {
		// Wrapper 클래스: 기본형 데이터 타입을 참조형 데이터 타입으로 다룰 수 있게 해주는 클래스
		// 일반적으로 기본형 데이터 타입의 풀네임에 첫 글자를 대문자로 쓴다
		// int > Integer
		int basicInt = 10;
		Integer wrapperInteger = null;
		wrapperInteger = basicInt;
		// Wrapper 클래스는 null을 가질 수 있기 때문에 기본형 데이터 타입에 참조형 데이터 타입을 할당할 때 주의해야 한다
		basicInt = wrapperInteger;
		System.out.println(basicInt);

		// double > Double
		double basicDouble = 1.0;
		Double wrapperDouble = 1.0;
		
		// boolean > Boolean
		boolean basicBoolean = false;
		Boolean wrapperBoolean = true;
		
		// Wrapper 클래스에서 자주 사용되는 기능
		// parse 메소드: 문자열을 특정 타입으로 변경
		double number = Double.parseDouble("10.11");
		System.out.println(number);
		// toString 메소드: 특정 타입을 문자열로 변경
		String string = Double.toString(number);
		System.out.println(string);
		string = wrapperDouble.toString();
		System.out.println(string);
		
		// Math 클래스: 수학 연산과 관련된 다양한 메소드 제공
		// 모든 메소드가 static인 클래스 메소드
		
		// ceil(): 올림 메소드
		// floor(): 내림 메소드
		// round(): 반올림 메소드
		System.out.println(Math.ceil(3.14));
		System.out.println(Math.floor(3.14));
		System.out.println(Math.round(3.14));
		
		// 소수점 자리에서 반올림
		System.out.println((double)Math.round(Math.PI*100)/100);
		
		// 정수 자리에서 반올림
		System.out.println(Math.round(98765/100.0)*100);
		
		ArrayList<ExamClass> list = new ArrayList<>();
		
		ExamClass exam01 = new ExamClass();
		ExamClass exam02 = new ExamClass();
		ExamClass samsung = new ExamClass();
		ExamClass apple = new ExamClass();
		
		list.add(exam01);
		list.add(exam02);
		list.add(samsung);
		list.add(apple);
	}

}
