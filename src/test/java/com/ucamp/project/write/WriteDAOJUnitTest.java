package com.ucamp.project.write;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ucamp.project.dto.boardDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class WriteDAOJUnitTest {

	@Autowired
	private WriteDAO wDao;
	
//	@Test
//	public void diaryWriteTest() {
//		try {
//			int result = wDao.diaryWrite("사랑이라는 제시어로 작성2", "eunbin", "111");
//			Assert.assertTrue(result == 1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void diaryModifyTest() {
//		try {
//			int result = wDao.diaryModify("eunbin", "44", "사랑이라는 제시어로 작성한 글을 수정함");
//			Assert.assertTrue(result == 1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void diaryRemoveTest() {
//		try {
//			int result = wDao.diaryRemove("eunbin", "43");
//			Assert.assertTrue(result == 1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void searchByPenNameTest() {
		try {
			Collection<boardDTO> list = wDao.searchByPenName("수다쟁이");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void searchBySuggestionNameTest() {
		try {
			Collection<boardDTO> list = wDao.searchBySuggestionName("사랑");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getHomeBoardListTest() {
		try {
			Collection<boardDTO> list = wDao.getHomeBoardList("110");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void setShareStatusTest() {
		try {
			int result = wDao.setShareStatus("개인", "1", "test1");
			Assert.assertTrue(result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getNewBoardListTest() {
		try {
			Collection<boardDTO> list = wDao.getNewBoardList();
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getNowRecommendedBoardListTest() {
		try {
			Collection<boardDTO> list = wDao.getNowRecommendedBoardList();
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEmotionCodeTest() {
		try {
			String emotionCode = wDao.getEmotionCode("즐거워요");
			Assert.assertTrue(emotionCode.equals("110"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getFriendWriteListTest() {
		try {
			Collection<boardDTO> list= wDao.getFriendWriteList("test1");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getTrendWriteTest() {
		try {
			Collection<boardDTO> list= wDao.getTrendWrite("110");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getBookmarkedWriteListTest() {
		try {
			Collection<boardDTO> list= wDao.getBookmarkedWriteList("eunbin");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getBookmarkedWriteTest() {
		try {
			boardDTO bo= wDao.getBookmarkedWrite("eunbin", "6");
			Assert.assertNotNull(bo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSearchResultWriteTest() {
		try {
			Collection<boardDTO> list= wDao.getSearchResultWrite("수다쟁이", "사랑", "2022-06-11");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void myWritingTest() {
		try {
			Collection<boardDTO> list= wDao.myWriting("eunbin");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMyPageSearchTest() {
		try {
			Collection<boardDTO> list= wDao.getMyPageSearch("eunbin", "2022-06-11");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMyPageWriteTest() {
		try {
			boardDTO bo= wDao.getMyPageWrite("eunbin", "44");
			Assert.assertNotNull(bo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getWriteDetailTest() {
		try {
			boardDTO bo= wDao.getWriteDetail("44");
			Assert.assertNotNull(bo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getSuggestionNameTest() {
		try {
			String[] bo= wDao.getSuggestionName("44");
			Assert.assertNotNull(bo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
