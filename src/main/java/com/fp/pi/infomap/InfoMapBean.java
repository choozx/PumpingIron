package com.fp.pi.infomap;

import java.math.BigDecimal;

public class InfoMapBean {
	
	private BigDecimal pi_no;
	private String pi_name;
	private String pi_loc;
	private String pi_price;
	private String pi_partner;
	private String pi_img;
	
	public InfoMapBean() {
		// TODO Auto-generated constructor stub
	}

	public InfoMapBean(BigDecimal pi_no, String pi_name, String pi_loc, String pi_price, String pi_partner,
			String pi_img) {
		super();
		this.pi_no = pi_no;
		this.pi_name = pi_name;
		this.pi_loc = pi_loc;
		this.pi_price = pi_price;
		this.pi_partner = pi_partner;
		this.pi_img = pi_img;
	}

	public BigDecimal getPi_no() {
		return pi_no;
	}

	public void setPi_no(BigDecimal pi_no) {
		this.pi_no = pi_no;
	}

	public String getPi_name() {
		return pi_name;
	}

	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}

	public String getPi_loc() {
		return pi_loc;
	}

	public void setPi_loc(String pi_loc) {
		this.pi_loc = pi_loc;
	}

	public String getPi_price() {
		return pi_price;
	}

	public void setPi_price(String pi_price) {
		this.pi_price = pi_price;
	}

	public String getPi_partner() {
		return pi_partner;
	}

	public void setPi_partner(String pi_partner) {
		this.pi_partner = pi_partner;
	}

	public String getPi_img() {
		return pi_img;
	}

	public void setPi_img(String pi_img) {
		this.pi_img = pi_img;
	}
	

}
