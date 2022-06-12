package com.ucamp.project.interaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucamp.project.dto.FollowListDTO;

@Repository
public interface InteractionDAO {
	
		//�ȷο�(ģ���߰�)
		/**
		 * INSERT INTO follow_list(follow_no, followee_id, follower_id, follow_date) VALUES(FOLLOW_NO_SEQ.nextval, ?, ?, sysdate);
		 * */
	   @Transactional
	   public int addFollow(@Param("followeeId")String followeeId
			   				, @Param("followerId")String followerId) 
			   throws SQLException;
	   
	 //�ȷο� ���(ģ�����)
	 		/**
	 		 * DELETE 
				FROM follow_list 
				WHERE followee_id = 'eunbin' 
				AND follower_id = 'test4';
	 		 * */
 	   @Transactional
 	   public int deleteFollow(@Param("followeeId")String followeeId
 			   				, @Param("followerId")String followerId) 
 			   throws SQLException;
		
	   //�ȷο� ��� ��ȸ
	   /**
	    * select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
	      from follow_list fl, app_user a
	      where fl.followee_id = a.user_id
	      AND fl.follower_id = 'test2';
	    * 
	    * */
	   public Collection<FollowListDTO> getFollowList
	   		(@Param("followerId")String followerId) 
	         throws SQLException;
		   
	   /**
	  *�ȷο�(ģ��) ����� �ֽż� ������ ��ȸ
	    select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
	          from follow_list fl, app_user a
	          where fl.followee_id = a.user_id
	          AND fl.follower_id = 'test2'
	    ORDER BY fl.follow_date;
	  * 
	  * */
	   public Collection<FollowListDTO> getSortedByDateFollowList
	   			(@Param("followerId")String followerId) 
			   throws SQLException;
	   
	   /**
	    * �ȷο�(ģ��) ����� �ʸ� �����ټ� ������ ��ȸ
	    *    select fl.follow_no, to_char(fl.follow_date, 'yyyy.mm.dd'), fl.followee_id, fl.follower_id, a.pen_name
	         from follow_list fl, app_user a
	         where fl.followee_id = a.user_id
	         AND fl.follower_id = 'test2
	      ORDER BY a.pen_name;
	    * */
	   
	   public Collection<FollowListDTO> getSortedByPenNameFollowList
	   		(@Param("followerId")String followerId) 
	         throws SQLException;
	   
		// ���ƿ� ��Ͽ��� ��ȸ
		/**SELECT COUNT(user_id) 
		 * FROM reaction 
		 * WHERE user_id = ? 
		 * AND write_no = ?;
		 */
	   public int isReacted(String userId, String writeNo) 
				throws SQLException;
		
	   /**
	    * INSERT INTO reaction(user_id, write_no, reaction_date) VALUES(?,?,sysdate)
	    * */
	   //���ƿ� �߰�
	   public int addReaction
	   		(@Param("userId")String userId
	   		,@Param("writeNo")String writeNo) 
	 			throws SQLException;
	 	
	   /**
	    * DELETE 
		  FROM reaction 
		  WHERE user_id = #{userId} 
		  AND write_no = #{writeNo}
	    * */
	 	//���ƿ� ����
	   public int deleteReaction
	   			(@Param("userId")String userId
		   		,@Param("writeNo")String writeNo) 
	 			throws SQLException;
	   
		/**
	  	 * ���ƿ� �� ���� ��ȸ
	  	 * SELECT count(*) FROM reaction WHERE write_no = '1';
	  	 * */
	   public int countReactions
	   			(@Param("writeNo")String writeNo) 
				throws SQLException;
	  	
	   /**
	    * insert into bookmark(user_id, write_no, bookmark_date)  values('eunbin','1',sysdate);
	    * */
	   //���ã�� �߰�
	   public int addBookmark
	   		(@Param("userId")String userId
	   		,@Param("writeNo")String writeNo) 
	 			throws SQLException;
	 	
	   /**
	    * delete from bookmark where user_id='eunbin' and write_no='1';
	    * */
	 	//���ã�� ����
	   public int deleteBookmark
	   			(@Param("userId")String userId
		   		,@Param("writeNo")String writeNo) 
	 			throws SQLException;
	
	  	/**
	     * ���ã�� ���� ��ȸ
	     * SELECT count(*) FROM bookmark WHERE user_id='test1' AND write_no='6';
	     * */
	   public int isBookmarked
	   			(@Param("userId")String userId
		   		,@Param("writeNo")String writeNo) 
				throws SQLException;

}
