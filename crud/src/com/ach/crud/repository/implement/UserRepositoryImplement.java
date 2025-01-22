package com.ach.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ach.crud.entity.UserEntity;
import com.ach.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {

	private final Connection connection;
	
	public UserRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addUser(UserEntity userEntity) {
		final String SQL = "INSERT INTO user VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userEntity.getId());
			preparedStatement.setString(2, userEntity.getPwd());
			preparedStatement.setString(3, userEntity.getNickname());
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		// DATABASE_LIST.add(userEntity);
	}
	
	@Override
	public boolean idDuplication(String id) {
		final String SQL = "SELECT * FROM user WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			// 커서를 이동시키는 작업
			while(resultSet.next()) {
				//String userId = resultSet.getString(1);
				String userId = resultSet.getString("id");
				if(userId.equals(id)) return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
		
//		for(UserEntity entity: DATABASE_LIST) {
//			if(entity.getId().equals(id)) return true;
//		}
//		return false;
	}

	@Override
	public UserEntity findById(String id) {	
		UserEntity userEntity = null;
		final String SQL = "SELECT * FROM user WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			// 커서를 이동시키는 작업
			if(resultSet.next()) {
				//String userId = resultSet.getString(1);
				String userId = resultSet.getString("id");
				String userPwd = resultSet.getString("pwd");
				String userNickname = resultSet.getString("nickname");
				userEntity = new UserEntity(userId, userPwd, userNickname);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return userEntity;
		
//		for (UserEntity entity: DATABASE_LIST) {
//			if (entity.getId().equals(id)) return entity;
//		}
//		return null;
	}

	@Override
	public void updateByNickname(String id, String nickname) {
		final String SQL = "UPDATE user SET nickname = ? WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		//for-each는 읽기만 가능하며 쓰기는 불가능하다
		//그러나 주소를 바꾸는 행위가 불가능한 것이지 주소를 매개로 하여 들어가 변경하는 것은 가능하다
//		for(UserEntity entity: DATABASE_LIST) {
//			if(entity.getId() == id) {
//				entity.setNickname(nickname);
//				break;
//			}
//		}
		
	}

	@Override
	public void deleteById(String id) {
		final String SQL = "DELETE FROM user WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
//		UserEntity userEntity = null;
//		for(UserEntity entity: DATABASE_LIST) {
//			if(entity.getId() == id) {
//				userEntity = entity;
//				break;
//			}
//		}
//		DATABASE_LIST.remove(userEntity);
//		return;
	}

	@Override
	public void deleteByEntity(UserEntity userEntity) {
		final String SQL = "DELETE FROM user WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userEntity.getId());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return;
//		DATABASE_LIST.remove(userEntity);
//		return;
	}

}
