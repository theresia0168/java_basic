package chapter03;

import java.time.LocalDateTime;
import java.time.Month;

// 열거형(Enum): 서로 관련된 상수들의 집합을 나타내는 특수한 클래스
// enum 열거형타입이름 { 상수, ... }
enum Color1 {
	// 지정하고자 하는 상수를 ,로 나열
	RED, BLUE, YELLOW, ORANGE, GREEN, BLACK, WHITE, PURPLE, GRAY, IVORY
}

enum Color2 {
	// 생성자 호출을 열거된 상수 위치에서 호출함
	RED("#ff0000","rgb(255, 0, 0)"), 
	BLUE("#0000ff", "rgb(0, 0, 255)"), 
	GREEN("#00ff00", "rgb(0, 255, 0)");
	
	// 열거형도 클래스이기 때문에 필두, 생성자, 메소드를 가질 수 있다
	// enum의 필드는 상수로 사용되기 때문에 변경되면 안된다
	// 따라서 캡슐화 작업이 필요하다
	private final String hex;
	private final String rgb;
	
	// 생성자의 접근제어자 private
	// 인스턴스 생성 자체를 외부에서 할 수 없도록 방지
	private Color2(String hex, String rgb){
		this.hex = hex;
		this.rgb = rgb;
	}
	
	public String getHex() {
		return hex;
	}
	
	public String getRgb() {
		return rgb;
	}
}

public class G_Enum {

	public static void main(String[] args) {
		Color1 color1 = Color1.BLACK;
		System.out.println(color1);
		
		// 열거형을 사용하면 조건(동등 비교)에 편하게 사용 가능
		if(color1 == Color1.BLACK) {
			System.out.println("Black");
		}
		
		if(color1.equals("BLACK"))
			System.out.println(true);
		else
			System.out.println(false);
		
		// 열거형을 사용하면 상수를 묶음으로 관리할 수 있음
		Color2 color2 = Color2.BLUE;
		System.out.println(color2);
//		System.out.println(color2.hex);
//		System.out.println(color2.rgb);
//		color2.hex = "#000099";
//		System.out.println(color2.hex);
		
		System.out.println(color2.getHex());
		System.out.println(color2.getRgb());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Month month = localDateTime.getMonth();
		
		switch(month) {
		case APRIL:
			System.out.println("Spring!");
		}
	}

}
