package chapter01;

import java.util.Scanner;

public class B_InputOuput {
	public static void main(String[] args) {
		// 콘솔에 출력하기 위한 메소드
		System.out.println("Print");
		System.out.print("Print");
		//ln이 있으면 다음 출력을 새로운 라인에 출력하는 것
		System.out.print("Pr");
		System.out.println("int");
		//PrintPrint로 출력된다
		
		// 입력 받기 위한 메소드 = Scanner
		// java.util.Scanner 클래스의 인스턴스 생성해서 .next___() 메서드로 입력 받는다
		Scanner scanner = new Scanner(System.in);
		System.out.print("Write down your name: ");
		String name = scanner.nextLine();
		System.out.print("Write down your age: ");
		final int AGE = scanner.nextInt();
		System.out.print("Write down your height: ");
		double height = scanner.nextDouble();
		
		System.out.println("Your name is " + name + 
							"\nYour age is " + AGE +
							"\nYour height is " + height);
		
		// 시스템으로부터 받은 자원을 반환하는 작업
		scanner.close();
	}
}
