package com.fp.pi.products;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
	private List<Product> pproducts;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(List<Product> pproducts) {
		super();
		this.pproducts = pproducts;
	}

	public List<Product> getPproducts() {
		return pproducts;
	}

	@XmlElement
	public void setPproducts(List<Product> pproducts) {
		this.pproducts = pproducts;
	}

	
}
