package com.fp.pi.customerservice;

import java.util.Date;

public class Inquiry {
	private int i_no;
	private String i_title;
	private String i_content;
	private Date i_date;
	private String i_type;
	private String i_to;
	private String i_from;
	private String i_answercheck;
	private String i_photo;
	
	public Inquiry() {
		// TODO Auto-generated constructor stub
	}

	public Inquiry(int i_no, String i_title, String i_content, Date i_date, String i_type, String i_to, String i_from,
			String i_answercheck, String i_photo) {
		super();
		this.i_no = i_no;
		this.i_title = i_title;
		this.i_content = i_content;
		this.i_date = i_date;
		this.i_type = i_type;
		this.i_to = i_to;
		this.i_from = i_from;
		this.i_answercheck = i_answercheck;
		this.i_photo = i_photo;
	}

	public int getI_no() {
		return i_no;
	}

	public void setI_no(int i_no) {
		this.i_no = i_no;
	}

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_content() {
		return i_content;
	}

	public void setI_content(String i_content) {
		this.i_content = i_content;
	}

	public Date getI_date() {
		return i_date;
	}

	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}

	public String getI_type() {
		return i_type;
	}

	public void setI_type(String i_type) {
		this.i_type = i_type;
	}

	public String getI_to() {
		return i_to;
	}

	public void setI_to(String i_to) {
		this.i_to = i_to;
	}

	public String getI_from() {
		return i_from;
	}

	public void setI_from(String i_from) {
		this.i_from = i_from;
	}

	public String getI_answercheck() {
		return i_answercheck;
	}

	public void setI_answercheck(String i_answercheck) {
		this.i_answercheck = i_answercheck;
	}

	public String getI_photo() {
		return i_photo;
	}

	public void setI_photo(String i_photo) {
		this.i_photo = i_photo;
	}


	
}
