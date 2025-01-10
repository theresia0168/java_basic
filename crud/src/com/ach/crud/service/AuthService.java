package com.ach.crud.service;

import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;

// Service: 실제 비즈니스 로직이 구현되는 모듈(레이어)
// 직접 비즈니스 로직 결과에 대한 데이터 검증 실시, 다음 로직을 위한 데이터 검증 실시
// 데이터베이스를 활용한 데이터 검증 작업, 각종 연산 및 로직 작성

public interface AuthService {
	// 회원가입
	/*public abstract 자동 적용*/void signUp(SignUpRequestDto requestDto);
	// 로그인
	void signIn(SignInRequestDto requestDto);
}
