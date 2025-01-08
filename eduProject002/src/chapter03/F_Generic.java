package chapter03;

import java.util.ArrayList;
import java.util.List;

// 클래스나 메소드에서 사용할 데이터 타입을 외부에서 지정하는 방법

// Test1, Test2, Test3의 문제점
// 1. 코드 중복 발생: 유지 보수성 및 개발 속도를 늦춤
// 2. 실사용의 불편함: 사용 시 코드가 복잡해진다
class Test1 {
	String subject;
	int score;
}

class Test2 {
	String subject;
	double score;
}

class Test3 {
	String subject;
	char score;
}

// Test4의 문제점
// 타입의 안정성을 낮춤
class Test4 {
	String subject;
	Object score;
}

// 제너릭 클래스: 클래스 내부에 있는 데이터 타입을 컴파일 시에 결정하는 클래스
// class 클래스명<매개타입> { ... }
class Test5<SCORE> {
	String subject;
	SCORE score;
}

class SuperClass {
	
}

class MyClass extends SuperClass {
	
}

class SubClass extends MyClass{
	
}

// T extends 클래스명: 특정 클래스 혹은 특정 클래스를 상속한 클래스만 제너릭으로 지정할 수 있도록 제한한다
class ExtendsClass<T extends MyClass> {
	T variable;
}

public class F_Generic {
	// 제너릭 메소드: 해당 메소드의 매개변수의 타입이나 반환 타입을 컴파일 시에 결정하고자 할 때 사용
	// [제어자...] <매개변수> 반환타입 메소드명(...) { ... }
	
	static <T> void genericMethod(List<T> arg) {
		for(T item: arg) {
			
		}
	}
	
	public static void main(String[] args) {
		
		
		
		List<Test4> tests = new ArrayList<>();
		Test4 test1 = new Test4();
		test1.subject = "Korean";
		test1.score = "Great";
		tests.add(test1);
		Test4 test2 = new Test4();
		test2.subject = "Math";
		test2.score = 100;
		tests.add(test2);
		
		// Object 타입으로 지정 시 모든 타입을 받을 수 있으나 사용 시 타입을 지정함에 있어서 안정성이 떨어진다
		for(Test4 test: tests) {
			//int score = (int)tests.get(0).score;
		}
		
		// 제너릭으로 지정하면 컴파일 시 타입을 결정하여 원하는 형태의 데이터 타입으로 사용할 수 있다
		Test5<Integer> instance1 = new Test5();
		instance1.score = 100;
		Test5<String> instance2 = new Test5();
		instance2.score = "Great";
		
		List<Test5> tests1 = new ArrayList<>();
		tests1.add(instance1);
		tests1.add(instance2);
		for(Test5 test: tests1) {
			System.out.println(test.score);
		}
		
		
		// extends 키워드로 제한을 걸어둔 매개타입은 해당 클래스 혹은 하위 클래스만 제너릭으로 사용할 수 있음
		ExtendsClass<MyClass> instance3;
		
		// ?: 제너릭의 와일드 카드로 모든 타입을 받을 수 있도록 함
		// 와일드 카드는 메소드의 매개변수 혹은 반환타입에 사용
		Test5<String> instance5 = new Test5<>();
		instance5.score = "Great";
		wildcardMethod(instance5);
		
		Test5<Integer> instance6 = new Test5<>();
		instance6.score = 100;
		wildcardMethod(instance6);
		
		List<SuperClass> superList = new ArrayList<>();
		List<MyClass> myList = new ArrayList<>();
		List<SubClass> subList = new ArrayList<>();
		
		// ? extends MyClass로 제한이 걸려있기 때문에 MyClass 또는 Myclass 하위 클래스만 전달 가능
		extendsMethod(myList);
		extendsMethod(subList);
		
		// ? super MyClass로 제한이 걸려있기 때문에 MyClass 또는 Myclass 상위 클래스만 전달 가능
		superMethod(superList);
		superMethod(myList);
		// superMethod(subList);
		
		// 메소드의 매개타입을 직접 지정하지 않고 매개변수의 타입을 따라간다
		genericMethod(myList);
 	}
	
	static void wildcardMethod(Test5<?> test) {
		System.out.println(test.score);
	}
	
	// ? extends 클래스명: 특정 클래스 혹은 특정 클래스를 상속 받은 클래스만 타입으로 받도록 제한
	static void extendsMethod(List<? extends MyClass> list) {
		
	}
	
	// ? super 클래스명: 특정 클래스 혹은 특정 클래스의 상위 클래스만 타입으로 받도록 제한
	static void superMethod(List<? super MyClass> list) {
		
	}
}
