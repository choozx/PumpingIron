package com.fp.pi.customerservice;

import java.util.Date;

public class Request {
	private int r_no;
	private String r_title;
	private String r_content;
	private Date r_date;
	private String r_to;
	private String r_from;
	private String r_answercheck;
	private String r_photo;
	
	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Request(int r_no, String r_title, String r_content, Date r_date, String r_to, String r_from,
			String r_answercheck, String r_photo) {
		super();
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_date = r_date;
		this.r_to = r_to;
		this.r_from = r_from;
		this.r_answercheck = r_answercheck;
		this.r_photo = r_photo;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getR_to() {
		return r_to;
	}

	public void setR_to(String r_to) {
		this.r_to = r_to;
	}

	public String getR_from() {
		return r_from;
	}

	public void setR_from(String r_from) {
		this.r_from = r_from;
	}

	public String getR_answercheck() {
		return r_answercheck;
	}

	public void setR_answercheck(String r_answercheck) {
		this.r_answercheck = r_answercheck;
	}

	public String getR_photo() {
		return r_photo;
	}

	public void setR_photo(String r_photo) {
		this.r_photo = r_photo;
	}
	
	
}
