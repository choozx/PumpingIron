package com.fp.pi.products;

public class ProductSort {
	private String p_sort;
	private String p_type;
	private String order;
	
	public ProductSort() {
		// TODO Auto-generated constructor stub
	}

	public ProductSort(String p_sort, String p_type, String order) {
		super();
		this.p_sort = p_sort;
		this.p_type = p_type;
		this.order = order;
	}

	public String getP_sort() {
		return p_sort;
	}

	public void setP_sort(String p_sort) {
		this.p_sort = p_sort;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
}
