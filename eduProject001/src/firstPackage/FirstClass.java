package firstPackage;

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("Hello Java!");
		// System.out.println("Java");
		// 한 줄 주석
		// 용도: 코드 설명, 특정 코드를 컴파일 하고 싶지 않을 때
		// 콘솔에 출력하기 위한 코드입니다.
		/*
		 * 범위 주석
		 * 용도: 특정 영역의 코드를 컴파일 하고 싶지 않을 때
		 */
		System.out.println(/*"Hello"*/"Good Bye");
		/**
		 * 문서화 주석
		 */
		
		testfunction();
	}
	
	public static int testfunction() {
		int length01 = 10;
		int length02 = 20;
		
		System.out.println(length01 + length02);
		
		String[] a = {"Hello"};
		String[] b = {"Hello"};
		if(a[0]==b[0]) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		return 0;
	}
	
}