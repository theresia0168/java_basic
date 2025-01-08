package blackfriday;

public class Stock {
	int id;
	String name;
	int price;
	int issuedShares;
	int marketShares;
	
	Stock(int playerNum, int id, String name){
		this.price = 8;
		if(playerNum == 5) this.issuedShares = 25;
		else this.issuedShares = 24;
		this.id = id;
		this.name = name;
		this.marketShares = this.issuedShares;
	}
}
