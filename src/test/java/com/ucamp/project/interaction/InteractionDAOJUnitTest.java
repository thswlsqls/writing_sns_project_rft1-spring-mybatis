package com.ucamp.project.interaction;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ucamp.project.dto.FollowListDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class InteractionDAOJUnitTest {

	@Autowired
	private InteractionDAO iDao;
	
	@Test
	public void addFollowTest() {
		try {
			int result = iDao.addFollow("test5", "test3");
			Assert.assertTrue(result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteFollowTest() {
		try {
			int result = iDao.deleteFollow("test5", "test3");
			Assert.assertTrue(result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getFollowListTest() {
		try {
			Collection<FollowListDTO> list = iDao.getFollowList("test2");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSortedByDateFollowListTest() {
		try {
			Collection<FollowListDTO> list = iDao.getSortedByDateFollowList("test2");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSortedByPenNameFollowListTest() {
		try {
			Collection<FollowListDTO> list = iDao.getSortedByPenNameFollowList("test2");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addReactionTest() {
		try {
			int result = iDao.addReaction("eunbin", "2");
			Assert.assertTrue(result==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteReactionTest() {
		try {
			int result = iDao.deleteReaction("eunbin", "2");
			Assert.assertTrue(result==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void isReactedTest() {
		try {
			int cnt = iDao.deleteReaction("test1", "2");
			Assert.assertTrue(cnt==0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void countReactionsTest() {
		try {
			int cnt = iDao.countReactions("2");
			Assert.assertTrue(cnt==0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addBookmarkTest() {
		try {
			int result = iDao.addBookmark("eunbin", "2");
			Assert.assertTrue(result==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteBookmarkTest() {
		try {
			int result = iDao.deleteBookmark("eunbin", "2");
			Assert.assertTrue(result==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void isBookmarkedTest() {
		try {
			int cnt = iDao.isBookmarked("eunbin", "2");
			Assert.assertTrue(cnt==0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
