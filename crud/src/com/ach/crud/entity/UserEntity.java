package com.ach.crud.entity;

import com.ach.crud.dto.auth.SignUpRequestDto;

// Entity: 저장소 객체
public class UserEntity {
	private String id;
	private String pwd;
	private String nickname;
	
	public UserEntity(String id, String pwd, String nickname) {
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	
	public UserEntity(SignUpRequestDto dto) {
		this.id = dto.getId();
		this.pwd = dto.getPwd();
		this.nickname = dto.getNickname();
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
