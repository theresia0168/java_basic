package com.ach.crud.dto.auth;

import java.util.Scanner;

public class PostSelectRequestDto {
	private int postNum;
	
	public PostSelectRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Post Number: ");
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
