package com.virtusa.dao;

import java.util.List;

import com.virtusa.pojo.Category;

public interface CategoryDao {
	//public void addCategory(Category category);
	public void SaveCategory(Category category);
	public List<Category> getAllCategory();
	public Category getCategoryById(int id);
	public void deleteProduct(int id);
}
