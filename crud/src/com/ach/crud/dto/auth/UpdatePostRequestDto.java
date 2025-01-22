package com.ach.crud.dto.auth;

import java.util.Scanner;

public class UpdatePostRequestDto {
	private String contents;
	
	public UpdatePostRequestDto() {
		Scanner scanner = new Scanner(System.in);
		// 수정할 내용 입력 받기
		System.out.print("Contents: ");
		this.contents = scanner.nextLine();
	}

	public String getContents() {
		return contents;
	}
	
	public boolean validate() {
		if(!isNotNull()) {
			System.out.println("Please enter the contents.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return this.contents!=null;
	}
}
