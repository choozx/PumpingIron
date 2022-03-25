package com.fp.pi.best;

import java.util.Date;

public class BestBean {

	private int b_no;
	private String b_title;
	private String b_content;
	private String b_nickname;
	private int b_like;
	private int b_views;
	private String b_email;
	private String b_tips;
	private String b_bodyProfile;
	private String b_productReview;
	private Date b_date ;
	private String b_picture; 
	private String b_type;
	private String m_photo;
	public BestBean() {
		// TODO Auto-generated constructor stub
	}
	public BestBean(int b_no, String b_title, String b_content, String b_nickname, int b_like, int b_views,
			String b_email, String b_tips, String b_bodyProfile, String b_productReview, Date b_date, String b_picture,
			String b_type, String m_photo) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_nickname = b_nickname;
		this.b_like = b_like;
		this.b_views = b_views;
		this.b_email = b_email;
		this.b_tips = b_tips;
		this.b_bodyProfile = b_bodyProfile;
		this.b_productReview = b_productReview;
		this.b_date = b_date;
		this.b_picture = b_picture;
		this.b_type = b_type;
		this.m_photo = m_photo;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_nickname() {
		return b_nickname;
	}
	public void setB_nickname(String b_nickname) {
		this.b_nickname = b_nickname;
	}
	public int getB_like() {
		return b_like;
	}
	public void setB_like(int b_like) {
		this.b_like = b_like;
	}
	public int getB_views() {
		return b_views;
	}
	public void setB_views(int b_views) {
		this.b_views = b_views;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_tips() {
		return b_tips;
	}
	public void setB_tips(String b_tips) {
		this.b_tips = b_tips;
	}
	public String getB_bodyProfile() {
		return b_bodyProfile;
	}
	public void setB_bodyProfile(String b_bodyProfile) {
		this.b_bodyProfile = b_bodyProfile;
	}
	public String getB_productReview() {
		return b_productReview;
	}
	public void setB_productReview(String b_productReview) {
		this.b_productReview = b_productReview;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public String getB_picture() {
		return b_picture;
	}
	public void setB_picture(String b_picture) {
		this.b_picture = b_picture;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public String getM_photo() {
		return m_photo;
	}
	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	
}
