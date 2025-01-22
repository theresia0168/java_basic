package com.ach.crud.entity;

import java.time.LocalDate;

import com.ach.crud.dto.auth.NewPostRequestDto;

public class PostEntity {
	private String title;
	private String contents;
	private String postedUserId;
	private String postedUserNickname;
	private String postedDate;
	
	public PostEntity(String title, String contents, String nickname, String date) {
		this.title = title;
		this.contents = contents;
		this.postedUserNickname = nickname;
		this.postedDate = date;
	}
	
	public PostEntity(NewPostRequestDto dto, String id) {
		this.title = dto.getTitle();
		this.contents = dto.getContents();
		this.postedUserId = id;
		this.postedDate = LocalDate.now().toString();
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public String getPostedUserId() {
		return postedUserId;
	}

	public String getPostedUserNickname() {
		return postedUserNickname;
	}
	
}
