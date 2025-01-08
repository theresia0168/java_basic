package chapter02;

// 클래스: 공통된 속성과 기능을 정의한 것
// [접근제어자] class 클래스명 { 속성, 기능 }

class NewClass01 {
	// 속성: 객체가 가지는 정보 또는 상태의 정의
	// 일반적으로 변수 형태로 표현
	int attribute1;
	double attribute2;
	// 일반적으로 정의만 하고 초기화하지 않음
	// 인스턴스 변수: 각 인스턴스마다 독립적으로 값을 가지는 변수
	int instanceVariable;
	// 클래스 변수: 해당 클래스로 생성된 모든 인스턴스가 공유하는 변수
	// 필드의 데이터 타입 앞에 static 키워드를 사용하여 지정한다
	// 인스턴스 생성 없이 사용 가능
	static int classVariable;
	
	// 기능: 객체가 가질 수 있는 행동이나 작업(메소드)
	// [접근제어자] 반환타입 메소드명 (매개변수타입 매개변수명, ...) > 선언부
	// { 메소드 기능 구현 } > 구현부
	
	void method01 () {
		System.out.println("메소드");
		return; 
		// 메소드의 결과를 반환하는 역할을 수행
		// 일반적인 메소드는 반드시 제일 마지막에 return이 필수
		// void 메소드에서는 필수가 아니다
		// 메소드 중간에 메소드를 강제 종료할 때 사용할 수 있음
	}
	
	// 인스턴스 메소드: 인스턴스 생성 후 인스턴스를 통해 호출 가능한 메소드
	// 인스턴스, 클래스 변수 및 메소드를 모두 사용 가능
	int instanceMethod01(int arg1) {
		return arg1 * attribute1;
	}
	
	// 클래스 메소드: 인스턴스 생성 없이 클래스로 호출 가능한 메소드
	// 반환 타입 앞에 static 키워드를 붙여 선언 가능
	// 클래스 메소드에서는 인스턴스 변수 사용 및 인스턴스 메소드 호출이 불가능
	// 인스턴스 변수 및 인스턴스 메소드를 사용하지 않는 기능에 주로 사용됨
	static int classMethod01(int arg1) {
		//return arg1 & attribute1;	// attribute1은 인스턴스 생성 후에 초기화 되므로 오류 발생
		return arg1 * classVariable;
	}
}

// 스마트폰
class SmartPhone01 {
	String os;			// 운영 체제
	String telNumber;	// 전화 번호
	boolean power;		// 전원 상태
	
	void onOff() {	// 전원 상태 변경 작업
		power = !power;
	}
	
	void printInfo() {	// 정보를 보여주는 작업
		if(!power) {
			System.out.println("Power Offed");
			return;
		}
		System.out.println("OS: " + os);
		System.out.println("Tel Number: " + telNumber);
	}
	
	void tel(String to){	// 전화를 거는 작업
		if(!power) {
			System.out.println("Power Offed");
			return;
		}
		System.out.println(telNumber + " is now calling to " + to);
	}
}


// 삼각형 관련 수학
// 빗변 구하기
// 둘레 구하기
// 넓이 구하기

class TriangleMath {
	static final int SPEED_OF_LIGHT = 300_000_000;
	// SPEED_OF_LIGHT는 SRP(단일 책임 원칙)에 위배되는 요소이다
	
	static double getHypotenuse(double bottom, double height) {
		if(bottom <= 0 || height <= 0) {
			return 0;
		}
		double hypotenuse2 = Math.pow(bottom, 2) + Math.pow(height, 2);
		double hypotenuse = Math.sqrt(hypotenuse2);
		return hypotenuse;
	}
	
	static double getCircumference(double bottom, double height, double hypotenuse) {
		if(bottom <= 0 || height <= 0 || hypotenuse <= 0) {
			return 0;
		}
		return bottom+height+hypotenuse;
	}
	
	static double getArea(double bottom, double height) {
		if(bottom <= 0 || height <= 0) {
			return 0;
		}
		return (bottom*height)/2;
	}
}

public class A_Class_Object {
	
	// 함수: 특정한 기능에 대한 정의
	// 반환타입 함수명(매개변수타입 매개변수명, ...){ 함수의 기능 }
	
	static int fx1(int x) {
		int y = x * x + 2 * x + 1;
		return y;
		// return: 함수를 종료하면서 함수 결과를 반환하는 역할
		// 함수에서 반드시 return 작업이 수행되어야 함
		// 그러나 void 반환 타입일 때는 return이 필수는 아님
		// void: 타입 없음
	}
	
	static void printBmi() {
		double x = (183 * 183);
		double y = 84 / x;
		System.out.println("bmi: " + y);
	}
	
	// 함수의 목적
	// 1. 기능을 미리 정의해두고 사용할 땐 호출하여 사용할 수 있도록 함
	// 코드 중복 제거, 유지 보수성 향상, 실제 구현 내용을 알 필요가 없음
	// 2. 기능에 이름을 부여하여 사용할 수 있도록 함

	public static void main(String[] args) {
		// 인스턴스: 특정 클래스로 정의된 것을 실체화한 것
		// 클래스명 참조변수명 = new 클래스명();
		NewClass01 instance01 = new NewClass01();
		NewClass01 instance02 = new NewClass01();
		
		System.out.println(instance01);
		System.out.println(instance02);
		
		// 인스턴스가 가지고 있는 속성 접근 방법
		// 인스턴스.속성명;
		instance01.attribute1 = 10;
		instance02.attribute1 = 20;
		new NewClass01().attribute1 = 30;	// 주소를 기억하지 못하기 때문에 값만 할당되고 사용할 수 없다.
		instance01.classVariable = 10;
		NewClass01.classVariable = 20;
		instance02.classVariable = 99;
		
		System.out.println(instance01.classVariable);
		System.out.println(instance02.classVariable);
		
		System.out.println(instance01.attribute1);
		System.out.println(instance02.attribute1);
		System.out.println(NewClass01.classVariable);
		
		// 클래스 변수를 사용할 때 주의할 점
		// 클래스 변수는 모든 인스턴스에 영향을 미치기 때문에 클래스로 접근하기를 권장한다
		// 일반적으로 클래스 변수는 final 키워드와 함께 사용한다
		
		SmartPhone01 iPhone16 = new SmartPhone01();
		SmartPhone01 galaxyS24 = new SmartPhone01();

		iPhone16.os = "iOS";
		iPhone16.telNumber = "010-1111-1111";
		galaxyS24.os = "Android";
		galaxyS24.telNumber = "010-9999-9999";
		
		System.out.println(iPhone16.os);
		System.out.println(galaxyS24.os);
		System.out.print(iPhone16.telNumber + "가 ");
		System.out.println("010-2222-2222로 전화를 겁니다.");
		System.out.print(galaxyS24.telNumber + "가 ");
		System.out.println("010-3333-2222로 전화를 겁니다.");
		
		// 인스턴스가 가지고 있는 메소드 호출 방법
		// 인스턴스.메소드명(매개변수, ...);
		iPhone16.printInfo();
		iPhone16.onOff();
		iPhone16.printInfo();
		
		System.out.println(fx1(10));
		System.out.println(fx1(4));
		
		printBmi();
		
		double height = 3;
		double bottom = 4;
		double hypotenuse = TriangleMath.getHypotenuse(bottom, height);
		System.out.println(hypotenuse);
		System.out.println(TriangleMath.getCircumference(bottom, height, hypotenuse));
		System.out.println(TriangleMath.getArea(bottom, height));
	}

}
