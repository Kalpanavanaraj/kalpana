package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDao;
import com.niit.pojo.Cart;
import com.niit.pojo.CartItem;
import com.niit.pojo.Category;
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Cart getCartById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		Cart a1=new Cart();
	 a1= session.get(Cart.class, id);
	 transaction.commit();
		session.close();
 return a1;
		
		
		
	}

	@Override
	public void saveCart(Cart cart) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.saveOrUpdate(cart);
		transaction.commit();
		session.close();
		
	}

	@Override
	public List<Cart> getCartByUsername(String username) {
		Session session = sessionFactory.openSession();
		  List<Cart> b1= session.createQuery( "from Cart where username= :username",Cart.class).list() ;  
		  session.close();
		  return b1;
	
	}

	@Override
	public Cart getGrandTotal() {
		Session session = sessionFactory.openSession();
		//Transaction transaction = (Transaction)session.beginTransaction();
	    
		Cart a= session.createQuery( "from Cart",Cart.class).getSingleResult();
		session.close();
		return a;
	}

	

}
