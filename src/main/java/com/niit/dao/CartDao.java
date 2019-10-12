package com.niit.dao;

import java.util.List;

import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.User;

public interface CartDao {
	 public Cart getCartById (int cartId);
	   
		   public void saveCart(Cart cart);
		   List<Cart> getCartByUsername (String username);

		public Cart getGrandTotal();

		

		

		
}
