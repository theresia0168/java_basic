package com.ach.crud;

import java.util.Scanner;

import com.ach.crud.controller.AuthController;
import com.ach.crud.controller.UserController;
import com.ach.crud.controller.implement.AuthControllerImplement;
import com.ach.crud.controller.implement.UserControllerImplement;
import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;
import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;
import com.ach.crud.repository.UserRepository;
import com.ach.crud.repository.implement.UserRepositoryImplement;
import com.ach.crud.service.AuthService;
import com.ach.crud.service.UserService;
import com.ach.crud.service.implement.AuthServiceImplement;
import com.ach.crud.service.implement.UserServiceImplement;

// 로그인 유저 정보 삭제
// 입력 > 비밀번호
// 출력 > 콘솔출력 성공했습니다

// DTO null 여부만 판단
// UserController, UserService, UserRepository
// deleteSignInUser, deleteById
// controller -> service -> repository
// DIP 준수

public class CrudApplication {
	
	public static String SESSION = null;

	public static void main(String[] args) {
		UserRepository userRepository = new UserRepositoryImplement();
		AuthService authService = new AuthServiceImplement(userRepository);
		UserService userService = new UserServiceImplement(userRepository);
		AuthController authController = new AuthControllerImplement(authService);
		UserController userController = new UserControllerImplement(userService);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String job = SESSION==null ? "(Sign in, Sign up)" : "(Info check, Info chg, ID delete)";
			// 실행 이후 즉시 종료되지 않도록 하는 코드
			System.out.print("$ " + job + " ");
			String request = scanner.nextLine();
			if(request.equals("exit")) {
				System.out.println("Program Exit");
				break;
			}
			
			if(request.equals("Sign up")) {
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			
			if(request.equals("Sign in")) {
				SignInRequestDto requestDto = new SignInRequestDto();
				authController.signIn(requestDto);
			}
			
			if(request.equals("Info check")) {
				// 새로운 정보를 받아오지 않으므로 DTO를 받는 행위가 필요하지 않다.
				userController.getSignInUser(SESSION);
			}
			
			if(request.equals("Info chg")) {
				UserNicknamePatchRequestDto requestDto = new UserNicknamePatchRequestDto();
				userController.updateByNickname(requestDto, SESSION);
			}
			
			if(request.equals("ID delete")) {
				UserInfoDeleteRequestDto requestDto = new UserInfoDeleteRequestDto();
				userController.deleteSignInUser(requestDto, SESSION);
			}
		}
		scanner.close();
	}

}
