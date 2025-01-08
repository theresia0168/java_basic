package chapter02;

// Overloading(오버로딩): 같은 클래스 내부에서 같은 이름의 메소드를 여러개 작성할 수 있도록 하는 방법론
// 오버로딩 조건
// 1. 메소드의 이름을 중복해서 작성하고 매개변수타입의 조합(개수, 타입 순서)을 다르게 작성한다
// 2. 메소드의 반환타입과 매개변수의 이름은 영향을 주지 않음

class NewMath {
	int add(int a, int b) {
		return a + b;
	}
	
	// 오버로딩: 매개변수의 타입을 다르게 한 경우
	double add(double a, double b) {
		return a + b;
	}
	
	// 오버로딩: 매개변수의 개수를 다르게 한 경우
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// 오버로딩: 매개변수 타입의 조합을 다르게 한 경우
	double add(int a, double b) {
		return a + b;
	}
	
	// 문제점
	// 1. 메소드의 이름이 불규칙적이다
	// 2. 사용 시에 불편함을 초래함 (무슨 목적으로 사용하는 것인지 직관적으로 알 수 없음)
	double add2(double a, double b) {
		return a + b;
	}
	
	// 중복된 메소드로 취급하여 Error 발생
	// 반환 타입만 다를 때는 같은 메소드로 취급
//	double add(int a, int b) {
//		return a + b;
//	}
	
	// 매개변수의 이름만 다른 것은 중복된 메소드로 취급하여 Error 발생
	// 매개변수의 이름만 다를 때는 오버로딩 불가능
//	int add(int x, int y) {
//		return x + y;
//	}
}

public class C_Overloading {

	public static void main(String[] args) {
		NewMath newMath = new NewMath();
		System.out.println(newMath.add(5, 3));
		System.out.println(newMath.add(3.1, 2.8));
		System.out.println(newMath.add(1, 2, 3));
		System.out.println(newMath.add(4, 4.6));
		//System.out.println(newMath.add("2", "3"));	//(String, String)이 가능하도록 오버로딩되지 않음

	}

}
