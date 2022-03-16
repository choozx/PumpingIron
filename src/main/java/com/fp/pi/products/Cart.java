package com.fp.pi.products;

public class Cart {
	private int cart_no;
	private int m_no;
	private int p_no;
	private Product product;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_no, int m_no, int p_no, Product product) {
		super();
		this.cart_no = cart_no;
		this.m_no = m_no;
		this.p_no = p_no;
		this.product = product;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
