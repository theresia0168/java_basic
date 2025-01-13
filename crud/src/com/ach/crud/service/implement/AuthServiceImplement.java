package com.ach.crud.service.implement;

import com.ach.crud.CrudApplication;
import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;
import com.ach.crud.entity.UserEntity;
import com.ach.crud.repository.UserRepository;
import com.ach.crud.service.AuthService;

public class AuthServiceImplement implements AuthService {
	
	private final UserRepository userRepository;
	
	public AuthServiceImplement(UserRepository userRepository){
		this.userRepository = userRepository;	// 추상적인 인터페이스에 의존 중
	}

	@Override
	public void signUp(SignUpRequestDto requestDto) {
		// 저장소(repository)에서 아이디 중복 확인
		String id = requestDto.getId();
		boolean idDuplication = this.userRepository.idDuplication(id);
		// -중복 아이디라면 '중복된 아이디입니다' 출력 후 메소드 종료
		if(idDuplication) {
			System.out.println("Your ID is duplicated with other ID");
			return;
		}
		// 해당 유저 정보를 저장소에 저장 후 '성공했습니다' 출력
//		String pwd = requestDto.getPwd();
//		String nickname = requestDto.getNickname();
		
		// UserEntity List에 신규 User 추가
		UserEntity userEntity = new UserEntity(requestDto);
		this.userRepository.addUser(userEntity);
		System.out.println("Successfully Signed Up!");

	}

	@Override
	public void signIn(SignInRequestDto requestDto) {
		// 아이디에 해당하는 정보가 있는지 확인 (인스턴스를 찾는다)
		String id = requestDto.getId();
		UserEntity userEntity = userRepository.findById(id);
		// -존재하지 않는다면 "로그인 실패" 출력 후 메소드 종료
		if(userEntity == null) {
			System.out.println("Login failed.");
			return;
		}
		// 찾은 정보의 비밀번호와 입력한 비밀번호가 같은지 확인
		String pwd = requestDto.getPwd();
		String existPwd = userEntity.getPwd();
		if(existPwd == pwd) {
			System.out.println("Login failed.");
			return;
		}
		// -같지 않다면 "로그인 실패" 출력 후 메소드 종료
		// 로그인 정보 저장
		CrudApplication.SESSION = id;
		// '로그인 성공' 출력
		System.out.println("Login success.");
	}

}
