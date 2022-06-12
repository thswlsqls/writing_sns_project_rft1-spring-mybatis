package com.ucamp.project.write;

import java.sql.SQLException;
import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import com.ucamp.project.dto.boardDTO;

public interface WriteDAO {

		/** �Խñ��ۼ�
	    * insert into board(write_no, contents, write_date, share_status, writer_id, suggestion_code)
		values(write_no_seq.nextval, ?, sysdate, '��ü', ?, ?)
	    * @throws SQLException */
	   public int diaryWrite
	   			(@Param("contents")String contents
	   			,@Param("writerId")String writer_id
	   			,@Param("suggestionCode")String suggestion_code) 
			   throws SQLException;
	   
	   /** �Խñۼ���
	    * update board set contents = '����̶�� ���þ�� �ۼ��� ���� ����' where writer_id = 'eunbin' and write_no = '44';
	    * @throws SQLException */
	   public int diaryModify
	   			(@Param("writerId")String writer_id 
	   			,@Param("writeNo")String write_no
	   			,@Param("contents")String contents) 
			   throws SQLException;
	
	   /**�Խñ� ����
	    * delete from board where writer_id = ? and write_no = ?;
	    *  */
	   public int diaryRemove(@Param("writerId")String writer_id
			   , @Param("writeNo")String write_no) 
		   throws SQLException;
	  
	   //�ʸ����� �˻�
	   /**
	    * select b.write_date, a.pen_name, s.suggestion_name 
			from app_user a, board b, suggestion s 
			WHERE a.user_id = b.writer_id
			AND b.suggestion_code = s.suggestion_code
			AND a.pen_name = '��������';
	    * */
	   public Collection<boardDTO> searchByPenName
	   			(@Param("penName")String searchText)
			   throws SQLException;
	   
	   //���þ�� �˻�
	   /**
	    * SELECT b.write_date, a.pen_name, s.suggestion_name 
			FROM app_user a, board b, suggestion s 
			WHERE a.user_id = b.writer_id
			AND b.suggestion_code = s.suggestion_code
			AND s.suggestion_name = '���';	
	    * */
	   public Collection<boardDTO> searchBySuggestionName
	   			(@Param("suggestionName")String searchText)
				throws SQLException;;  
		
		/**Ȩ �Խñ۸�� ��ȸ  -> �۹�ȣ �ʿ���, �ۼ��� ���̵� �ʿ���
		 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
			from app_user a, board b, suggestion s, emotion e
			where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code and e.emotion_code = s.emotion_code
			and e.emotion_code = ? ;
		 *  */
	   public Collection<boardDTO> getHomeBoardList
	   					(@Param("emotionCode")String emotionCode)
							throws SQLException;

	/**�������� ���� 
	 * update board set share_status = ? where write_no = ? and writer_id = ?;
	 * */
		public int setShareStatus
			(@Param("shareStatus")String shareStatus
					, @Param("writeNo")String write_no
					, @Param("writerId")String writer_id) 
		   throws SQLException;
	   
	/**���ο� �Խù� ��� ��ȸ -> �۹�ȣ �ʿ���, �ۼ��ھ��̵� �ʿ���
	 * select b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date
		from app_user a, board b, suggestion s 
		where b.writer_id = a.user_id and b.suggestion_code = s.suggestion_code
		and rownum<=10
		order by b.write_date desc;
	 * */
	   public Collection<boardDTO> getNewBoardList() 
							throws SQLException;
	   
	/**�ǽð� ��õ�� ��ȸ  
	 * 
	  SELECT (SElECT count(*) 
     FROM reaction 
     WHERE write_no = b.write_no) AS rCnt ,
    (SElECT count(*) 
     FROM bookmark 
     WHERE write_no = b.write_no) AS bmCnt ,
     b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
	    FROM board b, bookmark bm, reaction r
	    WHERE b.write_no = bm.write_no AND b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date desc, rCnt, bmCnt desc;
	 * 
	 * */
	/**
	 * SELECT (SElECT count(*) 
     FROM reaction 
     WHERE write_no = b.write_no) AS rCnt ,
     b.write_no, b.contents, b.write_date, b.share_status, b.writer_id, b.suggestion_code
	    FROM board b, reaction r
	    WHERE b.write_no = r.write_no AND rownum <= 10
	    ORDER BY b.write_date, rCnt desc
	 * */
	public Collection<boardDTO> getNowRecommendedBoardList() 
			throws SQLException;
	
	/**emotionName���� emotionCode ��������*/
	   public String getEmotionCode(@Param("emotionName")String emotionName) 
			   throws SQLException;
	   
	 /**
	  *  ģ���� ��� ��ȸ  -> �۹�ȣ �ʿ���, �ۼ��� ���̵� �ʿ���
		SELECT b.write_no, b.writer_id, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code, e.emotion_name
		FROM app_user a, board b, suggestion s, emotion e, follow_list fl
		WHERE b.writer_id = a.user_id 
		AND b.suggestion_code = s.suggestion_code 
		AND a.user_id = fl.followee_id
		AND e.emotion_code = s.emotion_code
		"       and b.share_status = '��ü' " +
		AND fl.follower_id = ?
		ORDER BY write_date DESC;
	  * */
	   public Collection<boardDTO> getFriendWriteList
	   				(@Param("followerId")String followerId) 
			   throws SQLException;
	   
	   /**
	    * ���� Ʈ���� ��ȸ
	     select emotion_name from (select e.emotion_name, count(*) 
	     from empathy p, emotion e 
	     where e.emotion_code = p.emotion_code
	     group by emotion_name
	     order by 2 desc)
	     where rownum <= 3;
	    * 
	    * 
	    * */

