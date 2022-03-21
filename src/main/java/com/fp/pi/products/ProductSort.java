package com.fp.pi.products;

import java.math.BigDecimal;

public class ProductSort {
	private String p_sort;
	private String p_type;
	private String order;
	private BigDecimal pageNo; 
	private BigDecimal start; 
	private BigDecimal end;
	
	public ProductSort() {
		// TODO Auto-generated constructor stub
	}

	public ProductSort(String p_sort, String p_type, String order, BigDecimal pageNo, BigDecimal start,
			BigDecimal end) {
		super();
		this.p_sort = p_sort;
		this.p_type = p_type;
		this.order = order;
		this.pageNo = pageNo;
		this.start = start;
		this.end = end;
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

	public BigDecimal getPageNo() {
		return pageNo;
	}

	public void setPageNo(BigDecimal pageNo) {
		this.pageNo = pageNo;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	
	
}
