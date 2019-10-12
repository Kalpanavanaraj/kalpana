package com.virtusa.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.dao.UserDao;
import com.virtusa.pojo.Address;
import com.virtusa.pojo.User;

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
		//User a = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		//a= 
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
	@Override
	public Address getAddressById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction)session.beginTransaction();
		Address a1=new Address();
	 a1= session.get(Address.class, id);
	 transaction.commit();
		session.close();
 return a1;
	}
	
		
		
	}
	

