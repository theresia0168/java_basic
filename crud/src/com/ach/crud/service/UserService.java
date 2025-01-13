package com.ach.crud.service;

import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;

public interface UserService {
	// 유저 정보 확인
	void getSignInUser(String id);
	// 유저 닉네임 변경
	void patchSignInUser(UserNicknamePatchRequestDto requestDto, String id);
	// 유저 정보 삭제
	void deleteSignInUser(UserInfoDeleteRequestDto requestDto, String id);
}
