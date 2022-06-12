package com.ucamp.project.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FollowListDTO {
	private BigDecimal followNo;
	private Timestamp followDate;
	private String followeeId;
	private String followerId;
	private String followeePenName;
	
	public FollowListDTO() {}
	
	public FollowListDTO(String followeeId, String followerId, String followeePenName) {
		this(null
			, Timestamp.valueOf(LocalDateTime.now())
			, followeeId
			, followerId
			, followeePenName);
	}
	
	public FollowListDTO(BigDecimal followNo
			, Timestamp followDate
			, String followeeId
			, String followerId
			, String followeePenName) {
		super();
		setFollowNo(followNo);
		setFollowDate(followDate);
		setFolloweeId(followeeId);
		setFollowerId(followerId);
		setFolloweePenName(followeePenName);
	}
	
	public BigDecimal getFollowNo() {
		return followNo;
	}
	public void setFollowNo(BigDecimal followNo) {
		this.followNo = followNo;
	}
	public Timestamp getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
	}
	public String getFolloweeId() {
		return followeeId;
	}
	public void setFolloweeId(String followeeId) {
		this.followeeId = followeeId;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	public String getFolloweePenName() {
		return followeePenName;
	}

	public void setFolloweePenName(String followeePenName) {
		this.followeePenName = followeePenName;
	}

	@Override
	public String toString() {
		return "FollowListDTO [followNo=" + followNo + ", followDate=" + followDate + ", followeeId=" + followeeId
				+ ", followerId=" + followerId + ", followeePenName=" + followeePenName + "]\n";
	}
}
