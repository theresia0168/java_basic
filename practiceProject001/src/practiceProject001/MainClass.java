package practiceProject001;

class Company{
	int parValue = 1000;							// 액면가
	long numOfTotalStock = 100_000;					// 총 발행 주식량
	int stockPrice = parValue;						// 현 주가
	long marketCap = stockPrice * numOfTotalStock;	// 시가 총액
	int yesPrice;									// 전일 종가
	
	int tikSize() {	// 호가 단위를 결정하는 함수
		if(stockPrice < 2000) {
			return 1;
		}
		else if(stockPrice < 10000) {
			return 5;
		}
		else if(stockPrice < 20000) {
			return 10;
		}
		else if(stockPrice < 100000) {
			return 50;
		}
		else if(stockPrice < 200000) {
			return 100;
		}
		else {
			return 500;
		}
	}
	
	void volPoint() {
		
	}
}

public class MainClass {

	public static void main(String[] args) {
		Company Samsung = new Company();
		int count = 0;
		while(count != 365) {
			count++;
			for(int i = 9; i <= 15; i++) {
				for(int j = 0; j < 60; j++) {
					if(Math.random()>=0.5) {
						Samsung.stockPrice+=Samsung.tikSize();
					}
					else {
						Samsung.stockPrice-=Samsung.tikSize();
					}
					
				}
				if(i==15) {
					Samsung.yesPrice = Samsung.stockPrice;
				}
			}
			System.out.println("Day " + count + ": " + Samsung.stockPrice);
		}
	}
}
