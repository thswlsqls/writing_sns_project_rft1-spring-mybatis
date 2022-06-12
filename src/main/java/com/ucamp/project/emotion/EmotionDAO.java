package com.ucamp.project.emotion;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ucamp.project.dto.boardDTO;

@Repository
public interface EmotionDAO {

	// 감정 8개 추출 / 새로고침
	public String getEmotionName(@Param("mainEmotion")String mainEmotion) 
			throws SQLException;
    /**
     * select emotion_code from empathy where user_id = ? "
	  + "and to_char(empathy_date,'yyyy-mm-dd') = to_char(sysdate,'yyyy-mm-dd')
     **/
	public String getMyEmotionName(@Param("userId")String userId) 
			throws SQLException;

	// 감정 선택
    /**
     * insert into empathy values(EMPATHY_NO_SEQ.nextval,?,?,sysdate)
     **/
    public int addEmpathy(@Param("userId")String userId
    		, @Param("emotionCode")String emotionCode) 
		   throws SQLException;
	   
	// 감정 트렌드 조회
   	/**
   	 * select emotion_name from (select e.emotion_name, count(*) " + 
				"from empathy p, emotion e " + 
				"where e.emotion_code = p.emotion_code " + 
				"goup by emotion_name " + 
				"order by 2 desc) " + 
				"where rownum <= 3
   	 **/
	public Collection<String> getTrendEmotion() 
			throws SQLException;
	
	// 트렌드 글  --> 글번호 추가함
	/**
	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name " + 
				"from app_user a, board b, suggestion s, emotion e " + 
				"where b.writer_id = a.user_id " + 
				"and b.suggestion_code = s.suggestion_code " + 
				"and e.emotion_code = s.emotion_code " + 
				"and b.share_status = '전체' " +
				"and e.emotion_code = ?
	 **/
	public Collection<boardDTO> getTrendWrite(@Param("emotionCode")String emotionCode) 
			throws SQLException;
	
    //제시어 선택/새로고침
	/**
	 * select suggestion_name from "+
      "(select distinct s.suggestion_name from app_user a, empathy p, emotion e, suggestion s "+
      "where a.user_id = ? "+
      "and a.user_id = p.user_id "+
      "and p.emotion_code = e.emotion_code "+
      "and e.emotion_code = s.emotion_code "+
      "order by dbms_random.random) "+
      "where rownum<=2
	 * */
    public Collection<String> selectSuggestion
    							(@Param("userId")String userId) 
    		throws SQLException;
   
    /**
     * suggestionName으로 suggestionCode 가져오기
     * select suggestion_code from suggestion where suggestion_name = ?
     **/
    public Collection<String> getSuggestionCode
    		(@Param("suggestionName")String suggestionName) 
		   throws SQLException;
   
    /**
     * emotionName으로 emotionCode 가져오기
     * select emotion_code from emotion where emotion_name = ?
     **/
    public String getEmotionCode(String emotionName) 
		   throws SQLException;
	
    /**
     * select e.emotion_name 
     * from emotion e, empathy p 
     * where e.emotion_code = p.emotion_code 
     * and user_id = ?
     **/
	public Collection<String> getEmotionNameByEympathy
						(@Param("userId")String userId) 
			throws SQLException;

}







