package com.fp.pi.products;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
	private List<Product> products;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	@XmlElement
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
