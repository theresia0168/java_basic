package chapter01;

public class A_Variable01 {

	public static void main(String[] args) {
		// 변수 (variable)
		// 데이터를 메모리에 저장하기 위해 사용되는 공간 요소
		// 변수를 생성(선언)할 때 반드시 해당 변수가 가질 수 있는 데이터의 형태를 지정해야한다
		
		// 선언(생성) 방법
		// DataType(자료형) 변수명;
		int number1;
		
		// 초기화(초기 값을 할당하는 행위) 방법
		// 변수명 = 데이터;
		number1 = 22;
		
		// 선언과 동시에 초기화하는 방법
		// 자료형 변수명 = 데이터;
		int number2 = 30;
		
		System.out.println(number1);
		System.out.println(number2);
		
		// 변수는 선언 후 반드시 초기화한 다음 사용할 수 있음
		// int number3;
		// System.out.println(number3);
		// The local variable number3 may not have been initialized
		
		// 변수에 지정된 타입의 데이터가 아니면 할당이 불가능
		// int number3 = 3.14;
		
		// 변수에 처음 데이터를 넣는 행위가 아니기 때문에 초기화가 아니다
		// 할당 또는 재할당으로 지칭한다
		number1 = 400;
		
		// 변수의 사용 목적
		// 1. 데이터 저장 목적
		// 2. 변할 수 있는 데이터에 대해서 이름을 부여하는 목적
		
		
		/* 변수 명명 규칙
		 * 
		 * 1. 중복된 변수명 사용 불가능
		 * 변수의 자료형이 다르더라도 같은 변수명을 사용할 수 없음
		 * int number4;
		 * double number4;
		 * int Number4; <--- 대소문자는 구문을 하기 때문에 서로 다른 변수로 인식함
		 * 
		 * 2. 연산자로 사용되는 특수문자는 포함될 수 없음
		 * int number+()*&; 등등...
		 * int number_$; <--- 이 경우만 가능
		 * 
		 * 3. 변수명은 숫자로 시작할 수 없음
		 * int 1number;
		 * 숫자를 읽게 되면 일반 데이터로 읽으려고 시도함
		 * 그 뒤에 문자가 오게 될 시 Syntax Error가 발생
		 * 
		 * 4. 키워드로만 구성되어 있는 단어는 사용 불가능
		 * int public;
		 * int true;
		 * int public12; <--- 다른 문자가 붙게 될 경우 가능
		 */
		
		/* 비문법상 규칙 (암묵적 규칙)
		 * 1. 띄어쓰기 규칙
		 * String home address; 
		 * - Camel Case: 띄어쓰기를 표현할 때 띄어쓰기를 제거하고 바로 뒤 문자를 대문자로 표현하는 방식
		 * String homeAddress;
		 * - Snake Case: 띄어쓰기를 표현할 때 띄어쓰기 자리에 _로 표현하는 방식
		 * String home_address;
		 * - Upper: 대문자 표현
		 * - Lower: 소문자 표현
		 * UpperCamelCase: 첫 글자를 대문자로 표현하며 Camel Case를 사용 > 클래스, 인터페이스, etc...
		 * lowerCamelCase: 첫 글자를 소문자로 표현하며 Camel Case를 사용 > 변수, 함수, 메서드, etc...
		 * UPPER_SNAKE_CASE: 모든 글자를 대문자로 작성 > 상수형 변수
		 * lower_snake_case: 모든 글자를 소문자로 작성 > 변수, 함수, 메서드, etc... <--- 스크립트 언어에서 주로 사용
		 * 
		 * 2. 약어 사용 금지
		 * 본인만 알고 있는 약어를 사용할 시 타인이 이해하기 어렵기 때문
		 * 독일식 표기법을 사용하여 변수명 작성을 권장
		 * int subtractYesterdaysDateTodaysResults = 0;
		 */
		
		// 상수 선언, 초기화
		final int MY_CONSTANT = 100;
		// 초기화가 이루어지면 변경이 불가능한 변수
		// 변수 선언 시에 데이터 타입 앞에 final 키워드를 붙여서 선언 
		// 이미 선언, 초기화된 변수에 재할당하려고 하면 Error가 발생한다
		
		// 1. 리터럴에 이름을 부여하기 위해 많이 사용됨
		// 리터럴으로만 표현 한다면 해당하는 리터럴이 무엇인지 이해하기 어렵다
		// double result = 77.6 * 163;
		final double I_PHONE_16_PRO_MAX_WIDTH = 77.6;
		final double I_PHONE_16_PRO_MAX_HEIGHT = 163.0;
		double iPhone16ProMaxArea = I_PHONE_16_PRO_MAX_WIDTH * I_PHONE_16_PRO_MAX_HEIGHT;
		
		// 2. 데이터를 보호하기 위한 목적
		final int INPUT_NUMBER = 8;
		
		int age = 32; // 이러한 구문에서 '32'라는 데이터가 리터럴에 해당
	}

}
