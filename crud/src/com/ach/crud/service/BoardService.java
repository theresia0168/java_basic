package com.ach.crud.service;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;

public interface BoardService {
	// 게시물 작성
	void newPost(NewPostRequestDto requestDto, String id);
	// 게시물 리스트
	void viewPostList();
	// 게시물 상세 내용
	void viewPost(PostSelectRequestDto requestDto);
	// 게시물 수정
	void updatePostById(PostUpdateRequestDto requestDto);
	// 게시물 삭제
	void deletePostById(PostSelectRequestDto requestDto, String id);
	// 게시물 존재 여부 및 권한 확인
	boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id);
}
