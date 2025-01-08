package chapter01;

import java.util.Scanner;

public class E_Control_While {

	public static void main(String[] args) {
		// while문: 반복 횟수가 결정되지 않은 반복문
		
		int num = 0;
		while(num < 10) {
			num++;
		}
		
		// 사용자로부터 입력받은 정수를 모두 더해 출력
		// 만약 사용자가 양수가 아닌 값을 입력하면 총합을 출력 후 프로그램 종료
		
		Scanner numScan = new Scanner(System.in);
		int number;
		int sum = 0;
		while(true) {
			System.out.print("Enter the (int)number: ");
			number = numScan.nextInt();
			if(number < 1) {
				System.out.println("Total value is " + sum);
				break;
			}
			sum = sum + number;
		}
		
		numScan.close();

		// continue: 반복문에서 continue를 만나면 코드 블럭의 끝으로 커서를 이동
		// break: 반복문에서 break를 만나면 반복문을 종료
		
		int a = 10;
		while(true) {
			a--;
			if(a == 0) {		// a가 0이 되면 반복문을 종료한다
				System.out.println("a's value is now 0");
				System.out.println("Program shut down");
				break;
			}
			if(a % 2 == 0) {	// a가 짝수라면 출력한다
				System.out.println("a is " + a);
			}
			else{				// a가 홀수일 경우 아무것도 출력하지 않고 넘어간다
				continue;
			}
			System.out.println("a is EVEN!!");
		}
		
		number = 0;
		while(number < 10) {
			if(number%3!=0) {
				continue;
			}
		}
	}

}
