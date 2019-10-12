package com.niit.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.dao.ProductDao;
import com.niit.pojo.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public void addProduct(Product product) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		product.setPdate(new Date());
		session.saveOrUpdate(product);
		transaction.commit();
		session.close();

	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		Product a1=new Product();
	 a1= session.get(Product.class, id);
	 transaction.commit();
		session.close();
 return a1;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session = sessionFactory.openSession();
		  List<Product> b1= session.createQuery( "from Product",Product.class).list() ;  
		  session.close();
		  return b1;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.delete(getProductById(id));
		transaction.commit();
		session.close();
	}

	@Override
	public List<Product> getMenProduct(){
		Session session = sessionFactory.openSession();
		String field="men";
		  List<Product> b1= session.createQuery( "FROM Product product WHERE product.field = '"+field+"' ",Product.class).list() ;  
		  session.close();
		  return b1;
		}
	public List<Product> getWomenProduct() {
		Session session = sessionFactory.openSession();
		String field="women";
				  List<Product> b1= session.createQuery( "FROM Product product WHERE product.field = '"+field+"' ",Product.class).list() ;  
		  session.close();
		  return b1;
	}
	public List<Product> getKidsProduct() {
		Session session = sessionFactory.openSession();
		String field="kids";
				  List<Product> b1= session.createQuery( "FROM Product product WHERE product.field = '"+field+"' ",Product.class).list() ;  
		  session.close();
		  return b1;
	}
}