	   /**
	    *  Ʈ���庰 �� ��ȸ  -> �۹�ȣ�ʿ���
		   select s.sugguestion_name, b.contents, a.pen_name, b.write_date 
		   from board b, suggestion s, emotion e, app_user a
		   where and a.user_id = b.writer_id
		   and s.suggestion_code = b.suggestion_code
		   and e.emotion_code = s.emotion_code
		   and e.emotion_name = ?;
	    * */
		public Collection<boardDTO> getTrendWrite
				(@Param("emotionName")String emotionCode) 
				throws SQLException;

		/**
		 * ���ã�� �� ��� ��ȸ
		 * select bo.write_no, bm.bookmark_date, s.suggestion_name, a.pen_name
			from bookmark bm, board bo, suggestion s, app_user a
			where bm.write_no = bo.write_no 
			and bo.suggestion_code = s.suggestion_code
			and a.user_id = bo.writer_id
			"   and bo.share_status = '��ü' " +
			and bm.USER_ID = 'test2';
		 * */
		public Collection<boardDTO> getBookmarkedWriteList
				(@Param("userId")String userId) 
				throws SQLException;
		
		/**
		 * ���ã�� �� ����ȸ
		 * select b.write_no, s.suggestion_name, b.contents, a.pen_name, b.write_date, e.emotion_code
			from board b, app_user a, bookmark bm , suggestion s, emotion e
			WHERE a.user_id = b.writer_id
			and b.write_no = bm.write_no
			and b.suggestion_code = s.suggestion_code
			and s.emotion_code = e.emotion_code 
			and bm.user_id = 'test1'
			AND bm.write_no = '1';
		 * */
		public boardDTO getBookmarkedWrite
				(@Param("userId")String userId 
				, @Param("writeNo")String writeNo) 
				throws SQLException;
		
		// �˻��� �� �ۺ���
		/**
		 * 
			select s.suggestion_name
			  , b.contents
			  , a.pen_name
			  , b.write_date  
			from app_user a
			  , board b
			  , suggestion s
			  , emotion e 
			where a.user_id = b.writer_id 
			and b.suggestion_code = s.suggestion_code 
			and s.emotion_code = e.emotion_code 
			and a.pen_name = '��������'
			and s.suggestion_name = '���'  
			and to_char(b.write_date,'yyyy-mm-dd') = '2022-06-11'
		;
		 * */
		public Collection<boardDTO> getSearchResultWrite
				(@Param("penName")String penName
				, @Param("suggestionName")String suggestionName
				, @Param("writeDate")String writeDate)
				throws SQLException;
	
		
		//mypage
		/**
		 * 
		   select b.write_no
			  , b.write_date
			  , a.pen_name
			  , s.suggestion_name 
			from app_user a
			  , board b
			  , suggestion s 
			where a.user_id = b.writer_id
			and b.suggestion_code = s.suggestion_code
			and a.user_id = 'eunbin' 
			order by 1 desc
		 * */
	    public Collection<boardDTO> myWriting
	    		(@Param("userId")String userId)
			    throws SQLException;

		//���������� �񵿱� �� ��� ��ȸ
	    /**
	     *
	       select b.write_no
			  , to_char(b.write_date,'yyyy-mm-dd')
			  , a.pen_name
			  , s.suggestion_name 
			from app_user a
			  , board b
			  , suggestion s 
			where a.user_id = b.writer_id 
			and b.suggestion_code = s.suggestion_code 
			and a.user_id = 'eunbin' 
			and to_char(b.write_date,'yyyy-mm-dd') = '2022-06-11' 
			order by 1 desc

	     * */
		public Collection<boardDTO> getMyPageSearch
				(@Param("userId")String userId
				, @Param("writeDate")String date)
				throws SQLException;
		
		//���������� �� �󼼸�� ��ȸ
		/**
			select s.suggestion_name
			  , b.contents
			  , a.pen_name
			  , b.write_date 
			from app_user a
			  , board b
			  , suggestion s
			  , emotion e
			where a.user_id = b.writer_id
			and b.suggestion_code = s.suggestion_code 
			and s.emotion_code = e.emotion_code
			and a.user_id = 'eunbin' 
			and b.write_no = '44'
			;
		 * 
		 * */
		public boardDTO getMyPageWrite
				(@Param("userId")String userId
				,@Param("writeNo")String writeNo)
				throws SQLException;
		
	
	   /**
	    * �Խñ� ����ȸ
	    * 
	    select b.write_no
		  , b.writer_id
		  , a.pen_name
		  , b.contents
		  ,  b.write_date
		  , e.emotion_code
		  , s.suggestion_name
		  , b.share_status
		  ,  e.emotion_name
		  , s.suggestion_code 
		from app_user a
		  , board b
		  , suggestion s
		  , emotion e
		where b.writer_id = a.user_id 
		and b.suggestion_code = s.suggestion_code 
		and e.emotion_code = s.emotion_code
		and b.write_no = '44'
		;
	    * */
		public boardDTO getWriteDetail
			(@Param("writeNo")String writeNo) 
				throws SQLException;
		
		//�۹�ȣ�� ���þ� ��������
		/**
			SELECT s.suggestion_name
			  , b.contents 
			FROM board b
			  , suggestion s
			  , emotion e
			WHERE b.suggestion_code = s.suggestion_code
			AND s.emotion_code = e.emotion_code
			AND b.write_no = '44'
			;
		 * */
		public String[] getSuggestionName
				(@Param("writeNo")String writeNo) 
				throws SQLException;
	
}
