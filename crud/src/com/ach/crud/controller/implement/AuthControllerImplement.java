package com.ach.crud.controller.implement;

import com.ach.crud.controller.AuthController;
import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;
import com.ach.crud.service.AuthService;

public class AuthControllerImplement implements AuthController {
	
	private final AuthService authService;

	public AuthControllerImplement(AuthService authService) {
		this.authService = authService;
	}
	
	@Override
	public void signUp(SignUpRequestDto requestDto) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외가 발생한다
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		
		if(!requestDto.validate()) {
			return;
		}
		
		this.authService.signUp(requestDto);
	}

	@Override
	public void signIn(SignInRequestDto requestDto) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return;
		
		this.authService.signIn(requestDto);
	}

}
