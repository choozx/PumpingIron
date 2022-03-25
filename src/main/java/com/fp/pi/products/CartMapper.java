package com.fp.pi.products;

import java.util.List;

public interface CartMapper {

	public int cartCheck(Cart cart);

	public int addCart(Cart cart);

	public List<Product> getcart(Cart cart);

	public int delCartAll(Cart cart);

	public int delCart(Cart cart);

}
