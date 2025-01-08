package pathsofglory;

public class OnBoard{
	void putIn() {
		
	}
	void putOut() {
		
	}
}

class Track {
	int turn;
	int victoryPoint;
	int warStatusCP;
	int warStatusAP;
	int warStatusTotal;
	
	Track(){
		this.turn = 1;
		this.victoryPoint = 10;
		this.warStatusCP = 0;
		this.warStatusAP = 0;
		this.warStatusTotal = this.warStatusCP + this.warStatusAP;
	}
}

abstract class ReplacementTrack {
	abstract void rpCardUsed(int opValue, int cardID);
	abstract void rpReset();
}

class ReplacementTrackCP extends ReplacementTrack {
	int gerRP;		// 독일 RP
	int ahRP;		// 오헝 RP
	int tuRP;		// 터키 RP
	int buRP;		// 불가리아 RP
	
	ReplacementTrackCP(){
		this.gerRP = 0;
		this.ahRP = 0;
		this.tuRP = 0;
		this.buRP = 0;
	}
	
	void rpCardUsed(int opValue, int cardID) {
		switch(opValue) {
			case 2:
				this.gerRP+=1;
				break;
			case 3:
				this.gerRP+=2;
				this.ahRP+=1;
				this.tuRP+=1;
				break;
			case 4:
				this.gerRP+=3;
				this.ahRP+=2;
				this.tuRP+=1;
				this.buRP+=1;
				break;
			case 5:
				this.gerRP+=4;
				this.ahRP+=3;
				this.tuRP+=2;
				if(cardID!=34) {
					this.buRP+=1;
				}
				break;
		}
	}
	
	void rpReset() {
		this.gerRP = 0;
		this.ahRP = 0;
		this.tuRP = 0;
		this.buRP = 0;
	}
}

class ReplacementTrackAP extends ReplacementTrack {
	int alliedRP;
	int brRP;
	int frRP;
	int itRP;
	int ruRP;
	int usRP;
	
	ReplacementTrackAP(){
		this.alliedRP = 0;
		this.brRP = 0;
		this.frRP = 0;
		this.itRP = 0;
		this.ruRP = 0;
		this.usRP = 0;
	}
	
	void rpCardUsed(int opValue, int cardID) {
		switch(opValue) {
			case 2:
				this.brRP+=1;
				this.frRP+=1;
				this.ruRP+=1;
				break;
			case 3:
				this.brRP+=1;
				this.frRP+=1;
				this.itRP+=1;
				this.ruRP+=2;
				break;
			case 4:
				this.alliedRP+=1;
				this.brRP+=2;
				this.frRP+=2;
				this.itRP+=1;
				this.ruRP+=3;
		}
	}
	
	void rpReset() {
		this.alliedRP = 0;
		this.brRP = 0;
		this.frRP = 0;
		this.itRP = 0;
		this.ruRP = 0;
		this.usRP = 0;
	}
}

class Location {
	String terrain;
	int fortLevel;
	int trenchLevel;
	String occupation;
	
	Location(){
		this.terrain = "Clear";
		this.fortLevel = 0;
		this.trenchLevel = 0;
		this.occupation = null;
	}
	Location(String terrain, String occupation){
		this.terrain = terrain;
		this.occupation = occupation;
	}
	Location(int fortLevel, int trenchLevel, String occupation){
		this.fortLevel = fortLevel;
		this.trenchLevel = trenchLevel;
		this.occupation = occupation;
	}
	Location(String terrain, int trenchLevel, String occupation){
		this.terrain = terrain;
		this.trenchLevel = trenchLevel;
		this.occupation = occupation;
	}
}


