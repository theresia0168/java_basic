package chapter01;

public class C_DataType {

	public static void main(String[] args) {
		// 기본형 (정수형, 실수형, 문자형, 논리형)
		// 정수형
		// byte: 1byte(8bit) 크기를 가지는 정수형 데이터 타입
		// -128 ~ +127
		byte byte01 = -100;
		// byte byte02 = 128; <--- byte형의 범위를 벗어나 Error 발생
		
		// short: 2byte(16bit) 크기를 가지는 정수형 데이터 타입
		// -32,768 ~ +32,767
		short short01 = 128;
		// short short02 = 32768; <--- short형의 범위를 벗어나 Error 발생
		
		// int: 4byte(32bit) 크기를 가지는 정수형 데이터 타입
		// -2,147,483,648 ~ +2,147,483,647
		int int01 = 32768;
		// int int02 = 2_200_000_000; 이전까지의 Error는 Type Missmatch Error였으나 
		// 						   	  리터럴 값의 int 범위 초과 Error가 발생한다
		//							  literal 상수 값 자체가 정수일 경우 int 형태로 저장된다
		//						   	  숫자 뒤에 l을 붙이면 Type Missmatch Error가 발생한다
		//							  _(언더바)를 이용하여 숫자의 자릿수를 표현할 수 있다
		
		// long: 8byte(64bit) 크기를 가지는 정수형 데이터 타입
		long long01 = 2_200_000_000L;
		
		// int 다음으로 많이 사용하는 것이 long
		// 이따금씩 천문학적 단위를 사용하는 영역들이 있기 때문
		
		// 실수형 : 실수부를 가지는 데이터 타입
		// float: 4byte(32bit) 크기를 가지는 실수형 데이터 타입
		// 소수점 6-7자리에서 오차가 발생
		float float01 = 0.123456789f;	// literal 상수 값 자체가 실수일 경우 double 형태로 저장된다
										// 따라서 long의 l과 같이 f를 붙여주어야 한다
		System.out.println(float01);
		// 실제로 출력되어야 하는 값은 0.123456789이나 자료형의 한계로 오차가 발생해 0.12345679가 출력된다
		
		// double: 8byte(64bit) 크기를 가지는 실수형 데이터 타입
		// 소수점 15-17자리에서 오차가 발생
		double double01 = 0.123456789;
		double double02 = 0.12345678912345678912345;
		System.out.println(double01);
		System.out.println(double02);
		// double01은 모든 값이 문제 없이 출력되었으나 double02는 소수점 아래 17번째 자리까지만 출력된다
		
		// 문자형 데이터 타입: 문자 하나를 저장할 수 있는 데이터 타입
		// char: 2byte(16bit) 크기를 가지는 문자형 데이터 타입
		// 0 ~ 65,535
		// 문자를 리터럴로 표현할 때는 ''로 묶어서 표현한다
		char char01 = 'A';			// 문자 표현
		char char02 = 65;			// ASCII 코드 표현
		char char03 = '\u0041';		// 유니코드 표현
		System.out.println(char01);
		System.out.println(char02);
		System.out.println(char03);
		
		// 논리형 데이터 타입: 참, 거짓 값을 가지는 데이터 타입
		// boolean: 1byte(8bit) 크기를 가지는 논리형 데이터 타입
		// true, false 값만 가질 수 있음
		boolean b01 = true;
		boolean b02 = false;
		System.out.println(b01);
		System.out.println(b02);
		
		// 형변환: 데이터 타입이 서로 다른 변수를 옮겨 담는 것
		// 자동 형변환: 작은 데이터 타입의 변수를 큰 데이터 타입의 변수에 옮겨 담을 때 발생
		// 강제 형변환: 큰 데이터 타입의 변수를 작은 데이터 타입의 변수에 옮겨 담을 때 발생
		int number01 = 300;
		long number02 = number01;
		number01 =(int)number02;	// 강제 형변환 시켜주지 않으면 Error가 발생하므로 강제 형변환 시켜준다
		
		byte number03 = (byte)number02;
		System.out.println(number03);
		
		double number04 = 3.1415;
		number01 = (int)number04;
		System.out.println(number01);
		
		number04 = number03;
		System.out.println(number04);	// 실수부가 포함되어 출력된다
	}

}
