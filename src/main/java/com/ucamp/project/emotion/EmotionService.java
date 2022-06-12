package com.ucamp.project.emotion;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionService {

	@Autowired
	private EmotionDAO EmotionDAO;
	
	// 감정 8개 추출 / 새로고침
	public String getEmotionName(String mainEmotion) throws SQLException{
		return EmotionDAO.getEmotionName(mainEmotion);
	};
	
	public String getMyEmotionName(String id) throws SQLException{
		return EmotionDAO.getMyEmotionName(id);
	};
	
	
}
