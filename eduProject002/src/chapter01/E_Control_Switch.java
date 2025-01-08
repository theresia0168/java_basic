package chapter01;

import java.util.Scanner;

public class E_Control_Switch {

	public static void main(String[] args) {
		// switch문: 특정 변수 혹은 조건식에 따라 실행할 코드 블럭의 범위를 결정한다
		
		switch(3) {
			case 3:
				System.out.println("Hello");
				break;
			case 4:
				System.out.println("Cannot be printed");
				break;
			default:
				System.out.println("Default");
				break;
		}
		
		// number라는 정수형 변수에 사용자로부터 정수를 입력 받아 할당
		// 0이면 A, B, C를 출력
		// 1이면 B, C 출력
		// 2이면 C 출력
		// 3이면 D, E 출력
		// 0-3이 아니면 E 출력
		
		Scanner numScan = new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		int num = numScan.nextInt();
		
		switch(num) {
			case 0:
				System.out.print("A");
			case 1:
				System.out.print("B");
			case 2:
				System.out.println("C");
				break;
			case 3:
				System.out.print("D");
			default:
				System.out.println("E");
				break;
		}
		numScan.close();
	}

}
