package chapter02;

// Constructor(생성자): 클래스의 인스턴스가 생성되는 순간에 호출되는 메소드
// 클래스와 같은 이름을 가지며 반환 타입이 존재하지 않음
// 클래스명(매개변수, ...) { 인스턴스 생성될 때 수행할 작업 }

class Human1 {
	String name;
	int age;
	String gender;
	
	final String address;	// final, 상수로 선언하게 되면 생성자의 필수값(required)이 되어 반드시 선언해야한다.
	// 인스턴스가 생성되면 속성 값이 null로 지정되기 때문에 다시 변경할 수 없게 되어 Error가 발생한다.
	
	// 다른 생성자(매개변수가 존재하는 생성자)만 존재한다면 기본 생성자는 자동으로 생성되지 않는다
	// 기본 생성자를 생성하고 싶다면 직접 만들어야 한다
	
	int numbers[];
	
	Human1(){
		// 생성자에서 다른 생성자를 호출하고 싶다면 제일 상단에 작성해줘야한다
		// 반드시 생성자에서만 사용가능
		// 생성자의 첫 구문으로 들어와야 함
		this("Tom");
		
		// 1. 인스턴스를 생성할 때 특정 작업을 수행하고 싶은 경우
		System.out.println("Human1's instance created");
		
		// 2. *인스턴스를 생성과 동시에 인스턴스 변수를 초기화하고 싶은 경우*
		// 의존성을 내부에서 주입하는 행위이다
		this.name = "Gildong";
		this.age = 20;
		this.gender = "Male";
		// this.address = "Busan";	// 이미 초기화 된 상수를 다시 변경하려고 하기에 Error가 발생한다
	}
	Human1(int age){
		System.out.println("Human1's instance created");
		this.age = age;
		System.out.println("Human1 is " + age + " years old");
		this.address = "Busan";
	}
	
	Human1(String name1){
		// this: 현재 자기 자신의 인스턴스를 지칭하는 키워드
		// 인스턴스 변수나 인스턴스 메소드를 정확히 지칭할 때 사용됨
		this.name = name1;
		this.age = 20;
		this.gender = "Male";
		this.address = "Busan";
	}
	
	Human1(String name1, int age1, String gender1){
		// 의존성을 모두 외부에서 주입하는 행위
		// 가장 많이 사용하는 형태이다
		this.name = name1;
		this.age = age1;
		this.gender = gender1;
		this.address = "Busan";
		numbers = new int[] {1, 2, 3};
	}
	
	Human1(Human1 human1){
		this.name = human1.name;
		this.age = human1.age;
		this.gender = human1.gender;
		this.address = human1.address;
		this.numbers = human1.numbers;	// 배열의 주소가 들어있기 때문에 동일하게 주소가 복사된다
		this.numbers[1] = human1.numbers[1];
	}
}

public class D_Constructor {

	public static void main(String[] args) {
		
		// 기본 생성자
		// 만약 클래스에 생성자를 정의하지 않으면 컴파일러가 자동으로 기본 생성자를 제공한다
		Human1 human1 = new Human1();		// 생성 시 human1에 주소가 들어간다. 따라서 반환타입 지정이 필요 없음
		human1.name = "Washington";
		human1.age = 60;
		human1.gender = "Male";
		Human1 human2 = new Human1();
		System.out.println(human2.name + human2.age + human2.gender);
		
		Human1 human3 = new Human1("Washington");
		System.out.println(human3.name + human2.age + human2.gender);
		
		Human1 human4 = new Human1("Washington", 37, "Male");
		System.out.println(human4.name + human4.age + human4.gender);
		
		// 주소만 복사되는 형태 (독립적이지 않음)
		Human1 human5 = human4;
		// 새로운 주소를 생성해서 값을 복사하는 형태 (독립적)
		Human1 human6 = new Human1(human4);
		human4.numbers[0] = 99;
		System.out.println(human4.numbers[0]);
		System.out.println(human6.numbers[0]);
		human4.age = 10;
		System.out.println(human4.age + " " + human6.age);
	}

}
