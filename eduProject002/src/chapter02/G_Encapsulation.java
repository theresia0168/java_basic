package chapter02;

// 캡슐화: 인스턴스 필드와 메소드를 하나로 묶어 필드에 대한 조작을 메소드를 통해서만 하도록 하는 것
// 정보 은닉, 데이터 보호, 데이터 무결성 보장 목적

// Entity: 데이터베이스의 레코드를 관리하는 객체
// (생성자와 getter만 유지하는 방식을 권장한다.
// DTO(Data Transfer Object): 데이터 전송을 위한 객체 
// (불변성: 생성자와 Getter만 유지 / 가변성: 생성자와 Getter, Setter 모두 유지)
// VO(Value Object): 값을 표현하는 객체
// (생성자와 Getter만 유지, Object 클래스의 equals() 메소드를 오버라이딩 해서 사용)

class Player {
	private	String name;
	private String team;
	private String birth;
	private int number;
	
	Player(String name, String team, String birth, int number) {
		this.name = name;
		this.team = team;
		this.birth = birth;
		this.number = number < 0 ? 0 : number;
	}
	
	// getter 메소드: 캡슐화에서 private 필드의 값을 반환하는 메소드
	String getName() {
		return this.name;
	}
	String getTeam() {
		return this.team;
	}
	String getBirth() {
		return this.birth;
	}
	int getNumber() {
		return this.number;
	}
	
	// setter 메소드: 캡슐화에서 private 필드의 값을 변경하는 메소드
	void setName(String name) {
		this.name = name;
	}
	void setTeam(String team) {
		this.team = team;
	}
	void setNumber(int number) {
		this.number = number < 0 ? 0 : number;
	}
}

class King {
	private String ho;
	private String name;
	
	public King(String ho, String name) {
		this.ho = ho;
		this.name = name;
	}

	public String getHo() {
		return ho;
	}
	public String getName() {
		return name;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}
	public void setName(String name) {
		this.name = name;
	}

}

public class G_Encapsulation {

	public static void main(String[] args) {
		
		Player player1 = new Player("Nickson", "USA", "1968-03-15", 1);
		System.out.println(player1.getName() + player1.getNumber());
		player1.setName("Tom");
		player1.setNumber(7);
		System.out.println(player1.getName() + player1.getNumber());

	}

}
