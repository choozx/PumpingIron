package com.fp.pi.customerservice;

import java.math.BigDecimal;

public class CustomerServiceSelector {

	private String m_email;
	private String search; // 검색어
	private BigDecimal start; 
	private BigDecimal end;
	
	public CustomerServiceSelector() {
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceSelector(String m_email, String search, BigDecimal start, BigDecimal end) {
		super();
		this.m_email = m_email;
		this.search = search;
		this.start = start;
		this.end = end;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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
