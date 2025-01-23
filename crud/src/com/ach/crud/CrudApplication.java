package com.ach.crud;

import java.sql.Connection;
import java.util.Scanner;

import com.ach.crud.controller.AuthController;
import com.ach.crud.controller.BoardController;
import com.ach.crud.controller.UserController;
import com.ach.crud.controller.implement.AuthControllerImplement;
import com.ach.crud.controller.implement.BoardControllerImplement;
import com.ach.crud.controller.implement.UserControllerImplement;
import com.ach.crud.db.MySQLConnector;
import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;
import com.ach.crud.dto.auth.SignInRequestDto;
import com.ach.crud.dto.auth.SignUpRequestDto;
import com.ach.crud.dto.auth.UserInfoDeleteRequestDto;
import com.ach.crud.dto.auth.UserNicknamePatchRequestDto;
import com.ach.crud.repository.BoardRepository;
import com.ach.crud.repository.UserRepository;
import com.ach.crud.repository.implement.BoardRepositoryImplement;
import com.ach.crud.repository.implement.UserRepositoryImplement;
import com.ach.crud.service.AuthService;
import com.ach.crud.service.BoardService;
import com.ach.crud.service.UserService;
import com.ach.crud.service.implement.AuthServiceImplement;
import com.ach.crud.service.implement.BoardServiceImplement;
import com.ach.crud.service.implement.UserServiceImplement;


public class CrudApplication {
	
	public static String SESSION = null;

	public static void main(String[] args) {
		Connection connection = MySQLConnector.getInstance().getConnection();
		UserRepository userRepository = new UserRepositoryImplement(connection);
		BoardRepository boardRepository = new BoardRepositoryImplement(connection);
		AuthService authService = new AuthServiceImplement(userRepository);
		UserService userService = new UserServiceImplement(userRepository);
		BoardService boardService = new BoardServiceImplement(boardRepository);
		AuthController authController = new AuthControllerImplement(authService);
		UserController userController = new UserControllerImplement(userService);
		BoardController boardController = new BoardControllerImplement(boardService);
		
		Scanner scanner = new Scanner(System.in);
		
//		MySQLConnector mySQLConnector = MySQLConnector.getInstance();
//		Connection connection = mySQLConnector.getConnection();
		
		while(true) {
			String job = SESSION==null ? "(Sign in, Sign up)" : "(Info check, Info chg, ID delete, Board)";
			// 실행 이후 즉시 종료되지 않도록 하는 코드
			System.out.print("$ " + job + " ");
			String request = scanner.nextLine();
			request = request.toLowerCase();
			if(request.equals("exit")) {
				System.out.println("Program Exit");
				break;
			}
			
			if(request.equals("sign up")) {
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			
			if(request.equals("sign in")) {
				SignInRequestDto requestDto = new SignInRequestDto();
				authController.signIn(requestDto);
			}
			
			if(request.equals("info check")) {
				// 새로운 정보를 받아오지 않으므로 DTO를 받는 행위가 필요하지 않다.
				userController.getSignInUser(SESSION);
			}
			
			if(request.equals("info chg")) {
				UserNicknamePatchRequestDto requestDto = new UserNicknamePatchRequestDto();
				userController.updateByNickname(requestDto, SESSION);
			}
			
			if(request.equals("id delete")) {
				UserInfoDeleteRequestDto requestDto = new UserInfoDeleteRequestDto();
				userController.deleteSignInUser(requestDto, SESSION);
			}
			
			if(request.equals("board")) {
				System.out.print("$ (Post, List, View post, Update post, Delete post) ");
				request = scanner.nextLine();
				request = request.toLowerCase();
				
				if(request.equals("post")) {
					NewPostRequestDto requestDto = new NewPostRequestDto();
					boardController.newPost(requestDto, SESSION);
				}
				
				if(request.equals("list")) {
					boardController.viewPostList();
				}
				
				if(request.equals("view post")) {
					PostSelectRequestDto requestDto = new PostSelectRequestDto();
					// 입력 받을 때 숫자 형태로 받은 것이 맞는지 판단해줘야 함
					boardController.viewPost(requestDto);
				}
				
				if(request.equals("update post")) {
					PostSelectRequestDto requestDto1 = new PostSelectRequestDto();
					if(!boardController.postAndPermissionExisitence(requestDto1, SESSION)) {
						continue;
					}
					PostUpdateRequestDto requestDto2 = new PostUpdateRequestDto(requestDto1.getPostNum());
					boardController.updatePostById(requestDto2);
				}
				
				if(request.equals("delete post")) {
					PostSelectRequestDto requestDto = new PostSelectRequestDto();
					boardController.deletePostById(requestDto, SESSION);
				}
			}
		}
		scanner.close();
	}

}
