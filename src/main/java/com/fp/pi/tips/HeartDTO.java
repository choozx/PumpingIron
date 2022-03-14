package com.fp.pi.tips;

public class HeartDTO {
	private int h_no;
	private int h_cr_no;
	private String h_m_email;
	
	public HeartDTO() {
		// TODO Auto-generated constructor stub
	}

	public HeartDTO(int h_no, int h_cr_no, String h_m_email) {
		super();
		this.h_no = h_no;
		this.h_cr_no = h_cr_no;
		this.h_m_email = h_m_email;
	}

	public int getH_no() {
		return h_no;
	}

	public void setH_no(int h_no) {
		this.h_no = h_no;
	}

	public int getH_cr_no() {
		return h_cr_no;
	}

	public void setH_cr_no(int h_cr_no) {
		this.h_cr_no = h_cr_no;
	}

	public String getH_m_email() {
		return h_m_email;
	}

	public void setH_m_email(String h_m_email) {
		this.h_m_email = h_m_email;
	}
	

}
