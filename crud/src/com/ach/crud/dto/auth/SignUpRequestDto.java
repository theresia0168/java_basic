package com.ach.crud.dto.auth;

import java.util.Scanner;

// DTO(Data Transfer Object): 모듈 간 데이터 전송을 위한 객체
public class SignUpRequestDto {
	private String id;
	private String pwd;
	private String pwdCheck;
	private String nickname;
	
	public SignUpRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID: ");
		this.id = scanner.nextLine();
		// 비밀번호 입력
		System.out.print("PASSWORD: ");
		this.pwd = scanner.nextLine();
		// 비밀번호 확인
		System.out.print("PASSWORD CHECK: ");
		this.pwdCheck = scanner.nextLine();
		// 닉네임 입력
		System.out.print("NICKNAME: ");
		this.nickname = scanner.nextLine();
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getPwdCheck() {
		return pwdCheck;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public String toString() {	// 단순히 클래스를 출력할 때 주소가 아닌 아래의 내용이 출력되도록 하는 코드
		return "SignUpRequestDto [id=" + id + ", pwd=" + pwd + ", pwdCheck=" + pwdCheck + ", nickname=" + nickname
				+ "]";
	}
	
	public boolean validate() {
		if(!this.isNotNull()) {
			System.out.println("Please enter everything.");
			return false;
		}
		if(!this.idValidate()) {
			System.out.println("ID must be at least six characters long.");
			return false;
		}
		if(!this.pwdValidate()) {
			System.out.println("PASSWORD must be at least eight characters long.");
			return false;
		}
		if(!this.pwdCheckValidate()) {
			System.out.println("Please check the PASSWORD again.");
			return false;
		}
		if(!this.nicknameValidate()) {
			System.out.println("NICKNAME cannot be empty or consist only of spaces");
			return false;
		}
		return true;
	}
	
	private boolean idValidate() {
		return this.id.length()>=6;
	}
	
	private boolean pwdValidate() {
		return this.pwd.length()>=8;
	}
	
	private boolean pwdCheckValidate() {
		return this.pwd.equals(this.pwdCheck);
	}
	
	private boolean nicknameValidate() {
		return !this.nickname.isBlank();
	}
	
	private boolean isNotNull() {
		return this.id != null && this.pwd !=null && this.pwdCheck != null && this.nickname != null;
	}
}
