package com.ach.crud.repository;

import java.util.ArrayList;
import java.util.List;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;
import com.ach.crud.entity.PostEntity;

public interface BoardRepository {
	
	List<PostEntity> POST_LIST = new ArrayList<>();
	
	void newPost(NewPostRequestDto requestDto, String id);
	void viewPostList();
	void viewPost(PostSelectRequestDto requestDto);
	void updatePostById(PostUpdateRequestDto requestDto);
	void deletePostById(PostSelectRequestDto requestDto);
	boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id);
}
