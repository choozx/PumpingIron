package com.fp.pi.customerservice;

import java.util.Date;

public class InquiryAnswer {
	private int ia_no;
	private String ia_title;
	private String ia_content;
	private Date ia_date;
	private String ia_type;
	private String ia_to;
	private String ia_from;
	private String ia_photo;
	
	public InquiryAnswer() {
		// TODO Auto-generated constructor stub
	}
	
	public InquiryAnswer(int ia_no, String ia_title, String ia_content, Date ia_date, String ia_type, String ia_to,
			String ia_from, String ia_photo) {
		super();
		this.ia_no = ia_no;
		this.ia_title = ia_title;
		this.ia_content = ia_content;
		this.ia_date = ia_date;
		this.ia_type = ia_type;
		this.ia_to = ia_to;
		this.ia_from = ia_from;
		this.ia_photo = ia_photo;
	}



	public int getIa_no() {
		return ia_no;
	}



	public void setIa_no(int ia_no) {
		this.ia_no = ia_no;
	}



	public String getIa_title() {
		return ia_title;
	}



	public void setIa_title(String ia_title) {
		this.ia_title = ia_title;
	}



	public String getIa_content() {
		return ia_content;
	}



	public void setIa_content(String ia_content) {
		this.ia_content = ia_content;
	}



	public Date getIa_date() {
		return ia_date;
	}



	public void setIa_date(Date ia_date) {
		this.ia_date = ia_date;
	}



	public String getIa_type() {
		return ia_type;
	}



	public void setIa_type(String ia_type) {
		this.ia_type = ia_type;
	}



	public String getIa_to() {
		return ia_to;
	}



	public void setIa_to(String ia_to) {
		this.ia_to = ia_to;
	}



	public String getIa_from() {
		return ia_from;
	}



	public void setIa_from(String ia_from) {
		this.ia_from = ia_from;
	}



	public String getIa_photo() {
		return ia_photo;
	}



	public void setIa_photo(String ia_photo) {
		this.ia_photo = ia_photo;
	}
	
	  
	
}
