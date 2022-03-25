package com.fp.pi.body;

import java.util.Date;

public class body_review_reply {

private int brr_no;
private int	brr_br_no;
private String brr_text; 
private String brr_br_nickname;
private Date brr_date;

public body_review_reply() {
	// TODO Auto-generated constructor stub
}

public body_review_reply(int brr_no, int brr_br_no, String brr_text, String brr_br_nickname, Date brr_date) {
	super();
	this.brr_no = brr_no;
	this.brr_br_no = brr_br_no;
	this.brr_text = brr_text;
	this.brr_br_nickname = brr_br_nickname;
	this.brr_date = brr_date;
}

public int getBrr_no() {
	return brr_no;
}

public void setBrr_no(int brr_no) {
	this.brr_no = brr_no;
}

public int getBrr_br_no() {
	return brr_br_no;
}

public void setBrr_br_no(int brr_br_no) {
	this.brr_br_no = brr_br_no;
}

public String getBrr_text() {
	return brr_text;
}

public void setBrr_text(String brr_text) {
	this.brr_text = brr_text;
}

public String getBrr_br_nickname() {
	return brr_br_nickname;
}

public void setBrr_br_nickname(String brr_br_nickname) {
	this.brr_br_nickname = brr_br_nickname;
}

public Date getBrr_date() {
	return brr_date;
}

public void setBrr_date(Date brr_date) {
	this.brr_date = brr_date;
}




}
