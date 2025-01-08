package chapter02;

// 인터페이스: 클래스가 구현해야하는 메소드들의 집합을 정의해둔 것
// 인터페이스의 모든 변수는 public static final 형태이다
// 인터페이스의 모든 메소드는 public abstract 형태이다
// 인터페이스는 다중 구현이 가능하다

// 인터페이스는 개발자 간의 상호 약속을 위한 수단으로 사용됨
// 기능, 상수들에 대한 약속을 정의한다

// 접근제어자 interface 인터페이스명 { ... }

interface AreaCalculation {
	// 변수는 반드시 public static final이기 때문에 생략이 가능하다
	// double PI = 3.14;
	public static final double PI = 3.14;
	double HELLO = 10;
	
	// 메소드는 반드시 public abstract이기 때문에 생략이 가능하다
	// double exampleMethod();
	public abstract double getTriangleArea(double height, double bottom);
	public abstract double getRectangleArea(double height, double bottom);
	public abstract double getCircleArea(double radius);
}

interface NormalCalculation {
	double add(double a, double b);
}
// 인터페이스는 인터페이스끼리 확장(상속)이 가능하다
// 인터페이스의 확장(상속)은 다중 상속이 가능하다
interface Calculation extends AreaCalculation, NormalCalculation {
	
}

// 인터페이스는 implements 키워드를 이용하여 클래스에서 구현할 수 있다
// 인터페이스는 다중 구현이 가능하다
class Calculator implements AreaCalculation, NormalCalculation {

	@Override
	public double getTriangleArea(double height, double bottom) {
		return height * bottom / 2;
	}

	@Override
	public double getRectangleArea(double height, double bottom) {
		return height * bottom ;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}

	@Override
	public double add(double a, double b) {
		return a + b;
	}	
	
}

public class I_Interface {

	public static void main(String[] args) {
		

	}

} 
