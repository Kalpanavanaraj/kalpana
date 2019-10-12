package com.niit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.Product;
import com.niit.pojo.User;

@Controller
public class CartController {
	@Autowired
	UserDao us;
	@Autowired
	ProductDao ps;
	@Autowired
	CartDao cs;
	@Autowired
	CartItemDao cd;
	

	@RequestMapping("/cartitem")
	public String Page(Model model, Cart cart, Principal principal) {

		User user = us.getUserByName(principal.getName());
		cart = user.getCart();

		model.addAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping("/deleteitem/{id}")
	public String deleteCart(@PathVariable int id, Principal principal) {
		System.out.println("------inside delete st------");
		CartItem cartitem = cd.getCartitemById(id);
		
		User user = us.getUserByName(principal.getName());
		Cart cart = user.getCart();
		System.out.println(cart);
		//cart.setGrandTotal(cart.getGrandTotal() - cartitem.getSubTotalCost());
		System.out.println("-------after----");
		

	
		
		
		System.out.println("--------- CartItems Before -----------");
		
		int count=0;
		for(CartItem car:cart.getCartitem())
		{
		
			if(car.getCartitemid()==cartitem.getCartitemid())
			{
				System.out.println("-----------found");
				break;
			}
			else{
				count++;
			}
		}
		
		List<CartItem> cartitem1 = cart.getCartitem();
		cartitem1.remove(count);
		
		
		System.out.println("--------- CartItems After -----------");
		
		cart.setCartitem(cartitem1);
		cart.setGrandTotal(cart.getGrandTotal() - cartitem.getSubTotalCost());
         cs.saveCart(cart);
		
		return "redirect:/cartitem";
		}

	

	@RequestMapping("/{id}/update")
	public String updatePage(@PathVariable int id, @RequestParam int count, CartItem cartitem, Principal principal) {
		System.out.println("------update page----------");
		cartitem=cd.getCartitemById(id);
		Product product = cartitem.getProduct();
		double oldtotal = cartitem.getSubTotalCost();
		if (product.getPquantity() <= count) {
			count = product.getPquantity();
		}
		cartitem.setSubQty(count);
		cartitem.setSubTotalCost(product.getPcost() * count);
	
	cd.update(cartitem);
		User user = us.getUserByName(principal.getName());
		Cart cart = user.getCart();
		
		cart.setGrandTotal(cart.getGrandTotal() - oldtotal + cartitem.getSubTotalCost());
		cs.saveCart(cart);
		return "redirect:/cartitem";
	}

	@RequestMapping("/acart/{id}")
	public String Cartpage(Principal principal, @PathVariable int id, Model model) throws NullPointerException {
		System.out.println("-----inside controller-----");
		User user = us.getUserByName(principal.getName());
		System.out.println(user.getFname());
		Product product = ps.getProductById(id);
		CartItem ci = new CartItem();
		Cart cart = null;

		List<CartItem> cl;
		if (user.getCart() == null) {
			System.out.println("---------user cart is null-------");
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);

			us.saveUser(user);
			System.out.println("------successfully registered------");
		} else {
			System.out.println("-------Cart already present--------");
			cart = user.getCart();

		}
		try {
			cl = cart.getCartitem();
			if (cart.getCartitem().isEmpty()) {

				System.out.println("---------cartitem is empty-------------");
				ci.setProduct(product);
				ci.setSubTotalCost(product.getPcost());
				ci.setSubQty(1);
				
				cl.add(ci);
				cart.setCartitem(cl);
				cart.setGrandTotal(ci.getSubTotalCost());
				cart.setUser(user);
				cs.saveCart(cart);

				model.addAttribute("cart", cart);
				return "cart";

			}
			else{
			boolean found = false;
			for (CartItem c : cart.getCartitem()) {
				if (c.getProduct().getId() == id) {
					
					System.out.println("same item present");
					found = true;
					c.setSubQty(c.getSubQty() + 1);
					
					c.setSubTotalCost(c.getSubQty()*c.getProduct().getPcost());
					cart.setGrandTotal(cart.getGrandTotal()+c.getProduct().getPcost());
					

				}}
				
				if (!found) {
					System.out.println("new item is ready to purchase");
					CartItem c2 = new CartItem();
					c2.setProduct(product);
					c2.setSubQty(1);
					c2.setSubTotalCost(product.getPcost());
					cl.add(c2);
					cart.setCartitem(cl);
					cart.setGrandTotal(cart.getGrandTotal() + c2.getSubTotalCost());
					

				}
				cs.saveCart(cart);
				
			}
			

		} catch (Exception e) {
			e.getMessage();
		}

		model.addAttribute("cart", cart);
		return "cart";
	}
}
