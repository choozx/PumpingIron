package com.fp.pi.member;

import java.util.Date;

public class Member {
	private String m_email;
	private String m_pw;
	private String m_phone;
	private String m_addr;
	private String m_name;
	private String m_photo;
	private int m_pay;
	private int m_point;
	private Date m_regdate;
	private String m_key;
	private String m_type;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_email, String m_pw, String m_phone, String m_addr, String m_name, String m_photo, int m_pay,
			int m_point, Date m_regdate, String m_key, String m_type) {
		super();
		this.m_email = m_email;
		this.m_pw = m_pw;
		this.m_phone = m_phone;
		this.m_addr = m_addr;
		this.m_name = m_name;
		this.m_photo = m_photo;
		this.m_pay = m_pay;
		this.m_point = m_point;
		this.m_regdate = m_regdate;
		this.m_key = m_key;
		this.m_type = m_type;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public int getM_pay() {
		return m_pay;
	}

	public void setM_pay(int m_pay) {
		this.m_pay = m_pay;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public Date getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}

	public String getM_key() {
		return m_key;
	}

	public void setM_key(String m_key) {
		this.m_key = m_key;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	
	
	
	
}
