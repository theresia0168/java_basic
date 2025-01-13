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

	@Override
	public void updateByNickname(String id, String nickname) {
		//for-each는 읽기만 가능하며 쓰기는 불가능하다
		//그러나 주소를 바꾸는 행위가 불가능한 것이지 주소를 매개로 하여 들어가 변경하는 것은 가능하다
		for(UserEntity entity: DATABASE_LIST) {
			if(entity.getId() == id) {
				entity.setNickname(nickname);
				break;
			}
		}
		
	}

	@Override
	public void deleteById(String id) {
		UserEntity userEntity = null;
		for(UserEntity entity: DATABASE_LIST) {
			if(entity.getId() == id) {
				userEntity = entity;
				break;
			}
		}
		DATABASE_LIST.remove(userEntity);
		return;
	}

	@Override
	public void deleteByEntity(UserEntity userEntity) {
		DATABASE_LIST.remove(userEntity);
		return;
	}

}
