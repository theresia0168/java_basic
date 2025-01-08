package chapter02;

// 추상 클래스: 추상 메소드를 포함할 수 있는 클래스
// 추상 클래스 자체로는 인스턴스를 생성할 수 없다
// 반드시 추상 클래스를 상속 받은 하위 클래스로 인스턴스를 생성해야 한다
// abstract class 추상클래스명 { ... }

// 추상 메소드: 선언부만 존재하고 구현부는 존재하지 않는 메소드
// 반드시 클래스 중에서는 추상 클래스 내부에서만 선언할 수 있다
// 반드시 추상 클래스를 상속 받은 하위 클래스에서 재정의(오버라이딩)하여 구현해야 한다
// abstract 반환타입 추상메소드명(매개변수, ... );

// abstract: 추상 클래스 혹은 추상 메소드를 정의하는 제어자
// abstract가 붙은 클래스는 인스턴스를 생성할 수 없음
// abstract가 붙은 메소드는 구현부를 가질 수 없음

abstract class Occupation {
	int annual;
	int income;
	
	// 추상 클래스에서 생성자는 인스턴스를 생성하는 목적이 아님
	// 하위 클래스에서 호출하여 사용할 수 있도록 제공하는 목적
	// 단, 기본 생성자가 없는 상태에서 생성자를 정의한다면 하위 클래스의 생성자 작성이 강제됨
	Occupation(int annual, int income){
		this.annual = annual;
		this.income = income;
	}
	
	// 추상 메소드는 하위 클래스에서의 오버라이딩을 강제한다
	abstract void work();
	
	// 추상 클래스도 일반 메소드를 가질 수 있음
	// 일반 메소드는 오버라이딩을 강제하지 않는다
	void sleep() {
		System.out.println("Take a sleep");
	}
}

class Developer extends Occupation {
	String position;
	
	Developer(int annual, int income, String position){
		super(annual, income);
		this.position = position;
	}
	
	void eat(String food) {
		System.out.println("Eating " + food);
	}
	@Override
	void work() {
		System.out.println("Developing");
	}
}

class TourGuide extends Occupation {
	String country;
	
	TourGuide(int annual, int income, String country){
		super(annual, income);
		this.country = country;
	}

	@Override
	void work() {
		System.out.println("Tour guide at " + this.country);
	}
}

public class H_AbstractClass {

	public static void main(String[] args) {
		//Occupation occupation = new Occupation(7, 100);
		Developer developer = new Developer(10,100, "BackEndDeveloper");
		TourGuide tourGuide = new TourGuide(1, 20, "ROK");
		developer.work();
		System.out.println(tourGuide.annual);
	}

}

// 제어자 조합
// static이 붙은 변수: public + static + final (자주 사용)
// private + final이 붙은 변수: 생성자에서 필수로 초기화
// private + final이 붙은 메소드: final이 의미가 없음
// private + abstract가 붙은 메소드: 서로 상충되는 관계이므로 불가능
// final + abstract가 붙은 클래스와 메소드: 서로 상충되는 관계이므로 불가능 (final이 붙으면 상속, 오버라이드 불가능)
