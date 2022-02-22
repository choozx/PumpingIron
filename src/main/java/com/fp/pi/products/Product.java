package com.fp.pi.products;

public class Product {
	private int p_no;
	private String p_name;
	private String p_type;
	private int p_price;
	private String p_img;
	private int p_cnt;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int p_no, String p_name, String p_type, int p_price, String p_img, int p_cnt) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_type = p_type;
		this.p_price = p_price;
		this.p_img = p_img;
		this.p_cnt = p_cnt;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public int getP_cnt() {
		return p_cnt;
	}

	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}
	
	
}
