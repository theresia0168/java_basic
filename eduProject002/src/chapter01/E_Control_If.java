package chapter01;

public class E_Control_If {

	public static void main(String[] args) {
		// 코드 블럭
		// : 코드들의 묶음 (여러 구문을 하나의 묶음(기능)으로 취급하는 것)
		// {}로 표현
		{	// ?1
			int a = 10;
			int b = 20;
			int result = a + b;
			System.out.println("a + b: " + result);
			
			// int a = 0; // 변수명이 중복되기 때문에 선언할 수 없다
		}
		
		int a = 0;	// 그러나 묶음의 밖에서는 새로이 선언될 수 있다
		
		{	// ?2
			// int a = 0;	
			// ?2는 main 메소드에 종속된 관계이다 
			// 따라서 main에서 a가 선언된 이후의 묶음인 ?2 내부에서는 중복된 변수를 선언할 수 없다
			int b = 0;	// 다른 묶음의 내부이기 때문에 int b는 위의 int b = 20;과 완전히 독립적인 변수이다
		}
		
		// 제어문: 조건에 따라서 코드의 흐름을 결정한다
		// 조건문: 특정 조건을 만족할 시 해당 코드 블럭을 실행한다
		// if-else: 주어진 조건문(논리표현식)이 true라면 코드 블럭을 실행, false라면 패스
		
		System.out.println("if문 시작");
		int number = 10;
		
		if(number > 10) {
			System.out.println("양수");
		}
		System.out.println("if문 종료");
		
		// else: if문의 조건식이 false일 때 코드 블럭을 실행한다
		// 주의!
		// 1. else는 반드시 if 이후에 와야한다
		// 2. else는 조건식을 작성하지 않는다
		
		System.out.println("if-else문 실행");
		number = 5;
		if(number > 0) {
			System.out.println("양수");
		}
		else {
			System.out.println("양수가 아님");
		}
		System.out.println("if-else문 종료");
		
		System.out.println("여러 조건 실행");
		if(number > 0) {
			System.out.println("양수");
		}
		else if(number < 0) {
				System.out.println("음수");
		}
		else {
			System.out.println("0");
		}
		System.out.println("여러 조건 종료");
		
		// 대한민국, 성인(age >= 19), 남성
		String nationality = "대한민국";
		int age = 23;
		String gender = "남성";
		
		if(nationality.equals("대한민국")) {	
			// 참조형 데이터 타입은 주소가 할당되므로 == 비교 연산자가 아닌 .equals() 메소드를 사용해야 한다
			if(age >= 19) {
				if(gender.equals("남성")) {
					System.out.println("현역");
				}
			}
		}
		System.out.println("종료");
		
		if(nationality.equals("대한민국") && age > 19 && gender.equals("남성")) {
			System.out.println("현역");
		}
		
		boolean isActive = nationality.equals("대한민국") && age > 19 && gender.equals("남성");
		if(isActive) {
			System.out.println("현역");
		}
	}

}
