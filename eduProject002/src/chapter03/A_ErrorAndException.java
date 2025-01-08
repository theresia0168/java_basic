package chapter03;

import java.util.InputMismatchException;
import java.util.Scanner;

// Error: 주로 프로그램에서 복구할 수 없는 심각한 문제
// 자원 부족이 큰 원인을 차지함
// 개발자가 대처할 수 없는 수준

// 컴파일 에러: 소스 코드의 문법을 준수하지 않았을 시 발생
// 1. 문법 오류: 괄호, 세미콜론 등의 잘못된 사용
// 2. 타입 불일치: 변수의 타입이나 메소드의 반환 타입이 일치하지 않을 시 발생
// 3. 미선언 변수: 선언하지 않은 변수나 메소드, 클래스를 사용하려 할 때 발생

// 런타임 에러: 프로그램 실행 중에 발생
// 1. 외부 서비스와의 연결 실패
// 2. 라이브러리 버전 불일치

// 예외: 프로그램이 정상적으로 실행 중인 상태에서 발생할 수있는 예상치 못한 상항
// 에러는 발생시 프로그램 실행 자체가 불가능하나 예외는 정상적으로 실행된 상태에서 발생
// 개발자가 직접 처리 및 예방 가능

public class A_ErrorAndException {
	
	// throws: 메소드의 호출부에 예외 처리에 대한 강제성을 부여
	public static void exceptionMethod() throws NullPointerException{
		// throw: 강제로 예외를 발생시키는 키워드
		// throw new 예외클래스("메세지")
		throw new NullPointerException("Exception!!");
	}

	public static void main(String[] args) {
		// 예외 처리 방법
		// try-catch 구문을 사용하여 처리 가능 (if-else문과 유사)
		
		// try { 예외가 발생할 수 있는 구문 }
		// catch(예외클래스 변수) { 특정 예외 발생 시 실행되는 구문 }
		
		Scanner scanner = new Scanner(System.in);
		
		try {	// try문은 자원 소모를 굉장히 많이하여 코드의 효율을 떨어뜨린다
			// 예외 발생 가능 위치
			System.out.print("First number: ");
			double first = scanner.nextDouble();
			
			// 예외 발생 가능 위치
			System.out.print("Second number: ");
			double second = scanner.nextDouble();
			
			double addingResult = first + second;
			double subResult = first - second;
			double multiResult = first * second;
			double divResult = first / second;
			
			System.out.println("Add: " + addingResult);
			System.out.println("Sub: " + subResult);
			System.out.println("Mulit: " + multiResult);
			System.out.println("Div: " + divResult);
		}	catch(Exception exception) {
			exception.printStackTrace();	// 예외 내용 출력
			System.out.println("Please enter the number only.");
		}	finally {
			// finally: 예외 발생 여부와 무관하게 실행하는 코드
			// 대부분 자원 반납을 명시할 때 사용된다
			scanner.close();
			System.out.println("Scanner Close.");
		}

		try {
			exceptionMethod();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		System.out.println("Calculating Complete");
	}

}
