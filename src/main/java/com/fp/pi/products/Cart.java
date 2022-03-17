package com.fp.pi.products;

public class Cart {
	private int cart_no;
	private String m_email;
	private int p_no;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_no, String m_email, int p_no, Product product) {
		super();
		this.cart_no = cart_no;
		this.m_email = m_email;
		this.p_no = p_no;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	
	
}
