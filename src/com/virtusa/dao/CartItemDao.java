package com.virtusa.dao;

import java.util.List;

import com.virtusa.pojo.CartItem;

public interface CartItemDao {
	public void deleteCartItem(int id);
	//public CartItem getCartItemByProductId(int id,int cartid);
	public List<CartItem> getAllcartitem();
	public CartItem	 getCartitemById(int id);
	public void update(CartItem cartitem);

	
}
