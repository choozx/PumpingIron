package com.fp.pi.tips;

import java.math.BigDecimal;

public class Selector {

	
	private String search; // 검색어
	private BigDecimal start; 
	private BigDecimal end;
	
	public Selector() {
		// TODO Auto-generated constructor stub
	}

	public Selector(String search, BigDecimal start, BigDecimal end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
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
