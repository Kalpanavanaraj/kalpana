package com.niit.dao;

import java.util.List;

import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.Product;
import com.niit.pojo.User;

public interface CartItemDao {
	public void deleteCartItem(int id);
	//public CartItem getCartItemByProductId(int id,int cartid);
	public List<CartItem> getAllcartitem();
	public CartItem	 getCartitemById(int id);
	public void update(CartItem cartitem);

	
}
