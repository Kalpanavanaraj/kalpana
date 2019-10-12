package com.niit.dao;

import java.util.List;

import com.niit.pojo.Product;



public interface ProductDao {
public void addProduct(Product product);
	
	public Product getProductById(int id);
	public List<Product> getAllProduct();
	public void deleteProduct(int id);
	public List<Product> getMenProduct();
	public List<Product> getWomenProduct();
	public List<Product> getKidsProduct();
	

}
