package com.ach.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostViewRequestDto;
import com.ach.crud.repository.BoardRepository;

public class BoardRepositoryImplement implements BoardRepository {

	private final Connection connection;
	
	public BoardRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void newPost(NewPostRequestDto requestDto, String id) {
		final String SQL = "INSERT INTO board VALUES (NULL, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, requestDto.getTitle());
			preparedStatement.setString(2, requestDto.getContents());
			preparedStatement.setString(3, id);
			preparedStatement.setString(4, requestDto.getDate());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void viewPostList() {
		final String SQL = "SELECT B.postNum, B.title, U.nickname, B.postedDate "
				+ "FROM board B JOIN user U "
				+ "ON B.postedUserId = U.id "
				+ "ORDER BY B.postNum DESC";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			// 커서를 이동시키는 작업
			while(resultSet.next()) {
				String postNum = resultSet.getString(1);
				String title = resultSet.getString(2);
				String postedNickname = resultSet.getString(3);
				String date = resultSet.getString(4);
				System.out.println(postNum + " | " + title + " | " + postedNickname + " | " + date);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	@Override
	public void viewPost(PostViewRequestDto requestDto) {
		final String SQL = "SELECT B.title, U.nickname, B.postedDate, B.contents "
				+ "FROM board B JOIN user U "
				+ "ON B.postedUserId = U.id "
				+ "WHERE B.postNum = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, requestDto.getPostNum());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String title = resultSet.getString(1);
				String nickname = resultSet.getString(2);
				String date = resultSet.getString(3);
				String contents = resultSet.getString(4);
				/*
				 * 	아래와 같은 서식으로 게시물 세부 내용이 출력되도록 하였다.
				 * 	Title:
				 * 	Nickname:
				 * 	Date:
				 * 	Contents:
				 */
				System.out.println("Title: " + title);
				System.out.println("Nickname: " + nickname);
				System.out.println("Date: " + date);
				System.out.println("Contents:\n" + contents);
			}
			else {
				System.out.println("Post does not exist");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	@Override
	public void updatePostById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePostById(String id) {
		// TODO Auto-generated method stub

	}

}
