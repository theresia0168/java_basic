package chapter01;

public class D_Operator {

	public static void main(String[] args) {
		int a = 15, b = 2;
		double c = 15.0, d = 7.0;
		
		int intResult = 0;
		double doubleResult = 0.0;
		
		// 산술 연산자: 사칙 연산을 수행하는 연산자
		
		// 더하기: +
		// 좌항에 우항을 더한 값을 반환
		intResult = a + b;
		System.out.println(intResult);
		doubleResult = c + d;
		System.out.println(doubleResult);
		//intResult = a + c; <--- c가 int가 아닌 double이므로 Error가 발생한다
		doubleResult = a + c;	// int형이 아닌 double형으로는 그 결과를 받을 수 있다
		// 정수와 실수를 더하게 되면 그 결과값이 실수형을 띄게 된다
		System.out.println(doubleResult);
		
		// 빼기: -
		// 좌항에 우항을 뺀 값을 반환
		intResult = a - b;
		System.out.println(intResult);
		doubleResult = c - d;
		System.out.println(doubleResult);
		doubleResult = a - c;
		System.out.println(doubleResult);
		
		// 곱하기: *
		// 좌항에 우항을 곱한 값을 반환
		intResult = a * b;
		System.out.println(intResult);
		doubleResult = c * d;
		System.out.println(doubleResult);
		doubleResult = a * c;
		System.out.println(doubleResult);
		
		// 나누기: /
		// 좌항에 우항을 나눈 값을 반환
		intResult = a / b;
		System.out.println(intResult);		
		// 나눗셈의 결과가 실수일 경우 강제 형변환과 같은 형태의 변환이 일어나 실수부(소수)가 사라진다
		doubleResult = c / d;
		System.out.println(doubleResult);
		doubleResult = c / b;
		System.out.println(doubleResult);
		
		// 나머지: %
		// 좌항에 우항을 나눈 나머지를 반환
		intResult = a % b;
		System.out.println(intResult);
		doubleResult = a % d;
		System.out.println(doubleResult);
		
		// 증감 연산자
		// 피연산자 값을 1 증가 혹은 감소
		// 단항 연산자이며 피연산자는 반드시 변수여야한다
		// 증가 연산자: ++
		// 감소 연산자: --
		int num = 7;
		System.out.println(num);
		num++;
		System.out.println(num);
		num--;
		System.out.println(num);
		++num;
		System.out.println(num);
		// 여기까지 num의 값은 8
		System.out.println(10 + ++num);
		// 10에 1 증가한 num 값이 더해져야 하므로 10 + 9 = 19이며 num은 9가 된다
		System.out.println(10 + num++);
		// 10에 num 값이 더해진 후 num의 값이 1 증가하므로 10 + 9 = 19가 출력된 후, num이 10이 된다
		// ++, --의 위치는 전위, 후위 연산의 차이이다
		// 전위 연산은 증감 연산을 우선적으로 수행한 후 다른 연산이 수행된다
		// 후위 연산은 다른 연산을 수행한 후 증감 연산을 수행한다
		
		final int NUMBER = 7;
		// NUMBER++;
		// 7++;
		// 증감 연산자는 상수에 대해 사용할 수 없다
		
		// 대입 연산자: 좌항에 우항을 할당
		
		// 일반 대입 연산자: =
		// 좌항에 우항의 연산 결과를 할당
		// 좌항에 일반 변수와 상수형 변수 모두 올 수 있다
		int number = 10 + 5;
		
		// 복합 대입 연산자: (타연산자)= 의 형태
		// 좌항에 우항의 연산 결과를 할당
		// 좌항은 반드시 초기화가 이루어진 일반 변수여야 한다
		number += 3;
		System.out.println(number);
		number -= 3;
		System.out.println(number);
		number *= 3;
		System.out.println(number);
		number /= 3;
		System.out.println(number);
		number %= 3;
		System.out.println(number);
		
		// 비교 연산자: 좌항과 우항을 비교하여 그 결과를 논리 값으로 반환한다
		boolean booleanResult = true;
		
		// 동등, 부등 비교 연산자
		// ==: 좌항과 우항과 같을 시 true, 다를 시 false
		// !=: 좌항과 우항이 다를 시 true, 같을 시 false
		// a: 15, b: 2, c: 15.0, d: 2.0
		booleanResult = a == b;
		System.out.println(booleanResult);
		booleanResult = a == c;
		System.out.println(booleanResult);
		
		// 크기 비교 연산자
		// >(=): 좌항이 우항보다 크(거나 같으)면 true, 그렇지 않다면 false
		// <(=): 좌항이 우항보다 작(거나 같으)면 true, 그렇지 않다면 false
		booleanResult = d > b;
		System.out.println(booleanResult);
		booleanResult = d >= b;
		System.out.println(booleanResult);
		
		// 논리 연산자
		// : 피연산자가 모두 논리값인 연산자, 피연산자를 조합
		
		// 논리 AND 연산자(&&): 좌항, 우항이 모두 true일 때 true를 반환, 이외의 경우 false 반환
		booleanResult = true && true;
		System.out.println(booleanResult);
		booleanResult = true && false;
		System.out.println(booleanResult);
		booleanResult = (a==b) && (c==d);
		System.out.println(booleanResult);
		
		// 논리 OR 연산자(||): 좌항, 우항 중 하나라도 true일 때 true를 반환, 모두 false일 때 false 반환
		booleanResult = true || false;
		System.out.println(booleanResult);
		booleanResult = false || false;
		System.out.println(booleanResult);
		booleanResult = (a>b) || (c<d);
		System.out.println(booleanResult);
		
		// 논리 NOT 연산자(!): 단항 연산자이며 피연산자가 true이면 false, false이면 true를 반환
		System.out.println(!booleanResult);
		
		System.out.println("a: "+ a);
		booleanResult = false && (a++ > b);
		System.out.println(booleanResult);
		System.out.println("a: "+ a);
		booleanResult = false || (a++ > b);
		System.out.println("a: "+ a);
		// a값이 증가 하지 않은 것은 AND 연산에서 앞의 값이 false로 고정되어 무조건 적으로 결과가 false로 나온다
		// 따라서 우항을 읽지 않고 dead code가 되어버리기 때문에 연산이 수행되지 않는다
		// OR 연산을 하게 되면 true, false 여부를 판별하기 위해 우항 또한 읽어야 하므로
		// 우항의 연산을 수항하게 되어 a의 값이 증가해 16이 된다
		
		// 삼항 연산자: 조건에 따라 지정한 결과를 반환하는 연산자
		// 조건(논리식) ? 참 결과 : 거짓 결과
		String resultString = (a>b) ? "참" : "거짓";
		System.out.println(resultString);
	}

}
