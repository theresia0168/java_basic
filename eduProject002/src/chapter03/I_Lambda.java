package chapter03;

// 함수형 인터페이스: 추상 메소드가 하나만 존재하는 인터페이스
interface TriangleArea {
	double triangleArea(double height, double bottom);
}

public class I_Lambda {

	// 람다식: Java에서 함수형 프로그래밍을 지원하기 위한 함수 표현식
	// 메소드를 선언해서 사용하는 것이 아닌 익명의 일회성 함수를 사용하는 방법
	
	// 일반적인 메소드 선언의 단점
	// 1. 한 번 사용할 목적의 함수라고 하더라도 반드시 선언해서 사용해야하는 불편함이 있다
	// 2. 변수에 할당하여 사용할 수 없다
	
	static double triangleArea(double height, double bottom) {
		return height * bottom / 2;
	}
	
	public static void main(String[] args) {
		
		// 람다식 사용 방법
		// (매개변수, ... ) -> { 구현부 }
		// 람다식에서는 반환타입을 지정하지 않음
		// 람다식을 사용할 시 반환타입을 컴파일러가 추론하기 때문
//		(double height, double bottom) -> {
//			return height * bottom / 2;
//		}
//		
//		// 람다식에서는 매개변수의 타입도 생략 가능
//		(height, bottom) -> {
//			return height * bottom / 2;
//		}
		
		// 람다식의 구현부가 표현식(단순 반환 코드 한 줄)만 존재할 시 중괄호, return도 생략 가능
//		(height, bottom) -> height * bottom / 2;
		
		// 람다식은 변수에 할당할 수 있다
		// 리터럴처럼 활용 가능
		// 해당 변수의 데이터 타입은 함수형 인터페이스여야 한다
		
		TriangleArea lambda = (height, bottom) -> height * bottom / 2;
		System.out.println(lambda.triangleArea(1, 2));
		
		// 매개변수로 람다식 전달
		// 특정 메소드의 기능(동작)을 호출부에서 결정할 수 있다
		method((a, b) -> a + b);
		method(lambda);
		
	}
	
	static void method(TriangleArea lambda) {
		double result = lambda.triangleArea(10, 5);
		System.out.println(result);
	}

}
