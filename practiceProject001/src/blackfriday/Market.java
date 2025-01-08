package blackfriday;

import java.util.ArrayList;
import java.util.Random;

class SellTrack {
	ArrayList<String> sellTrack;
	ArrayList<String> blackToken;
	
	SellTrack(int blackNum, Market market){
		sellTrack = new ArrayList<>();
		blackToken = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			this.sellTrack.add("Tesla");
			this.sellTrack.add("Kakao");
			this.sellTrack.add("Naver");
			this.sellTrack.add("Samsung");
			this.sellTrack.add("Apple");
		}
		for(int i = 0; i < blackNum; i++) {
			this.blackToken.add("Black");
		}
		market.sellTrack.add(this);
	}
	
	void vanishTrack(Market market) {
		
	}
}

class StockBox {
	ArrayList<String> stockBox;
	int marketShare;
	int stockPrice;
	String name;
	
	StockBox(String stock, Market market){
		stockBox = new ArrayList<>();
		this.stockPrice = 8;
		for(int i = 0; i < 4; i++) {
			this.stockBox.add(stock);
		}
		this.name = stock;
		this.marketShare = stockBox.size();
		market.stockBox.add(this);
	}
	
	void stockAdd(Market market) {
		this.stockBox.add(this.name);
		market.marketList.remove(this.name);
	}
	
}

public class Market {
	ArrayList<String> marketList = new ArrayList<>();
	ArrayList<String> buyTrack = new ArrayList<>();
	ArrayList<String> goldBuyTrack = new ArrayList<>();
	ArrayList<SellTrack> sellTrack = new ArrayList<>();
	ArrayList<StockBox> stockBox = new ArrayList<>();
	
	int goldPrice;
	
	Market(int n){		
		this.goldPrice = 20;
		int totalShare = 0;
		if(n==5) {
			totalShare = 25;
			}
		else {
			totalShare = 24;
			}
		
		// 매도 트랙 생성
		SellTrack selltrack01 = new SellTrack(1, this);
		SellTrack selltrack02 = new SellTrack(2, this);
		SellTrack selltrack03 = new SellTrack(3, this);
		
		// 매물 시장 생성
		StockBox tesla = new StockBox("Tesla", this);
		StockBox kakao = new StockBox("Kakao", this);
		StockBox naver = new StockBox("Naver", this);
		StockBox samsung = new StockBox("Samsung", this);
		StockBox apple = new StockBox("Apple", this);
		
		for(int i = 0; i < totalShare-10; i++) {
			this.marketList.add("Tesla");
			this.marketList.add("Kakao");
			this.marketList.add("Naver");
			this.marketList.add("Samsung");
			this.marketList.add("Apple");
		}
		
		int stockIndex;
		for(int i = 0; i < 20; i++) {
			Random randomIndex = new Random();
			stockIndex = this.indexFinder(this.marketList.get(randomIndex.nextInt(this.marketList.size())));
			this.stockBox.get(stockIndex).stockAdd(this);
		}
		
	}
	
	int indexFinder(String Stock) {
		if(Stock == "Tesla")
			return 0;
		else if(Stock == "Kakao")
			return 1;
		else if(Stock == "Naver")
			return 2;
		else if(Stock == "Samsung")
			return 3;
		else
			return 4;
	}
	
	void marketStatus() {
		for(int i = 0; i < this.stockBox.size(); i++) {
			System.out.println(this.stockBox.get(i).stockBox);
		}
		System.out.println(this.marketList);
	}
	
	void marketToPlayer(Player player, Stock stock, int buyingQuan) {
		
	}
	
	void playerToMarket(int n) {
		
	}
	
	void goldPrice(int blackToken, int boughtGold) {
		
	}
}
