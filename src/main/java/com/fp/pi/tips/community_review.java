package com.fp.pi.tips;

import java.util.ArrayList;
import java.util.Date;


public class community_review {

	private int cr_no;
	private String cr_title;
	private String cr_text;
	private String cr_writer;
	private ArrayList<Like> cr_like;
	private ArrayList<View> cr_views;
	private String cr_img;
	private String cr_tips;
	private String cr_bodyProfile;
	private String cr_productReview;
	private Date cr_date ;
	
public community_review() {
	// TODO Auto-generated constructor stub
}

public community_review(int cr_no, String cr_title, String cr_text, String cr_writer, ArrayList<Like> cr_like,
		ArrayList<View> cr_views, String cr_img, String cr_tips, String cr_bodyProfile, String cr_productReview,
		Date cr_date) {
	super();
	this.cr_no = cr_no;
	this.cr_title = cr_title;
	this.cr_text = cr_text;
	this.cr_writer = cr_writer;
	this.cr_like = cr_like;
	this.cr_views = cr_views;
	this.cr_img = cr_img;
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

public String getCr_text() {
	return cr_text;
}

public void setCr_text(String cr_text) {
	this.cr_text = cr_text;
}

public String getCr_writer() {
	return cr_writer;
}

public void setCr_writer(String cr_writer) {
	this.cr_writer = cr_writer;
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

public String getCr_img() {
	return cr_img;
}

public void setCr_img(String cr_img) {
	this.cr_img = cr_img;
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
