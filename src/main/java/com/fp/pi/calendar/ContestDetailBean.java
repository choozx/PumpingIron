package com.fp.pi.calendar;

public class ContestDetailBean {
	
	private int ccd_no;
	private String ccd_title;
	private String ccd_img;
	private String ccd_text;

	
	public ContestDetailBean() {
		// TODO Auto-generated constructor stub
	}


	public ContestDetailBean(int ccd_no, String ccd_title, String ccd_img, String ccd_text) {
		super();
		this.ccd_no = ccd_no;
		this.ccd_title = ccd_title;
		this.ccd_img = ccd_img;
		this.ccd_text = ccd_text;
	}


	public int getCcd_no() {
		return ccd_no;
	}


	public void setCcd_no(int ccd_no) {
		this.ccd_no = ccd_no;
	}
	
	
	public String getCcd_title() {
		return ccd_title;
	}


	public void setCcd_title(String ccd_title) {
		this.ccd_title = ccd_title;
	}


	public String getCcd_img() {
		return ccd_img;
	}


	public void setCcd_img(String ccd_img) {
		this.ccd_img = ccd_img;
	}


	public String getCcd_text() {
		return ccd_text;
	}


	public void setCcd_text(String ccd_text) {
		this.ccd_text = ccd_text;
	}
	
	
}
