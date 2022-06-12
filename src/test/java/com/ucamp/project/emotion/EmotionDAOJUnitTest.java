package com.ucamp.project.emotion;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ucamp.project.dto.boardDTO;
import com.ucamp.project.emotion.EmotionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class EmotionDAOJUnitTest {
	
	@Autowired
	private EmotionDAO eDao;
	
//	@Test
//	public void getEmotionNameTest() {
//		try {
//			String emotionName = eDao.getEmotionName("±â»Ý");
//			Assert.assertNotNull(emotionName);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void addEmpathyTest() {
//		try {
//			int result = eDao.addEmpathy("eunbin", "110");
//			Assert.assertTrue(result==1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void getMyEmotionNameTest() {
//		try {
//			String emotionCode = eDao.getMyEmotionName("eunbin");
//			Assert.assertNotNull(emotionCode);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void getTrendEmotionTest() {
		try {
			Collection<String> list = eDao.getTrendEmotion();
			Assert.assertNotNull(list);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void getTrendWriteTest() {
		try {
			Collection<boardDTO> list = eDao.getTrendWrite("110");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void selectSuggestionTest() {
		try {
			Collection<String> suggestionName = eDao.selectSuggestion("eunbin");
			Assert.assertNotNull(suggestionName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSuggestionCodeTest() {
		try {
			Collection<String> suggestionCode = eDao.getSuggestionCode("³ë·¡");
			Assert.assertNotNull(suggestionCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEmotionCodeTest() {
		try {
			String emotionCode = eDao.getEmotionCode("Áñ°Å¿ö¿ä");
			Assert.assertNotNull(emotionCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEmotionNameByEympathyTest() {
		try {
			Collection<String> list = eDao.getEmotionNameByEympathy("eunbin");
			Assert.assertNotNull(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
