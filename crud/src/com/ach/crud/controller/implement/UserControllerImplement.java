package com.ach.crud.controller.implement;

import com.ach.crud.controller.UserController;
import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;
import com.ach.crud.service.UserService;

public class UserControllerImplement implements UserController {

	public final UserService userService;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService;
	}
	@Override
	public void getSignInUser(String id) {	// 검증된 값을 받도록 한다
		if(id == null) {
			System.out.println("Not logged in.");
			return;
		}
		userService.getSignInUser(id);
		
	}
	@Override
	public void updateByNickname(UserNicknamePatchRequestDto requestDto, String id) {
		if(id == null) {
			System.out.println("Not logged in.");
			return;
		}
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) {
			return;
		}
		
		userService.patchSignInUser(requestDto, id);
	}
	@Override
	public void deleteSignInUser(UserInfoDeleteRequestDto requestDto, String id) {
		if(id == null) {
			System.out.println("Not logged in.");
			return;
		}
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) {
			return;
		}
		
		userService.deleteSignInUser(requestDto, id);
	}

}
