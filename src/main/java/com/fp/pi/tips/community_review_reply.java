package com.fp.pi.tips;

import java.util.Date;

public class community_review_reply {

private int crr_no;
private int	crr_cr_no;
private String crr_text; 
private String crr_cr_nickname;
private Date crr_date;

public community_review_reply() {
	// TODO Auto-generated constructor stub
}

public community_review_reply(int crr_no, int crr_cr_no, String crr_text, String crr_cr_nickname, Date crr_date) {
	super();
	this.crr_no = crr_no;
	this.crr_cr_no = crr_cr_no;
	this.crr_text = crr_text;
	this.crr_cr_nickname = crr_cr_nickname;
	this.crr_date = crr_date;
}

public int getCrr_no() {
	return crr_no;
}

public void setCrr_no(int crr_no) {
	this.crr_no = crr_no;
}

public int getCrr_cr_no() {
	return crr_cr_no;
}

public void setCrr_cr_no(int crr_cr_no) {
	this.crr_cr_no = crr_cr_no;
}

public String getCrr_text() {
	return crr_text;
}

public void setCrr_text(String crr_text) {
	this.crr_text = crr_text;
}

public String getCrr_cr_nickname() {
	return crr_cr_nickname;
}

public void setCrr_cr_nickname(String crr_cr_nickname) {
	this.crr_cr_nickname = crr_cr_nickname;
}

public Date getCrr_date() {
	return crr_date;
}

public void setCrr_date(Date crr_date) {
	this.crr_date = crr_date;
}



}
