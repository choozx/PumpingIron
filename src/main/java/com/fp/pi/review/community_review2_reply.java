package com.fp.pi.review;

import java.util.Date;

public class community_review2_reply {

private int c2r_no;
private int	c2r_c2_no;
private String c2r_text; 
private String c2r_c2_nickname;
private Date c2r_date;

public community_review2_reply() {
	// TODO Auto-generated constructor stub
}

public community_review2_reply(int c2r_no, int c2r_c2_no, String c2r_text, String c2r_c2_nickname, Date c22r_date) {
	super();
	this.c2r_no = c2r_no;
	this.c2r_c2_no = c2r_c2_no;
	this.c2r_text = c2r_text;
	this.c2r_c2_nickname = c2r_c2_nickname;
	this.c2r_date = c22r_date;
}

public int getC2r_no() {
	return c2r_no;
}

public void setC2r_no(int c2r_no) {
	this.c2r_no = c2r_no;
}

public int getC2r_c2_no() {
	return c2r_c2_no;
}

public void setC2r_c2_no(int c2r_c2_no) {
	this.c2r_c2_no = c2r_c2_no;
}

public String getC2r_text() {
	return c2r_text;
}

public void setC2r_text(String c2r_text) {
	this.c2r_text = c2r_text;
}

public String getC2r_c2_nickname() {
	return c2r_c2_nickname;
}

public void setC2r_c2_nickname(String c2r_c2_nickname) {
	this.c2r_c2_nickname = c2r_c2_nickname;
}

public Date getC22r_date() {
	return c2r_date;
}

public void setC22r_date(Date c22r_date) {
	this.c2r_date = c22r_date;
}



}
