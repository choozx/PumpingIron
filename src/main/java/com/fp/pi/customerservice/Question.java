package com.fp.pi.customerservice;

import java.util.Date;

public class Question {
	private int q_no;
	private String q_title;
	private String q_content;
	private Date q_date;
	private String q_type;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int q_no, String q_title, String q_content, Date q_date, String q_type) {
		super();
		this.q_no = q_no;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.q_type = q_type;
	}

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public String getQ_type() {
		return q_type;
	}

	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	
	
	
}
