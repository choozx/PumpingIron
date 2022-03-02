package com.fp.pi.tips;

public class Like {

	private String checkUser; //좋아요 체크한 유저 아이디
	private int likeFlag; // 1-좋아요 2-취소
	private String regDate;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(String checkUser, int likeFlag, String regDate) {
		super();
		this.checkUser = checkUser;
		this.likeFlag = likeFlag;
		this.regDate = regDate;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public int getLikeFlag() {
		return likeFlag;
	}

	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
