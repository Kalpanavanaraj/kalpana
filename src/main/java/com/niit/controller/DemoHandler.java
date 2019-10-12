package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.dao.CartDao;
import com.niit.dao.UserDao;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.User;

@Component("demoHandler")
public class DemoHandler {
	@Autowired
	UserDao us;
	@Autowired
	CartDao cs;
	
	@Autowired
	HttpServletRequest request;
	public User initFlow(){
		Principal principal = request.getUserPrincipal();
		User user=new User();
		user = us.getUserByName(principal.getName());
		Cart cart = user.getCart();
		System.out.println("-----reached demo handler----");
		List<CartItem> cartitem1 = cart.getCartitem();
		
		cartitem1.removeAll(cartitem1);
		cart.setCartitem(cartitem1);
		cart.setGrandTotal(0.0);
		cs.saveCart(cart);
		
		return user;
	}
	
}
