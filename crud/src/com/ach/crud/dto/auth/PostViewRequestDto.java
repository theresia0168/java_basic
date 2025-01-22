package com.ach.crud.dto.auth;

import java.util.Scanner;

public class PostViewRequestDto {
	private int postNum;
	
	public PostViewRequestDto() {
		Scanner scanner = new Scanner(System.in);
		this.postNum = scanner.nextInt();
	}

	public int getPostNum() {
		return postNum;
	}
	
	public boolean validate() {
		if(this.isNotNegative()) return false;
		return true;
	}
	
	public boolean isNotNegative() {
		return this.postNum < 0;
	}
}
