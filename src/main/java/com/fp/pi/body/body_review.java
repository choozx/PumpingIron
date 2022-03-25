package com.fp.pi.body;

import java.util.Date;


public class body_review {

	private int br_no;
	private String br_title;
	private String br_content;
	private String br_nickname;
	private int br_like;
	private int br_views;
	private String br_email;
	private String br_tips;
	private String br_bodyProfile;
	private String br_productReview;
	private Date br_date ;
	private String br_picture; // f12 눌렀을시 사진 url 가져오기
	private String m_photo;

	public body_review() {
		// TODO Auto-generated constructor stub
	}

	public body_review(int br_no, String br_title, String br_content, String br_nickname, int br_like, int br_views,
			String br_email, String br_tips, String br_bodyProfile, String br_productReview, Date br_date,
			String br_picture, String m_photo) {
		super();
		this.br_no = br_no;
		this.br_title = br_title;
		this.br_content = br_content;
		this.br_nickname = br_nickname;
		this.br_like = br_like;
		this.br_views = br_views;
		this.br_email = br_email;
		this.br_tips = br_tips;
		this.br_bodyProfile = br_bodyProfile;
		this.br_productReview = br_productReview;
		this.br_date = br_date;
		this.br_picture = br_picture;
		this.m_photo = m_photo;
	}

	public int getBr_no() {
		return br_no;
	}

	public void setBr_no(int br_no) {
		this.br_no = br_no;
	}

	public String getBr_title() {
		return br_title;
	}

	public void setBr_title(String br_title) {
		this.br_title = br_title;
	}

	public String getBr_content() {
		return br_content;
	}

	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}

	public String getBr_nickname() {
		return br_nickname;
	}

	public void setBr_nickname(String br_nickname) {
		this.br_nickname = br_nickname;
	}

	public int getBr_like() {
		return br_like;
	}

	public void setBr_like(int br_like) {
		this.br_like = br_like;
	}

	public int getBr_views() {
		return br_views;
	}

	public void setBr_views(int br_views) {
		this.br_views = br_views;
	}

	public String getBr_email() {
		return br_email;
	}

	public void setBr_email(String br_email) {
		this.br_email = br_email;
	}

	public String getBr_tips() {
		return br_tips;
	}

	public void setBr_tips(String br_tips) {
		this.br_tips = br_tips;
	}

	public String getBr_bodyProfile() {
		return br_bodyProfile;
	}

	public void setBr_bodyProfile(String br_bodyProfile) {
		this.br_bodyProfile = br_bodyProfile;
	}

	public String getBr_productReview() {
		return br_productReview;
	}

	public void setBr_productReview(String br_productReview) {
		this.br_productReview = br_productReview;
	}

	public Date getBr_date() {
		return br_date;
	}

	public void setBr_date(Date br_date) {
		this.br_date = br_date;
	}

	public String getBr_picture() {
		return br_picture;
	}

	public void setBr_picture(String br_picture) {
		this.br_picture = br_picture;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	
}
