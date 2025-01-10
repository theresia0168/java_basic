package com.ach.crud.dto.auth;

import java.util.Scanner;

public class SignInRequestDto {
	private String id;
	private String pwd;
	
	public SignInRequestDto() {
		Scanner scanner = new Scanner(System.in);
		// 로그인을 위해 ID, 비밀번호 입력 받기
		System.out.print("ID: ");
		this.id = scanner.nextLine();
		System.out.print("PASSWORD: ");
		this.pwd = scanner.nextLine();
	}

	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	
	public boolean validate() {
		if(!isNotNull()) {
			System.out.println("Please enter everything.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return this.id!=null && this.pwd!=null;
	}
	
	
}
