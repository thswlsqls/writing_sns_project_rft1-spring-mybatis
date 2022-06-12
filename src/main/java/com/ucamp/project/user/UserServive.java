package com.ucamp.project.user;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucamp.project.dto.AppUserDTO;

@Service
public class UserServive {
	@Autowired
	private UserDAO UserDAO;
	
	public String login(String userId, String userPw) throws SQLException {
		return UserDAO.login(userId, userPw);
	}

	public boolean addUser(String userId
			, String name
			, String penName
			, String userPw
			, String email
			, String tel) throws SQLException {
		return UserDAO.addUser(userId, name, penName, userPw, email, tel);
	}
	
	public boolean addUser2(String userId
			, String name
			, String penName
			, String userPw
			, String email
			, String tel) throws SQLException {
		return UserDAO.addUser2(new AppUserDTO(userId, name, penName, userPw, email, tel));
	}
	
	

	/** IDã��
	 * select user_id from app_user where name = ? and email = ? 
	 * @throws SQLException */
	public String findId(String name
			, String email) 
					throws SQLException{
		return UserDAO.findId(name, email);
	};
	
	/** --4. PW ã�� 
		select user_pw from app_user where name = ? and email = ?;
	 */
	public String findPw(String name
			, String email) throws SQLException{
		return UserDAO.findId(name, email);
	};
	
	/**v2*/
//	/** IDã��
//	 * select user_id from app_user where name = ? and email = ? 
//	 * @throws SQLException */
//	public String findId(@Param("name")String name
//	, @Param("email")String email) throws SQLException;
//	
//	/** --4. PW ã�� 
//		select user_pw from app_user where name = ? and email = ?;
//	 */
//	public String findPw(@Param("name")String name
//				, @Param("email")String email) 
//					throws SQLException;
	
	//���̵� �ߺ�üũ �ߺ��� false �ߺ�X true
	public boolean checkUserId(String userId) throws SQLException{
		return (UserDAO.checkUserId(userId) == 1);
	};
	
	//�ʸ� �ߺ�üũ
	public boolean checkPenName(String penName) throws SQLException{
		return (UserDAO.checkPenName(penName) == 1);
	};

	//������ȣ Ȯ�ο�
    public String checkIdEmail(String userId
    		, String email) throws SQLException{
    	return UserDAO.checkIdEmail(userId, email);
    };
	
    //������ȣ�� ���̵�� ��й�ȣ �ٲٱ�
    public boolean setTemporaryPw(String userId
    		,String userPw) throws SQLException{
    	return UserDAO.setTemporaryPw(userId, userPw);
    };
	
}


