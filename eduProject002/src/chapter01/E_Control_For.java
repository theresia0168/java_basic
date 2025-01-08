package chapter01;

public class E_Control_For {

	public static void main(String[] args) {
		// 반복문: 특정 조건을 만족할 시 지정한 코드 블럭을 반복 실행한다
		
		// for문: 일반적으로 반복 횟수가 정해진 경우 사용하는 반복문
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			System.out.println("Hello");
		}
		
		for(int i = 1; i < 10; i++) {
			System.out.println("2 * " + i + " = " + 2*i);
		}
		
		String[] fruits = new String[] {"apple", "banana", "cacao"};
		System.out.println(fruits[0]);
		System.out.println(fruits[1]);
		System.out.println(fruits[2]);
		for(int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		for(int i = 0; i < fruits.length; i++) {
			fruits[i]+=" add";
		}
		// 인덱싱을 통해서 배열의 원소에 직접적으로 접근 가능하다
		
		// forEach문: Python의 for i in (배열): print(i)와 유사한 방식
		// 컬렉션(배열)의 각 요소를 하나씩 복사해서 사용하는 반복문
		// 실제 요소에 대해 읽기 작업 수행에는 적합하나 변경 작업 수행에는 적합하지 않다
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		for(String fruit : fruits) {
			fruit+=" add";	// 이 작업은 수행되지 않았음
			// 내용물을 중개하는 String fruit 변수가 새로 생겼다
			// 이 변수에 기존 배열의 요소를 가져와 복사해 할당한 것이다
			// 따라서 fruit에 " add" 문자열을 더해도 원본 문자열은 변경되지 않는다
		}
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
