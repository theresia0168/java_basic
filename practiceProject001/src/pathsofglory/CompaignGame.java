package pathsofglory;

public class CompaignGame {
	public static void main(String[] args) {
		boolean endingCondition = false;
		Track totalTrack = new Track();
		while(endingCondition == false) {
			totalTrack.turn++;
			// Mandated Offensive Phase
			
			// Action Phase
			
			// Attrition Phase
			
			// Siege Phase
			
			// War Status Phase
			
			// Replacement Phase
			
			// Draw Strategy Card Phase
			
			// End of Turn
			if(totalTrack.turn == 20 || totalTrack.warStatusTotal >= 40) {
				// 20턴이 종료되거나, 종합 전쟁 상황이 40 이상일 시 게임이 끝난다.
				endingCondition = true;
			}
		}
		
	}
}
