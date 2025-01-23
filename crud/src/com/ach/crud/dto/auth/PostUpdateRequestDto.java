package com.ach.crud.dto.auth;

import java.util.Scanner;

public class PostUpdateRequestDto {
	private String title;
	private String contents;
	private int postNum;
	
	public PostUpdateRequestDto(int postNum) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Updated Title: ");
		this.title = scanner.nextLine();
		System.out.print("Updated Contents: ");
		this.contents = scanner.nextLine();
		this.postNum = postNum;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public int getPostNum() {
		return postNum;
	}
	
	public boolean validate() {
		if(titleValidate()&&contentsValidate()) return true;
		return false;
	}
	
	private boolean titleValidate() {
		return this.title!=null;
	}
	
	private boolean contentsValidate() {
		return this.contents!=null;
	}
}
