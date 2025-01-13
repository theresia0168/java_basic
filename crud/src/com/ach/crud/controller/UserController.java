package com.ach.crud.controller;

import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;

public interface UserController {
	void getSignInUser(String id);
	void updateByNickname(UserNicknamePatchRequestDto requestDto, String id);
	void deleteSignInUser(UserInfoDeleteRequestDto requestDto, String id);
}
