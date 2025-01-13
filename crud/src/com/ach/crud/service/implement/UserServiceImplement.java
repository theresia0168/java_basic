package com.ach.crud.service.implement;

import com.ach.crud.CrudApplication;
import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;
import com.ach.crud.entity.UserEntity;
import com.ach.crud.repository.UserRepository;
import com.ach.crud.service.UserService;

public class UserServiceImplement implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository){
		this.userRepository = userRepository;	// 추상적인 인터페이스에 의존 중
	}
	
	@Override
	public void getSignInUser(String id) {
		// 유저 정보를 저장소에서 불러오기
		UserEntity userEntity = userRepository.findById(id);
		if(userEntity == null) {
			System.out.println("Can't find user information.");
			return;
		}
		System.out.println("ID: " + userEntity.getId());
		System.out.println("NICKNAME: " + userEntity.getNickname());
	}

	@Override
	public void patchSignInUser(UserNicknamePatchRequestDto requestDto, String id) {
		boolean existedUser = userRepository.idDuplication(id);
		if(!existedUser) {
			System.out.println("Can't find user information.");
			return;
		}
		String nickname = requestDto.getNickname();
		userRepository.updateByNickname(id, nickname);
		System.out.println("Successfully changed.");
	}

	@Override
	public void deleteSignInUser(UserInfoDeleteRequestDto requestDto, String id) {
		UserEntity userEntity = userRepository.findById(id);
		if(userEntity == null) {
			System.out.println("Can't find user information.");
			return;
		}
		String pwd = requestDto.getPwd();
		String existPassword = userEntity.getPwd();
		
		if(!existPassword.equals(pwd)) {
			System.out.println("Wrond PASSWORD!!");
			return;
		}
		
		//userRepository.deleteById(id);
		userRepository.deleteByEntity(userEntity);
		CrudApplication.SESSION = null;
		System.out.println("ID Deleted.");
	}

}
