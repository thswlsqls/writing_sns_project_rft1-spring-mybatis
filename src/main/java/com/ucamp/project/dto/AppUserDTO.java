package com.ucamp.project.dto;

public class AppUserDTO {
	private String userId;
	private String name;
	private String penName;
	private String userPw;
	private String email;
	private String tel;
	
	public AppUserDTO(String userId
			, String name
			, String penName
			, String userPw
			, String email
			, String tel) {
		super();
		setUserId(userId);
		setName(name);
		setPenName(penName);
		setUserPw(userPw);
		setEmail(email);
		setTel(tel);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "appUser [userId=" + userId + ", name=" + name + ", penName=" + penName + ", userPw=" + userPw
				+ ", email=" + email + ", tel=" + tel + "]\n";
	}
}
