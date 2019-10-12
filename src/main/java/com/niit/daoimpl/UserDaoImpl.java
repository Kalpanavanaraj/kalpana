package com.niit.daoimpl;

import java.security.Principal;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDao;
import com.niit.pojo.Cart;
import com.niit.pojo.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();

		session.persist(user);
		transaction.commit();
		session.close();

	}
	public void updateUser(User user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();

		session.saveOrUpdate(user);
		transaction.commit();
		session.close();

	}
	
	@Override 
	public User getUserById( int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		User a1=new User();
	 a1= session.get(User.class, id);
	 transaction.commit();
		session.close();
 return a1;
		
		
		
		
	}

	@Override
	public List<User> getAllUser() {
		Session session = sessionFactory.openSession();
		  List<User> b1= session.createQuery( "from User",User.class).list() ;  
		  session.close();
		  return b1;
		
		  

	}
	@Override
	public void deleteUser( int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		
		session.delete(getUserById(id));
		transaction.commit();
		session.close();

		

	}
	@Override
	public User getUserByName(String name) {
		Session session = sessionFactory.openSession();
		  User user= session.createQuery( "from User where username='"+name+"'",User.class).getSingleResult() ;  
		  session.close();
		  return user;
		
	}
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();

		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
	}
	
		
		
	}
	

