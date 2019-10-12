package com.virtusa.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.dao.CartItemDao;
import com.virtusa.pojo.CartItem;
@Repository
public class CartItemDaoimpl implements CartItemDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void deleteCartItem(int id) {
		try{
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		session.delete(getCartitemById(id));
		transaction.commit();
		session.close();
		}
		catch(Exception e)
		{
			
		}

	}
	@Override
	public List<CartItem> getAllcartitem() {
		Session session = sessionFactory.openSession();
		  List<CartItem> b1= session.createQuery( "from CartItem",CartItem.class).list() ;  
		  session.close();
		  return b1;
	}
	@Override
	public CartItem getCartitemById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		CartItem a1=new CartItem();
	 a1= session.get(CartItem.class, id);
	 transaction.commit();
		session.close();
 return a1;
	}
	@Override
	public void update(CartItem cartitem) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.saveOrUpdate(cartitem);
		transaction.commit();
		session.close();
		
	}

	
	

}
