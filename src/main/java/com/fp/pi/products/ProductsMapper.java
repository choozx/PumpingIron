package com.fp.pi.products;

import java.util.List;

public interface ProductsMapper {

	public List<Product> getProducts(String choose);

	public Product getProduct(Product p);
}
