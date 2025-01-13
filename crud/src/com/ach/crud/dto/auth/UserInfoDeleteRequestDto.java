package com.ach.crud.dto.auth;

import java.util.Scanner;

public class UserInfoDeleteRequestDto {
	private String pwd;
	
	public UserInfoDeleteRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your new PASSWORD: ");
		this.pwd = scanner.nextLine();
	}
	
	public String getPwd() {
		return pwd;
	}

	public boolean validate() {
		if(!this.isNotNull()) {
			System.out.println("Please enter your PASSWORD.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return this.pwd!=null;
	}
}
