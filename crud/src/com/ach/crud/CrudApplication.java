package com.ach.crud;

import java.util.Scanner;

import com.ach.crud.controller.AuthController;
import com.ach.crud.controller.implement.AuthControllerImplement;
import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;
import com.ach.crud.repository.UserRepository;
import com.ach.crud.repository.implement.UserRepositoryImplement;
import com.ach.crud.service.AuthService;
import com.ach.crud.service.implement.AuthServiceImplement;

public class CrudApplication {

	public static void main(String[] args) {
		UserRepository userRepository = new UserRepositoryImplement();
		AuthService authService = new AuthServiceImplement(userRepository);
		AuthController authController = new AuthControllerImplement(authService);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// 실행 이후 즉시 종료되지 않도록 하는 코드
			System.out.print("$ ");
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
		}
		scanner.close();
	}

}
