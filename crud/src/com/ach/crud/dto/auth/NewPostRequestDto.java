package com.ach.crud.dto.auth;

import java.time.LocalDate;
import java.util.Scanner;

public class NewPostRequestDto {
	private String title;
	private String contents;
	private String date;
	
	public NewPostRequestDto() {
		Scanner scanner = new Scanner(System.in);
		// 제목, 내용 입력 받기
		System.out.print("Title: ");
		this.title = scanner.nextLine();
		System.out.print("Contents: ");
		this.contents = scanner.nextLine();
		this.date = LocalDate.now().toString();
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}
	
	public String getDate() {
		return date;
	}

	public boolean validate() {
		if(!titleValidate()) {
			System.out.println("Please enter the title.");
			return false;
		}
		if(!contentsValidate()) {
			System.out.println("Please enter the contents.");
			return false;
		}
		return true;
	}
	
	private boolean titleValidate() {
		return this.title!=null;
	}
	
	private boolean contentsValidate() {
		return this.contents!=null;
	}
}
