package com.fp.pi.customerservice;

import java.util.Date;

public class Event {
	private int e_no;
	private String e_title;
	private String e_content;
	private Date e_date;
	private String e_type;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(int e_no, String e_title, String e_content, Date e_date, String e_type) {
		super();
		this.e_no = e_no;
		this.e_title = e_title;
		this.e_content = e_content;
		this.e_date = e_date;
		this.e_type = e_type;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_title() {
		return e_title;
	}

	public void setE_title(String e_title) {
		this.e_title = e_title;
	}

	public String getE_content() {
		return e_content;
	}

	public void setE_content(String e_content) {
		this.e_content = e_content;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public String getE_type() {
		return e_type;
	}

	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	
	
	
	
	
	
}
