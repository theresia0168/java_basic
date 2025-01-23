package com.ach.crud.service.implement;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;
import com.ach.crud.repository.BoardRepository;
import com.ach.crud.service.BoardService;

public class BoardServiceImplement implements BoardService {

	private final BoardRepository boardRepository;
	
	public BoardServiceImplement(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@Override	// 게시물 작성
	public void newPost(NewPostRequestDto requestDto, String id) {
		this.boardRepository.newPost(requestDto, id);
		System.out.println("Successfully posted.");
	}

	@Override	// 게시물 리스트 출력
	public void viewPostList() {
		System.out.println("Post Number | Post Title | Posted User Nickname | Date");
		this.boardRepository.viewPostList();
	}

	@Override	// 게시물 상세 보기
	public void viewPost(PostSelectRequestDto requestDto) {
		this.boardRepository.viewPost(requestDto);
	}

	@Override	// 게시물 수정
	public void updatePostById(PostUpdateRequestDto requestDto) {
		this.boardRepository.updatePostById(requestDto);
		System.out.println("Successfully Updated.");
	}

	@Override	// 게시물 삭제
	public void deletePostById(PostSelectRequestDto requestDto, String id) {
		// 존재하지 않는 게시물이거나 작성자가 아닐 시 종료
		if(!this.boardRepository.postAndPermissionExisitence(requestDto, id)) return;
		// 게시물 삭제
		this.boardRepository.deletePostById(requestDto);
		System.out.println("Successfully Deleted.");
	}

	@Override	// 게시물 존재 여부 및 권한 확인
	public boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id) {
		// 존재하지 않는 게시물이거나 작성자가 아닐 시 종료
		if(!this.boardRepository.postAndPermissionExisitence(requestDto, id)) return false;
		return true;
	}

}
