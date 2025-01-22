package com.ach.crud.service.implement;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostViewRequestDto;
import com.ach.crud.dto.auth.UpdatePostRequestDto;
import com.ach.crud.entity.PostEntity;
import com.ach.crud.entity.UserEntity;
import com.ach.crud.repository.BoardRepository;
import com.ach.crud.service.BoardService;

public class BoardServiceImplement implements BoardService {

	private final BoardRepository boardRepository;
	
	public BoardServiceImplement(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@Override
	public void newPost(NewPostRequestDto requestDto, String id) {
		PostEntity postEntity = new PostEntity(requestDto, id);

		this.boardRepository.newPost(requestDto, id);
		System.out.println("Successfully posted.");
	}

	@Override
	public void viewPostList() {
		System.out.println("Post Number | Post Title | Posted User Nickname | Date");
		this.boardRepository.viewPostList();
	}

	@Override
	public void viewPost(PostViewRequestDto requestDto) {
		
		this.boardRepository.viewPost(requestDto);
	}

	@Override
	public void updatePostById(UpdatePostRequestDto requestDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePostById(String id) {
		// TODO Auto-generated method stub

	}

}
