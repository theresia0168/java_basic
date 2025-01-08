package blackfriday;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("블랙 프라이데이를 실행합니다.");
		System.out.print("인원수를 입력하세요(2-5인): ");
		Scanner scanner = new Scanner(System.in);
		int playerNum = scanner.nextInt();
		scanner.close();
		
		Market gameMarket = new Market(playerNum);
		
		Player player1 = new Player("Tom", gameMarket);
		Player player2 = new Player("Billy", gameMarket);
		Player player3 = new Player("Henry", gameMarket);
		player1.portfolioStatus();
		player2.portfolioStatus();
		player3.portfolioStatus();
		
		gameMarket.marketStatus();
	}

}
