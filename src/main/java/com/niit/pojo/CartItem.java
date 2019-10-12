package com.niit.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity

public class CartItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6374961882603315434L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cartitemid;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;
	private int subQty;
	private int subTotalCost;
	

	public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSubQty() {
		return subQty;
	}

	public void setSubQty(int subQty) {
		this.subQty = subQty;
	}

	public int getSubTotalCost() {
		return subTotalCost;
	}

	public void setSubTotalCost(int subTotalCost) {
		this.subTotalCost = subTotalCost;
	}

	@Override
	public String toString() {
		return "CartItem [cartitemid=" + cartitemid + ", product=" + product + ", subQty=" + subQty + ", subTotalCost="
				+ subTotalCost + "]";
	}

}
