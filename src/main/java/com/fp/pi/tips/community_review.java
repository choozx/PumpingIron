package com.fp.pi.tips;

import java.util.ArrayList;

import java.util.Date;


public class community_review {

	private int cr_no;
	private String cr_title;
	private String cr_content;
	private String cr_nickname;
	private ArrayList<Like> cr_like;
	private ArrayList<View> cr_views;
	private String cr_email;
	private String cr_tips;
	private String cr_bodyProfile;
	private String cr_productReview;
	private Date cr_date ;

	
	public community_review() {
		// TODO Auto-generated constructor stub
	}


	public community_review(int cr_no, String cr_title, String cr_content, String cr_nickname, ArrayList<Like> cr_like,
			ArrayList<View> cr_views, String cr_email, String cr_tips, String cr_bodyProfile, String cr_productReview,
			Date cr_date) {
		super();
		this.cr_no = cr_no;
		this.cr_title = cr_title;
		this.cr_content = cr_content;
		this.cr_nickname = cr_nickname;
		this.cr_like = cr_like;
		this.cr_views = cr_views;
		this.cr_email = cr_email;
		this.cr_tips = cr_tips;
		this.cr_bodyProfile = cr_bodyProfile;
		this.cr_productReview = cr_productReview;
		this.cr_date = cr_date;
	}


	public int getCr_no() {
		return cr_no;
	}


	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}


	public String getCr_title() {
		return cr_title;
	}


	public void setCr_title(String cr_title) {
		this.cr_title = cr_title;
	}


	public String getCr_content() {
		return cr_content;
	}


	public void setCr_content(String cr_content) {
		this.cr_content = cr_content;
	}


	public String getCr_nickname() {
		return cr_nickname;
	}


	public void setCr_nickname(String cr_nickname) {
		this.cr_nickname = cr_nickname;
	}


	public ArrayList<Like> getCr_like() {
		return cr_like;
	}


	public void setCr_like(ArrayList<Like> cr_like) {
		this.cr_like = cr_like;
	}


	public ArrayList<View> getCr_views() {
		return cr_views;
	}


	public void setCr_views(ArrayList<View> cr_views) {
		this.cr_views = cr_views;
	}


	public String getCr_email() {
		return cr_email;
	}


	public void setCr_email(String cr_email) {
		this.cr_email = cr_email;
	}


	public String getCr_tips() {
		return cr_tips;
	}


	public void setCr_tips(String cr_tips) {
		this.cr_tips = cr_tips;
	}


	public String getCr_bodyProfile() {
		return cr_bodyProfile;
	}


	public void setCr_bodyProfile(String cr_bodyProfile) {
		this.cr_bodyProfile = cr_bodyProfile;
	}


	public String getCr_productReview() {
		return cr_productReview;
	}


	public void setCr_productReview(String cr_productReview) {
		this.cr_productReview = cr_productReview;
	}


	public Date getCr_date() {
		return cr_date;
	}


	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}
	
	
	
}
