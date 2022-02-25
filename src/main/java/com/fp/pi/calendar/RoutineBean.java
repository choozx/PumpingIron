package com.fp.pi.calendar;

import java.math.BigDecimal;
import java.util.Date;

public class RoutineBean {

	private BigDecimal cr_no;
	private String cr_id;
	private String cr_text;
	private Date cr_date;
	
	public RoutineBean() {
		// TODO Auto-generated constructor stub
	}

	public RoutineBean(BigDecimal cr_no, String cr_id, String cr_text, Date cr_date) {
		super();
		this.cr_no = cr_no;
		this.cr_id = cr_id;
		this.cr_text = cr_text;
		this.cr_date = cr_date;
	}

	public BigDecimal getCr_no() {
		return cr_no;
	}

	public void setCr_no(BigDecimal cr_no) {
		this.cr_no = cr_no;
	}

	public String getCr_id() {
		return cr_id;
	}

	public void setCr_id(String cr_id) {
		this.cr_id = cr_id;
	}

	public String getCr_text() {
		return cr_text;
	}

	public void setCr_text(String cr_text) {
		this.cr_text = cr_text;
	}

	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}
	
	
	
	
}
