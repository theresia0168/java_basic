package pathsofglory;

abstract public class Unit {
	int unitId;				// 부대 번호
	int combatFactor;		// 전투력
	int lossFactor;			// 손실 능력
	int movementFactor;		// 이동력
	int step;				// 단계, 스텝, 체력
	String nationality;		// 국적
	String location;		// 현 위치
	
	abstract void stepLoss();
	abstract void unitEliminated();
	abstract void unitCreate();
}

class GermanArmy extends Unit {
	GermanArmy(int id, String location) {
		this.unitId = id;
		this.combatFactor = 5;
		this.lossFactor = 3;
		this.movementFactor = 3;
		this.step = 2;
		this.nationality = "Germany";
		this.location = location;
	}
	
	@Override
	void stepLoss() {
		this.step--;
		if(this.step == 1) {
			this.combatFactor = 3;
		}
		else if(this.step == 0) {
			this.unitEliminated();
		}
	}
	
	@Override
	void unitCreate() {
		
	}
	
	@Override
	void unitEliminated() {
		// this.location = 
	}
	
	void scenarioUnitSetting() {
		GermanArmy german1Army = new GermanArmy(1, "Sedan");
	}
}
