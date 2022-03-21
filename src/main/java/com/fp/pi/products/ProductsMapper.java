package com.fp.pi.products;

import java.util.List;

public interface ProductsMapper {

	public List<Product> getProducts(ProductSort ps);

	public Product getProduct(Product p);

	public int increaseBuyCount(Product p);

	public List<Product> getProductSort(ProductSort ps);

	public int regProduct(Product p);

	public int delProduct(String p_no);

	public int updateProduct(Product p);

	public int getproductcount(String type);
}
