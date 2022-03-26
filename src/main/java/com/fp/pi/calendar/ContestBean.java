package com.fp.pi.calendar;

public class ContestBean {
	
	private int cc_no;
	private String cc_text;
	private String cc_startDate;
	private String cc_endDate;
	
	public ContestBean() {
		// TODO Auto-generated constructor stub
	}

	public ContestBean(int cc_no, String cc_text, String cc_startDate, String cc_endDate) {
		super();
		this.cc_no = cc_no;
		this.cc_text = cc_text;
		this.cc_startDate = cc_startDate;
		this.cc_endDate = cc_endDate;
	}

	public int getCc_no() {
		return cc_no;
	}

	public void setCc_no(int cc_no) {
		this.cc_no = cc_no;
	}

	public String getCc_text() {
		return cc_text;
	}

	public void setCc_text(String cc_text) {
		this.cc_text = cc_text;
	}

	public String getCc_startDate() {
		return cc_startDate;
	}

	public void setCc_startDate(String cc_startDate) {
		this.cc_startDate = cc_startDate;
	}

	public String getCc_endDate() {
		return cc_endDate;
	}

	public void setCc_endDate(String cc_endDate) {
		this.cc_endDate = cc_endDate;
	}

	
	
	
}
