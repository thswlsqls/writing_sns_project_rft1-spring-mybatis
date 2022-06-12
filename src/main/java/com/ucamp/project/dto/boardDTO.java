package com.ucamp.project.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class boardDTO {
	/** 게시글 상세조회 */
	public boardDTO(
			BigDecimal writeNo
			, String writerId
			, String penName
			, String contents
			, Timestamp writeDate
			, String emotionCode
			, String suggestionName
			, String shareStatus
			, String emotionName
			, String suggestionCode) {
		super();
		setWriteNo(writeNo);
		setWriterId(writerId);
		setPenName(penName);
		setContents(contents);
		setWriteDate(writeDate);
		setEmotionCode(emotionCode);
		setSuggestionName(suggestionName);
		setShareStatus(shareStatus);
		setEmotionName(emotionName);
		setSuggestionCode(suggestionCode);
	}
	
	/**홈 게시글 조회 -> 글번호 필요함, 작성자 아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
		from app_user a, board b, suggestion s, emotion e
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
		and e.emotion_code = ? ;
	 *  */
	 /**
	  *  친구글 목록 조회 -> 글번호 필요함, 작성자아이디 필요함
		SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
		WHERE b.writer_id = a.user_id 
		AND b.suggestion_code = s.suggestion_code 
		AND a.user_id = fl.followee_id
		AND e.emotion_code = s.emotion_code
		AND fl.follower_id = ?
		ORDER BY write_date DESC;
	  * */
	/**
	 * 즐겨찾기 글 상세조회
	 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
		from board b, app_user a, bookmark bm , suggestion s, emotion e
		WHERE a.user_id = b.writer_id
		and b.write_no = bm.write_no
		and b.suggestion_code = s.suggestion_code
		and s.emotion_code = e.emotion_code 
		and bm.user_id = 'test1'
		AND bm.write_no = '1';
	 * */
	/**
	 * --28. 트렌드별 글 조회
		select b.write_no, s.SUGGESTION_NAME, b.contents, a.pen_name, b.write_date, , e.emotion_code 
		from board b, suggestion s, emotion e, app_user a
		where a.user_id = b.writer_id
		and s.suggestion_code = b.suggestion_code
		and e.emotion_code = s.emotion_code
		and e.emotion_name = '즐거워요';
	 * */

	public boardDTO(BigDecimal writeNo
			, String suggestionName
			, String contents
			, String penName
			, Timestamp writeDate
			, String emotionCode
			, String emotionName){
		this(writeNo, null, penName, contents, writeDate, emotionCode, suggestionName, null, emotionName, null);
	}
	
	/**게시글 조회 -> 글번호 필요함, 작성자아이디 필요함*/
	public boardDTO(BigDecimal writeNo
			, String writerId
			, String suggestionName
			, String contents
			, String penName
			, Timestamp writeDate
			, String emotionCode
			, String emotionName){
		this(writeNo, writerId, penName, contents, writeDate, emotionCode, suggestionName, null, emotionName, null);
	}
	
//	public boardDTO(String suggestionName
//			, String contents
//			, String penName
//			, Timestamp writeDate
//			, String emotionCode) {
//		setSuggestionName(suggestionName);
//		setContents(contents);
//		setPenName(penName);
//		setWriteDate(writeDate);
//		setEmotionCode(emotionCode);
//	}
	
	/**새로운 게시물 목록 조회 -> 글번호 필요함, 작성자아이디 필요함
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date
		from app_user a, board b, suggestion s 
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
		and rownum<=10
		order by b.write_date desc;
	 * */
	public boardDTO(BigDecimal writeNo
			, String writerId
			, String suggestionName
			, String contents
			, String penName
			, Timestamp writeDate) {
		setWriteNo(writeNo);
		setWriterId(writerId);
		setSuggestionName(suggestionName);
		setContents(contents);
		setPenName(penName);
		setWriteDate(writeDate);
	}
	
	public boardDTO(
			String suggestionName
			, String contents
			, String penName
			, Timestamp writeDate) {
		
		setSuggestionName(suggestionName);
		setContents(contents);
		setPenName(penName);
		setWriteDate(writeDate);
	}
	
	/**실시간 추천글 조회 
	 * 
	  SELECT (SElECT count(*) 
        FROM reaction 
        WHERE write_no = b.write_no) AS rCnt ,
       (SElECT count(*) 
        FROM bookmark 
        WHERE write_no = b.write_no) AS bmCnt ,
        b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code, a.pen_name, b.suggestion_name
	    FROM board b, bookmark bm, reaction r
	    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date desc, rCnt, bmCnt desc;
	 * 
	 * */
	
	public boardDTO(
			BigDecimal rCnt
			, BigDecimal writeNo
			, String contents
			, Timestamp writeDate
			, String shareStatus
			, String writerId
			, String suggestionCode
			, String penName
			, String suggestionName
			) {
		setrCnt(rCnt);
		setWriteNo(writeNo);
		setContents(contents);
		setWriteDate(writeDate);
		setShareStatus(shareStatus);
		setWriterId(writerId);
		setSuggestionCode(suggestionCode);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	public boardDTO(
			BigDecimal rCnt
			, BigDecimal bmCnt
			, BigDecimal writeNo
			, String contents
			, Timestamp writeDate
			, String shareStatus
			, String writerId
			, String suggestionCode
			) {
		setrCnt(rCnt);
		setBmCnt(bmCnt);
		setWriteNo(writeNo);
		setContents(contents);
		setWriteDate(writeDate);
		setShareStatus(shareStatus);
		setWriterId(writerId);
		setSuggestionCode(suggestionCode);
	}
	/**
	    * 검색(제시어, 필명)
		*  select b.write_date, a.pen_name, s.suggestion_name from app_user a, board b, suggestion s where s.suggestion_name = ?;
	    * */
	/**
	 * --16. 즐겨찾기 글 목록 조회
		select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
		from bookmark bm, board bo, suggestion s, app_user a
		where bm.write_no = bo.write_no 
		and bo.suggestion_code = s.suggestion_code
		and a.user_id = bo.writer_id
		and bm.USER_ID = 'test2';
	 * 
	 * */
	
	public boardDTO(
			BigDecimal writeNo
			, Timestamp writeDate
			, String penName
			, String suggestionName
			) {
		setWriteNo(writeNo);
		setWriteDate(writeDate);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	
	public boardDTO(Timestamp writeDate
			,String penName
			, String suggestionName ) {
		setWriteDate(writeDate);
		setPenName(penName);
		setSuggestionName(suggestionName);
	}
	
   public boardDTO(String suggestionName
	         , String contents
	         , String penName
	         , Timestamp writeDate
	         , String emotionCode){
	      setSuggestionName(suggestionName);
	      setContents(contents);
	      setPenName(penName);
	      setWriteDate(writeDate);
	      setEmotionCode(emotionCode);
	   }
   
  public boardDTO(BigDecimal WriteNo
		  , String suggestionName
		  , String contents
		  , String penName
		  , Timestamp writeDate
		  , String emotionCode) {
	   setWriteNo(WriteNo);
	   setSuggestionName(suggestionName);
	   setContents(contents);
	   setPenName(penName);
	   setWriteDate(writeDate);
	   setEmotionCode(emotionCode);
   }
	 
	
	private String suggestionName;

	private String contents;
	private String penName;
	private Timestamp writeDate;
	private String emotionCode;
	private String emotionName;
	
	private BigDecimal writeNo;
	private String shareStatus;
	private String writerId;
	private String suggestionCode;
	
	private BigDecimal rCnt;
	private BigDecimal bmCnt;
	
	
	public BigDecimal getrCnt() {
		return rCnt;
	}

	public void setrCnt(BigDecimal rCnt) {
		this.rCnt = rCnt;
	}

	public BigDecimal getBmCnt() {
		return bmCnt;
	}

	public void setBmCnt(BigDecimal bmCnt) {
		this.bmCnt = bmCnt;
	}

	public String getSuggestionName() {
		return suggestionName;
	}

	public void setSuggestionName(String suggestionName) {
		this.suggestionName = suggestionName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public String getEmotionCode() {
		return emotionCode;
	}

	public void setEmotionCode(String emotionCode) {
		this.emotionCode = emotionCode;
	}
	
	public String getEmotionName() {
		return emotionName;
	}

	public void setEmotionName(String emotionName) {
		this.emotionName = emotionName;
	}

	public BigDecimal getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(BigDecimal writeNo) {
		this.writeNo = writeNo;
	}

	public String getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getSuggestionCode() {
		return suggestionCode;
	}

	public void setSuggestionCode(String suggestionCode) {
		this.suggestionCode = suggestionCode;
	}

	@Override
	public String toString() {
		return "BoardDTO [suggestionName=" + suggestionName + ", contents=" + contents + ", penName=" + penName
				+ ", writeDate=" + writeDate + ", emotionCode=" + emotionCode + ", writeNo=" + writeNo
				+ ", shareStatus=" + shareStatus + ", writerId=" + writerId + ", suggestionCode=" + suggestionCode
				+ "]\n";
	}

}
