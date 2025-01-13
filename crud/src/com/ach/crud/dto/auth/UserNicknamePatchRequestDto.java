package com.ach.crud.dto.auth;

import java.util.Scanner;

public class UserNicknamePatchRequestDto {
	private String nickname;
	
	public UserNicknamePatchRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your new NICKNAME: ");
		this.nickname = scanner.nextLine();
	}
	
	public boolean validate() {
		if(!this.isNotNull()) {
			System.out.println("Please enter your NICKNAME.");
			return false;
		}
		if(!this.isNotBlank()) {
			System.out.println("NICKNAME cannot be empty or consist only of spaces.");
			return false;
		}
		return true;
	}
	
	public String getNickname() {
		return nickname;
	}

	private boolean isNotNull() {
		return this.nickname!=null;
	}
	
	private boolean isNotBlank() {
		return !this.nickname.isBlank();
	}
}
