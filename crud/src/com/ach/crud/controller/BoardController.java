package com.ach.crud.controller;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;

public interface BoardController {
	void newPost(NewPostRequestDto requestDto, String id);
	void viewPostList();
	void viewPost(PostSelectRequestDto requestDto);
	void updatePostById(PostUpdateRequestDto requestDto);
	void deletePostById(PostSelectRequestDto requestDto, String id);
	boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id);
}
