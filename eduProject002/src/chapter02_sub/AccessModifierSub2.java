package chapter02_sub;

import chapter02.F_AccessModifier;
// chapter02 package에 선언된 F_AccessModifier 클래스를 사용하기 위해 import
// import chapter02.AccessModifierSub1;
// AccessModifierSub1은 package으로 선언되어 있어 public으로 선언되어 있지 않으므로 import가 불가능하다

public class AccessModifierSub2 extends F_AccessModifier {
	
	void method() {
		// 현재 위치: 다른 패키지의 상속 받은 하위 클래스
		// public, protected 접근 제어자는 접근 가능
		super.publicInt = 0;
		super.protectedInt = 0;
		// package, private 접근 제어자는 접근 불가능
//		super.packageInt = 0;
//		super.privateInt = 0;
	}
	
	
}

class AccessModifier3 {
	void method() {
		F_AccessModifier instance = new F_AccessModifier();
		// 현재 위치: 다른 패키지의 관련 없는 클래스
		// public 접근 제어자만 접근 가능
		instance.publicInt = 0;
		// protected, package, private 접근 제어자는 접근 불가능
//		instance.protectedInt = 0;
//		instance.packageInt = 0;
//		instance.privateInt = 0;
	}
}