package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;
import com.niit.pojo.Category;
@Repository

public class CategoryDaoimpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	
	public void SaveCategory(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.saveOrUpdate(category);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Category> getAllCategory() {
		Session session = sessionFactory.openSession();
		  List<Category> b1= session.createQuery( "from Category",Category.class).list() ;  
		  session.close();
		  return b1;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		Category a1=new Category();
	 a1= session.get(Category.class, id);
	 transaction.commit();
		session.close();
 return a1;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.delete(getCategoryById(id));
		transaction.commit();
		session.close();
		
	}

}
