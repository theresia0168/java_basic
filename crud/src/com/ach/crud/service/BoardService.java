package com.ach.crud.service;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostViewRequestDto;
import com.ach.crud.dto.auth.UpdatePostRequestDto;

public interface BoardService {
	// 게시물 작성
	void newPost(NewPostRequestDto requestDto, String id);
	// 게시물 리스트
	void viewPostList();
	// 게시물 상세 내용
	void viewPost(PostViewRequestDto requestDto);
	// 게시물 수정
	void updatePostById(UpdatePostRequestDto requestDto);
	// 게시물 삭제
	void deletePostById(String id);
}
