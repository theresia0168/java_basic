package test01;

public class Main {

	public static void main(String[] args) {
		// 1번 문제 출력
		int[] numList = {12, 4, 15, 46, 38, -2, 15};
		Question01 ex01 = new Question01();
		System.out.println("Question01 Answer: " + ex01.solution(numList));
		
		// 2번 문제 출력
		int[] array = {0, 1, 2, 3, 4};
		int[][] queries = {{0, 1},{1, 2},{2, 3}};
		Question02 ex02 = new Question02();
		int[] result02 = ex02.solution(array, queries);
		System.out.print("Question02 Answer: ");
		for(int n: result02) {
			System.out.print(n);
		}
		System.out.print("\n");
		
		// 3번 문제 출력
		Question03 ex03 = new Question03();
		int number = 123456789;
		System.out.println("Question03 Answer: " + ex03.solution(number));		
	}

}
