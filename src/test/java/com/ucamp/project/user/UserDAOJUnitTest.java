package com.ucamp.project.user;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ucamp.project.user.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDAOJUnitTest {
	
	@Autowired
	private UserDAO uDao;
	
	@Test
	public void loginTest() {
		try {
			String penName = uDao.login("userTest9", "1234abcd");
			Assert.assertNotNull(penName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findIdTest() {
		try {
			String userId = uDao.findId("테스트9", "userTest9@naver.com");
			Assert.assertNotNull(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findPwTest() {
		try {
			String userPw = uDao.findPw("테스트9", "userTest9@naver.com");
			Assert.assertNotNull(userPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectUserIdTest() {
		try {
			String userId = uDao.selectUserId("테스트9", "userTest9@naver.com");
			Assert.assertNotNull(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectUserPwTest() {
		try {
			String userPw = uDao.selectUserPw("테스트9", "userTest9@naver.com");
			Assert.assertNotNull(userPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkUserIdTest() {
		try {
			int cnt = uDao.checkUserId("userTest9");
			Assert.assertEquals(1, cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkPenNameTest() {
		try {
			int cnt = uDao.checkPenName("테스트9");
			Assert.assertEquals(1, cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkIdEmailTest() {
		try {
			String penName = uDao.checkIdEmail("userTest9", "userTest9@naver.com");
			Assert.assertNotNull(penName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
