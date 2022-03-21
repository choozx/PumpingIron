package com.fp.pi.review;

import java.util.Date;


public class community_review2 {

	private int c2_no;
	private String c2_title;
	private String c2_content;
	private String c2_nickname;
	private int c2_like;
	private int c2_views;
	private String c2_email;
	private String c2_tips;
	private String c2_bodyProfile;
	private String c2_productReview;
	private Date c2_date ;
	private String c2_picture; // f12 눌렀을시 사진 url 가져오기

	public community_review2() {
		// TODO Auto-generated constructor stub
	}

	public community_review2(int c2_no, String c2_title, String c2_content, String c2_nickname, int c2_like,
			int c2_views, String c2_email, String c2_tips, String c2_bodyProfile, String c2_productReview, Date c2_date,
			String c2_picture) {
		super();
		this.c2_no = c2_no;
		this.c2_title = c2_title;
		this.c2_content = c2_content;
		this.c2_nickname = c2_nickname;
		this.c2_like = c2_like;
		this.c2_views = c2_views;
		this.c2_email = c2_email;
		this.c2_tips = c2_tips;
		this.c2_bodyProfile = c2_bodyProfile;
		this.c2_productReview = c2_productReview;
		this.c2_date = c2_date;
		this.c2_picture = c2_picture;
	}

	public int getC2_no() {
		return c2_no;
	}

	public void setC2_no(int c2_no) {
		this.c2_no = c2_no;
	}

	public String getC2_title() {
		return c2_title;
	}

	public void setC2_title(String c2_title) {
		this.c2_title = c2_title;
	}

	public String getC2_content() {
		return c2_content;
	}

	public void setC2_content(String c2_content) {
		this.c2_content = c2_content;
	}

	public String getC2_nickname() {
		return c2_nickname;
	}

	public void setC2_nickname(String c2_nickname) {
		this.c2_nickname = c2_nickname;
	}

	public int getC2_like() {
		return c2_like;
	}

	public void setC2_like(int c2_like) {
		this.c2_like = c2_like;
	}

	public int getC2_views() {
		return c2_views;
	}

	public void setC2_views(int c2_views) {
		this.c2_views = c2_views;
	}

	public String getC2_email() {
		return c2_email;
	}

	public void setC2_email(String c2_email) {
		this.c2_email = c2_email;
	}

	public String getC2_tips() {
		return c2_tips;
	}

	public void setC2_tips(String c2_tips) {
		this.c2_tips = c2_tips;
	}

	public String getC2_bodyProfile() {
		return c2_bodyProfile;
	}

	public void setC2_bodyProfile(String c2_bodyProfile) {
		this.c2_bodyProfile = c2_bodyProfile;
	}

	public String getC2_productReview() {
		return c2_productReview;
	}

	public void setC2_productReview(String c2_productReview) {
		this.c2_productReview = c2_productReview;
	}

	public Date getC2_date() {
		return c2_date;
	}

	public void setC2_date(Date c2_date) {
		this.c2_date = c2_date;
	}

	public String getC2_picture() {
		return c2_picture;
	}

	public void setC2_picture(String c2_picture) {
		this.c2_picture = c2_picture;
	}


	
}
