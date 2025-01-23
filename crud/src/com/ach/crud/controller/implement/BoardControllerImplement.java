package com.ach.crud.controller.implement;

import com.ach.crud.controller.BoardController;
import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;
import com.ach.crud.service.BoardService;

public class BoardControllerImplement implements BoardController {

	public final BoardService boardService;
	
	public BoardControllerImplement(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 게시물 작성
	@Override
	public void newPost(NewPostRequestDto requestDto, String id) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return;
		
		this.boardService.newPost(requestDto, id);
	}

	@Override
	public void viewPostList() {
		this.boardService.viewPostList();
	}

	@Override
	public void viewPost(PostSelectRequestDto requestDto) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return;
		this.boardService.viewPost(requestDto);
	}

	@Override
	public void updatePostById(PostUpdateRequestDto requestDto) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return;
		this.boardService.updatePostById(requestDto);
	}

	@Override
	public void deletePostById(PostSelectRequestDto requestDto, String id) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return;
		this.boardService.deletePostById(requestDto, id);
	}

	@Override
	public boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return false;	// void 함수를 강제로 종료시키는 방법
		}
		if(!requestDto.validate()) return false;
		return this.boardService.postAndPermissionExisitence(requestDto, id);
	}

}
