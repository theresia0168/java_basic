package blackfriday;

import java.util.ArrayList;

public class Player {
	String name;
	int treasury;
	int gold;
	ArrayList<String> portfolio = new ArrayList<>();
	
	Player(String name, Market market){
		this.name = name;
		this.treasury = 100;
		this.gold = 0;
		String tmp;
		for(int i = 0; i < 5; i++) {
			tmp = market.marketList.get((int)(Math.random()*(market.marketList.size()-1)));
			this.portfolio.add(tmp);
			market.marketList.remove(tmp);
		}
	}
	
	void portfolioStatus() {
		System.out.println("=====" + this.name + "=====");
		System.out.println("Treasury: " + this.treasury + " $");
		System.out.println("Gold: " + this.gold + " EA");
		System.out.println("=====Stocks=====");
		System.out.println(this.portfolio);
	}
}
