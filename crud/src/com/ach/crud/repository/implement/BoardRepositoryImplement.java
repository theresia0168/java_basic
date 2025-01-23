package com.ach.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ach.crud.dto.auth.NewPostRequestDto;
import com.ach.crud.dto.auth.PostSelectRequestDto;
import com.ach.crud.dto.auth.PostUpdateRequestDto;
import com.ach.crud.repository.BoardRepository;

public class BoardRepositoryImplement implements BoardRepository {

	private final Connection connection;
	
	public BoardRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override	// 게시물 작성
	public void newPost(NewPostRequestDto requestDto, String id) {
		final String SQL = "INSERT INTO board VALUES (NULL, ?, ?, ?, ?)";
		// INSERT 문으로 새 게시물 작성 및 삽입
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			// 제목, 내용, 작성자 id, 작성일자 저장
			preparedStatement.setString(1, requestDto.getTitle());
			preparedStatement.setString(2, requestDto.getContents());
			preparedStatement.setString(3, id);
			preparedStatement.setString(4, requestDto.getDate());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override	// 게시물 리스트 출력
	public void viewPostList() {
		final String SQL = "SELECT B.postNum, B.title, U.nickname, B.postedDate "
				+ "FROM board B INNER JOIN user U "
				+ "ON B.postedUserId = U.id "
				+ "ORDER BY B.postNum DESC";
			// 모든 게시물의 게시물 번호, 제목, 작성자 닉네임, 작성일자를 출력
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
	public void viewPost(PostSelectRequestDto requestDto) {
		final String SQL = "SELECT B.title, U.nickname, B.postedDate, B.contents "
				+ "FROM board B INNER JOIN user U "
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
				System.out.println("Post does not exist.");
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	@Override
	public void updatePostById(PostUpdateRequestDto requestDto) {
		final String SQL = "UPDATE board SET title = ?, contents = ? WHERE postNum = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, requestDto.getTitle());
			preparedStatement.setString(2, requestDto.getContents());
			preparedStatement.setInt(3, requestDto.getPostNum());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public void deletePostById(PostSelectRequestDto requestDto) {
		final String SQL = "DELETE FROM board WHERE postNum = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, requestDto.getPostNum());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public boolean postAndPermissionExisitence(PostSelectRequestDto requestDto, String id) {
		final String SQL = "SELECT postNum, postedUserId FROM board WHERE postNum = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, requestDto.getPostNum());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				System.out.println("Post does not exist.");
				return false;
			}
			else if(!resultSet.getString("postedUserID").equals(id)) {
				System.out.println("You don't have a permission!");
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}

}
