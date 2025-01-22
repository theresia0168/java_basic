package com.ach.crud.controller;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostViewRequestDto;

public interface BoardController {
	void newPost(NewPostRequestDto requestDto, String id);
	void viewPostList();
	void viewPost(PostViewRequestDto requestDto);
	void updatePostById(String id);
	void deletePostById(String id);
}
