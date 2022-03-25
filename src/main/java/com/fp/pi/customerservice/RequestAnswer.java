package com.fp.pi.customerservice;

import java.util.Date;

public class RequestAnswer {
	private int ra_no;
	private String ra_title;
	private String ra_content;
	private Date ra_date;
	private String ra_to;
	private String ra_from;
	private String ra_photo;
	
	public RequestAnswer() {
		// TODO Auto-generated constructor stub
	}

	public RequestAnswer(int ra_no, String ra_title, String ra_content, Date ra_date, String ra_to, String ra_from,
			String ra_photo) {
		super();
		this.ra_no = ra_no;
		this.ra_title = ra_title;
		this.ra_content = ra_content;
		this.ra_date = ra_date;
		this.ra_to = ra_to;
		this.ra_from = ra_from;
		this.ra_photo = ra_photo;
	}

	public int getRa_no() {
		return ra_no;
	}

	public void setRa_no(int ra_no) {
		this.ra_no = ra_no;
	}

	public String getRa_title() {
		return ra_title;
	}

	public void setRa_title(String ra_title) {
		this.ra_title = ra_title;
	}

	public String getRa_content() {
		return ra_content;
	}

	public void setRa_content(String ra_content) {
		this.ra_content = ra_content;
	}

	public Date getRa_date() {
		return ra_date;
	}

	public void setRa_date(Date ra_date) {
		this.ra_date = ra_date;
	}

	public String getRa_to() {
		return ra_to;
	}

	public void setRa_to(String ra_to) {
		this.ra_to = ra_to;
	}

	public String getRa_from() {
		return ra_from;
	}

	public void setRa_from(String ra_from) {
		this.ra_from = ra_from;
	}

	public String getRa_photo() {
		return ra_photo;
	}

	public void setRa_photo(String ra_photo) {
		this.ra_photo = ra_photo;
	}

	

	
	
	
}
