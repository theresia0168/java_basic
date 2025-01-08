package chapter01;

public class C_Array {

	public static void main(String[] args) {
		// 배열: 동일한 타입의 변수를 묶어서 저장하는 컨테이너
		// new 연산자를 이용해서 컨테이너는 먼저 생성해야 함
		// 한번 생성된 컨테이너의 크기는 변경할 수 없음
		
		// 배열 변수 선언
		// 데이터타입[] 배열변수명;
		int[] newArray;
		
		// 배열 생성
		// new 데이터타입[배열_길이];
		newArray = new int[3];
		System.out.println(newArray);
		
		// {중괄호}로 끝나는 한 줄을 '구문(코드 블럭)'이라고 한다
		int[] newArray2 = {1, 2, 3};
		int[] newArray3 = new int[] {1, 2, 3};
		System.out.println(newArray2);
		System.out.println(newArray3);
		// 출력되는 값은 배열의 주소
		
		// 배열 안의 요소에 접근하기 위해서는 인덱스를 사용해 newArray[n]으로 접근해야 한다
		// 배열의 시작 인덱스는 0, 마지막 인덱스는 [배열 길이 - 1]
		int number = newArray3[1];
		System.out.println(number);
		newArray3[1] = 22;
		System.out.println(newArray3[1]);
		
		// 배열의 길이를 초과하는 인덱스에 접근할 시 예외 발생
		// System.out.println(newArray3[99]);
		
		// 배열의 길이를 확인할 때는 배열명.length를 사용한다
		System.out.println(newArray3.length);	// 3이 나와야 한다
		int lastIndex = newArray3[newArray3.length - 1];	// 변수를 활용하면 어떤 수인지 쉽게 확인 가능
		System.out.println(newArray3[newArray3.length - 1]);	// 배열의 마지막 값이 출력된다
		System.out.println(lastIndex);	// 위 출력문과 동일한 값이 출력된다
		
		int[] example1 = new int[] {0, 0, 0};		// example1에는 주소가 들어있다
		int[] example2 = example1;					// example2에는 example1의 주소가 들어있다
		System.out.println(example1);
		System.out.println(example2);
		// 동일한 주소가 출력된다
		
		example1[0] = 99;
		System.out.println(example1[0]);
		System.out.println(example2[0]);
		// example2가 example1의 주소를 가지고 있으므로
		// example2의 0번 인덱스의 값도 동일하게 99로 출력된다

		char[] chars = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
		System.out.println(chars);
		// 문자열을 이렇게 다루게 되면 불편하다
		
		// String: 문자의 배열(문자열)을 표현하는데 사용되는 참조형 데이터 타입
		// 선언
		String newString;
		// 생성
		newString = new String();
		// 초기화
		newString = "New String";
		System.out.println(newString);
		String newString02 = "Second String";
		System.out.println(newString02);
		
		String newString03 = "example";
		System.out.println(newString03);
		System.out.println(chars);
		chars[0] = 'd';
		System.out.println(chars);
		// 문자형 배열의 원소를 바꾸는 것은 가능하다
		// newString03[0] = 'd';
		// 인덱싱 자체가 배열에만 가능하기 때문에 String의 값을 인덱스로 접근하여 바꾸는 것은 불가능하다
		newString03 = "dxample";
		System.out.println(newString03);
		
		// String 클래스의 주요 기능
		String statement = "String1";
		
		// 1. 문자열 결합
		// + 혹은 concat(문자열)으로 두 문자열을 연결할 수 있음
		System.out.println(statement + "AddOn");
		System.out.println(statement.concat("AddOn"));
		
		// 2. 문자열 비교
		// equals(문자열): 두 문자열이 동등한지 비교
		// compareTo(문자열): 두 문자열을 사전순으로 비교(대소문자 구분)
		// compareToIgnoreCase(문자열): 두 문자열을 사전순으로 비교하나 대소문자를 구분하지 않음
		System.out.println(statement.equals("String1"));				// true, false 형태로 반환
		System.out.println(statement.compareTo("string1"));				// ASCII 코드값 차이를 반환
		System.out.println(statement.compareToIgnoreCase("string1"));
		
		// 3. 문자열 길이
		// length(): 문자열의 길이 반환
		System.out.println(statement.length());
		
		// 4. 문자열 변환
		// toUpperCase(): 모두 대문자로 변환
		// toLowerCase(): 모두 소문자로 변환
		// 모두 대문자로, 모두 소문자로 입력하여 저장하면 관리하기 쉽다
		// trim(): 앞뒤 공백을 제거
		// replace(찾을 문자열, 바꿀 문자열): 특정 문자열을 찾아 변경
		String example = " Example ";
		System.out.println(example.toUpperCase());
		System.out.println(example.toLowerCase());
		System.out.println(example.trim());
		System.out.println(example.replace("ampl", "help"));
		
		// 5. 문자열 찾기
		// indexOf(문자열): 찾고자 하는 문자열의 처음 찾은 위치의 인덱스 번호를 반환
		// lastIndexOf(문자열): 찾고자 하는 문자열의 마지막 위치의 인덱스 번호를 바환
		statement = "She sells seashells by the seashore";
		System.out.println(statement.indexOf("sells"));
		System.out.println(statement.indexOf("see"));
		
		// 6. 부분 문자열
		// substring(시작 인덱스), substring(시작 인덱스, 종료 인덱스): 문자열을 원하는 크기만큼 추출
		System.out.println(statement.substring(10));
		System.out.println(statement.substring(10, 15));
		
		// 참조형 데이터 타입
		// 주소를 가지는 변수의 데이터 타입
		// null을 가질 수 있다 (null: 아무것도 지정되지 않은 상태)
		// 배열, 클래스, 인터페이스, 열거형이 참조형 데이터 타입에 속한다
		String newString4 = null;
		// newString4.substring(0); null을 참조하여 Error가 발생한다
		
		
	}

}
