package com.fp.pi.best;

import java.math.BigDecimal;

public class Selector4 {

	
	private String search; // 검색어
	private BigDecimal start; 
	private BigDecimal end;
	
	public Selector4() {
		// TODO Auto-generated constructor stub
	}

	public Selector4(String search, BigDecimal start, BigDecimal end) {
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
