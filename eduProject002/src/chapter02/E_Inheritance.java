package chapter02;

// 상속: 객체지향 프로그래밍의 특성 중 하나
// 원래 존재하던 클래스를 '확장'하여 재사용할 수 있도록 하는 것
// 코드의 중복을 제거하여 코드 재사용성, 유지 보수성, 확장성을 높일 수 있다
// extends 키워드를 사용
// class Subclass extends SuperClass { ... }

class Human {
	String name;
	int age;
	
	Human() {}
	
	// 부모 클래스의 생성자는 상속되지 않음
	Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	void sleep() {
		System.out.println(name + " is going to bed.");
	}
	
	final void eat() {		// fianl 메소드이므로 상속 받은 클래스에서 재정의 오버라이딩할 수 없다
		System.out.println("Have a meal.");
	}
}

// 상속은 단일 클래스에 대해서만 가능하다
// 여러 클래스로부터 상속을 받을 수 없다
// 다중 상속에서 발생할 수 있는 다이아몬드 문제가 발생하지 않도록 하기 위함이다
// 다이아몬드 문제: 다중 상속으로 인해 동일한 이름의 메소드를 상속 받은 상태에서 어떤 메소드를 선택해야할지 모호해지는 문제
// 인터페이스를 사용하여 다중 상속 효과를 볼 수 있음
// 중첩 상속을 사용하여 다중 상속 효과를 볼 수 있음
class Korean extends Human {
	static String country = "Repulbic of Korea";
	
	void sleep() {
		System.out.println("Sleeps at 1 o' clock.");
	}
}

class Firefighter extends Korean {
	String position;
	
	void firefight() {
		System.out.println(name + " is firefighting.");
	}
	
	// Human 클래스로부터 상속 받은 sleep 메소드를 오버로딩한 것
	// Overloading 매개변수를 추가한 케이스(개수 변동)
	void sleep(int time) {
		System.out.println(name + " is going to bed at " + time + " o' clock");
	}
}

class Police extends Human {
	String rank;
	
	Police(){
		// super(): 부모 클래스의 생성자를 지칭하는 키워드
		// super: 부모 클래스를 지칭하는 키워드
		super("Henry", 28);
		this.rank = "chief";
	}
	
	void patrol() {
		System.out.println(name + " is patroling.");
	}
	
	void intro() {
		System.out.println("My name is " + this.name);
		System.out.println("I'm " + this.age + " years old");
		System.out.println("My rank is " + this.rank);
	}
}

class Salesman extends Human {
	int sales;
	
	void sales(int amount) {
		this.sales+=amount;
	}
	
	// Overriding(오버라이딩): 하위 클래스에서 상위 클래스의 메소드를 '재정의'하는 것이다
	// 1. 상위 클래스에서 선언된 메소드와 이름, 매개변수 조합, 반환 타입이 동일해야 한다
	// 2. 상위 클래스에서 선언된 메소드가 final로 선언되면 재정의가 불가능
	// @Override: 컴파일러에게 현재 작업이 오버라이딩 작업임을 알려주어 문법 검사를 실행하게 한다
	
	@Override
	void sleep() {
		// 오버라이딩을 통해서 코드의 유연성을 증가 시킬 수 있음
		System.out.println("Salesman is sleeping.");
		System.out.println(this.name + " is sleeping.");
		// 오버라이딩을 통해 코드의 재사용성을 증가 시킬 수 있음
		super.sleep();
	}
	
	
}

final class FinalSuper {
	int a;
}

// final로 정의된 클래스는 상속 받을 수 없음
//class FinalSub extends FinalSuper {
//	
//}

// Java의 모든 클래스는 Object 클래스를 최상위 클래스로 상속받아 사용한다
public class E_Inheritance {

	public static void main(String[] args) {
		Firefighter firefighter1 = new Firefighter();
		firefighter1.name = "Herman";
		System.out.println(firefighter1.name);
		
		Police police1 = new Police();
		police1.intro();
		police1.sleep();
		
		firefighter1.sleep(4);
		firefighter1.sleep();
		
		Salesman salesMan = new Salesman();
		salesMan.sleep();
	}

}
