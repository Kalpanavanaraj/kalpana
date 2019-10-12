package com.niit.dao;

import java.util.List;

import com.niit.pojo.Category;

public interface CategoryDao {
	//public void addCategory(Category category);
	public void SaveCategory(Category category);
	public List<Category> getAllCategory();
	public Category getCategoryById(int id);
	public void deleteProduct(int id);
}
