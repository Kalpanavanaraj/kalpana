package com.virtusa.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.dao.CartDao;
import com.virtusa.pojo.Cart;
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void saveCart(Cart cart) {
		
	}

	
	

}
