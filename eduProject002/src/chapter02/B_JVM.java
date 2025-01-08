package chapter02;

// JVM Java Virtual Machine 자바 가상 기계
// 실제 컴파일된 코드를 실행하는 기계
// 별도의 메모리 구조를 가짐

// Method Area (메소드 영역)
// : 모든 곳에서 접근 가능한 영역, 코드를 읽고 각 클래스의 구조를 저장하고 있음

// Heap Area (힙 영역)
// : 모든 곳에서 접근 가능한 영역, 인스턴스 혹은 배열과 같은 new 연산자를 통해 생성된 객체들이 저장되는 영역

// Stack Area (스택 영역)
// : 각 스레드(실행 중인 프로세스) 별로 독립적으로 존재하는 영역, 메소드 호출과 로컬 변수에 대한 정보가 저장된 영역
// 각 코드블럭마다 하나의 스택이 생성됨

class newClass02 {	// class의 정보는 메소드 영역에 저장된다
	int iv;
	static int cv;
	
	void im() {
		int lv = 10;
		newClass02 itc = new newClass02();
	}
	
	static void cm() {
		int clv = 10;
		
	}
}

public class B_JVM {
	
	static void method01(int arg) {
		arg++;
	}
	
	static void method02(newClass02 arg) {
		arg.iv++;
	}

	public static void main(String[] args) {
		int lv1 = 20;		// 스택 영역에 저장
		double lv2 = 3.5;	// 스택 영역에 저장
		
		if(lv1 > 0) {		// 스택 영역에 전체 코드 블럭 저장
			int cb = 30;	
			lv1 = cb;
		}					// 코드 블럭의 동시와 스택 영역에서 사라짐
		
		newClass02 itc1 = new newClass02();		// 스택 영역에 itc1 class가 저장
		// 힙 영역에 저장되는 것은 인스턴스와 관련된 iv, im
		// 힙 영역에 저장된 주소명을 h1이라고 가정한다
		// 스택 영역에 itc1이 저장된 곳에 h1이 저장된다
		newClass02 itc2 = new newClass02();		// 스택 영역에 itc2 class가 저장
		
		itc1.iv = 10;	// 스택 영역에 저장된 주소를 따라가 힙 영역의 itc1.iv의 값을 10으로 바꾼다
		itc2.iv = -99;	// 스택 영역에 저장된 주소를 따라가 힙 영역의 itc2.iv의 값을 -99으로 바꾼다
		
		itc1.cv = 3000;	// cv는 static이기 때문에 메서드 영역에 저장된 newClass02의 정보 중 cv가 3000으로 변경된다
		itc1.im();		// 함수가 호출되었기 때문에 스택 영역에 새로운 스택이 생성된다
						// int 크기 만큼의 lv를 만들어 10을 할당한다
						// 새로운 newClass02 itc가 스택 내에 생성된다
						// new가 붙어있기 때문에 새로운 인스턴스를 힙 영역에 생성한다
						// 해당 힙 영역의 공간 주소를 h3라고 가정한다
						// 스택 영역에 h3이라는 주소가 itc에 저장된다
						// im 메소드는 종료된 후 생성된 스택이 사라진다
						// 그러나 힙 영역에 저장된 인스턴스는 사라지지 않고 남아있다
						// 이를 제대로 관리하지 못하면 메모리 누수가 발생한다
						// Java의 경우 가비지 컬렉션을 통해 메모리를 관리해준다
						// 스택을 유지하지 않으면 힙 영역에서 제거한다
		
		newClass02 b = new newClass02();
		b.iv = 99;
		method02(b);	// 주소를 찾아가 해당 주소의 값을 바꾼다
		System.out.println(b.iv);
		
	}

}
