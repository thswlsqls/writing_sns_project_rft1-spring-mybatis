package com.ucamp.project.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ucamp.project.dto.AppUserDTO;

@Repository
public interface UserDAO {

			/** �α���
			 *  select pen_name from app_user where user_id = ? and user_pw = ? 
			 * @throws SQLException */		
			public String login(@Param("userId")String userId
					, @Param("userPw")String userPw) 
							throws SQLException;

			/** ȸ������
			 *  insert into app_user
			 *  (user_id, name, pen_name, user_pw, email, tel)
			 *   values(?,?,?,?,?,?)
			 * @throws SQLException 
			 */
			public boolean addUser(@Param("userId")String userId
					, @Param("name")String name
					, @Param("penName")String penName
					, @Param("userPw")String userPw
					, @Param("email")String email
					, @Param("tel")String tel) 
							throws SQLException;
			
			/** ȸ������2 -> DTO���
			 *  insert into app_user
			 *  (user_id, name, pen_name, user_pw, email, tel)
			 *   values(?,?,?,?,?,?)
			 * @throws SQLException */
			public boolean addUser2(AppUserDTO appUser) 
							throws SQLException;
			
			/** IDã��
			 * select user_id from app_user where name = ? and email = ? 
			 * @throws SQLException 
			 */
			public String findId(@Param("name")String name
					, @Param("email")String email) 
							throws SQLException;
			
			/** --4. PW ã�� 
				select user_pw from app_user where name = ? and email = ?;
			 */
			public String findPw(@Param("name")String name
					, @Param("email")String email) throws SQLException;
			
			/**
			 * 	SELECT user_id 
				FROM app_user 
				WHERE name=#{name, jdbcType=VARCHAR} 
				AND email=#{email, jdbcType=VARCHAR}
			 * */
			public String selectUserId(@Param("name")String name
					,@Param("email")String email) throws SQLException;
			
			/**
			 * 	SELECT user_pw 
				FROM app_user 
				WHERE name=#{name, jdbcType=VARCHAR} 
				AND email=#{email, jdbcType=VARCHAR}
			 * */
			public String selectUserPw(@Param("name")String name
					,@Param("email")String email) throws SQLException;
			
			//���̵� �ߺ�üũ �ߺ��� false �ߺ�X true
			public int checkUserId(@Param("userId")String userId) 
					throws SQLException;
			
			//�ʸ� �ߺ�üũ
			public int checkPenName(@Param("penName")String penName) 
					throws SQLException;

			//������ȣ Ȯ�ο�
	        public String checkIdEmail(@Param("userId")String userId
	        		, @Param("email")String email) throws SQLException;
			
	        //������ȣ�� ���̵�� ��й�ȣ �ٲٱ�
	        public boolean setTemporaryPw(@Param("userId")String userId
	        		, @Param("userPw")String userPw) throws SQLException;
	
}



