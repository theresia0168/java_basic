package com.ach.crud.repository.implement;

import com.ach.crud.entity.UserEntity;
import com.ach.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {

	@Override
	public void addUser(UserEntity userEntity) {
		DATABASE_LIST.add(userEntity);
	}
	
	@Override
	public boolean idDuplication(String id) {
		for(UserEntity entity: DATABASE_LIST) {
			if(entity.getId().equals(id)) return true;
		}
		return false;
	}

	@Override
	public UserEntity findById(String id) {
		for (UserEntity entity: DATABASE_LIST) {
			if (entity.getId().equals(id)) return entity;
		}
		return null;
	}

}
