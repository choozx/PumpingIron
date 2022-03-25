package com.fp.pi.point;


public class PointBean {

	private int p_num;
	private String p_email;
	private int p_no;
	private int p_check;
	private String p_type;
	
	public PointBean() {
		// TODO Auto-generated constructor stub
	}

	public PointBean(int p_num, String p_email, int p_no, int p_check, String p_type) {
		super();
		this.p_num = p_num;
		this.p_email = p_email;
		this.p_no = p_no;
		this.p_check = p_check;
		this.p_type = p_type;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getP_check() {
		return p_check;
	}

	public void setP_check(int p_check) {
		this.p_check = p_check;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	
	
		
}
