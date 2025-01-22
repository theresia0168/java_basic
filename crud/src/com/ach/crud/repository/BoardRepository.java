package com.ach.crud.repository;

import java.util.ArrayList;
import java.util.List;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostViewRequestDto;
import com.ach.crud.entity.PostEntity;

public interface BoardRepository {
	
	List<PostEntity> POST_LIST = new ArrayList<>();
	
	void newPost(NewPostRequestDto requestDto, String id);
	void viewPostList();
	void viewPost(PostViewRequestDto requestDto);
	void updatePostById(String id);
	void deletePostById(String id);
}
