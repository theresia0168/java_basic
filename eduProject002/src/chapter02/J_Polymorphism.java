package chapter02;

// 다형성: 하나의 표현으로 여러 가지 형태를 나타낼 수 있는 것

// 오버로딩(Overloading): 같은 클래스 내에서 같은 이름의 메소드를 다른 매개변수 이름, 개수, 순서를 통해 여러 개 정의할 수 있는 것
// 오버라이딩(Overriding): 자손 클래스에서 조상 클래스에 정의된 메소드를 재정의하는 것
// 업캐스팅(Upcasting): 하위 클래스의 객체를 상위 클래스 혹은 구현한 인터페이스 타입의 참조변수로 저장하는 것
// 다운캐스팅(Downcasting): '업캐스팅'된 객체를 다시 원래 타입의 변수에 담는 것(반드시 원래 타입일 필요는 없음)

class People {
	String name;
	int age;
	
	People(String name, int age){
		this.name = name;
		this.age = age;
	}
}

class Teacher extends People {
	String subject;
	
	Teacher(String name, int age, String subject){
		super(name, age);
		this.subject = subject;
	}
}

class Student extends People {
	int grade;
	
	Student(String name, int age, int grade){
		super(name, age);
		this.grade = grade;
	}
}

public class J_Polymorphism {

	public static void main(String[] args) {
		People people1 = new People("Tom", 20);
		Teacher teacher1 = new Teacher("Henry", 30, "History");
		Student student1 = new Student("Jack", 15, 3);
		
		People people2 = teacher1/*주소가 들어있음*/;	// 업캐스팅
		// 업캐스팅 되면 데이터 손실이 일어난 것처럼 보인다
		// 그러나 원래 상태 그대로 힙 영역에 남아있으며 이 데이터를 쳐다보는 시각이 달라지는 것 뿐이다
		// 업캐스팅
		System.out.println(people2.name);
		System.out.println(people2.age);
		
		// 다운캐스팅
		Teacher teacher2 = (Teacher) people2;
		System.out.println(teacher1.subject);
		System.out.println(teacher2.subject);
		
		// 업캐스팅이 되지 않은 참조변수에 대해서는 다운캐스팅 작업이 불가능하다
		// Student student2 = (Student) people1;
		
		// Object를 활용한 업캐스팅 다운캐스팅
		Object object1 = student1;
		Student student2 = (Student)object1;
	}

}
