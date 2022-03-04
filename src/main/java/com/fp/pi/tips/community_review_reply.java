package com.fp.pi.tips;

import java.util.Date;

public class community_review_reply {

private int	crr_no;
private String crr_text; 
private String crr_writer;
private Date crr_date;

public community_review_reply() {
	// TODO Auto-generated constructor stub
}

public community_review_reply(int crr_no, String crr_text, String crr_writer, Date crr_date) {
	super();
	this.crr_no = crr_no;
	this.crr_text = crr_text;
	this.crr_writer = crr_writer;
	this.crr_date = crr_date;
}

public int getCrr_no() {
	return crr_no;
}

public void setCrr_no(int crr_no) {
	this.crr_no = crr_no;
}

public String getCrr_text() {
	return crr_text;
}

public void setCrr_text(String crr_text) {
	this.crr_text = crr_text;
}

public String getCrr_writer() {
	return crr_writer;
}

public void setCrr_writer(String crr_writer) {
	this.crr_writer = crr_writer;
}

public Date getCrr_date() {
	return crr_date;
}

public void setCrr_date(Date crr_date) {
	this.crr_date = crr_date;
}


}
