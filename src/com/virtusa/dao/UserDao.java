package com.virtusa.dao;

import java.util.List;

import com.virtusa.pojo.Address;
import com.virtusa.pojo.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	
	public User getUserById(int id);
	public List<User> getAllUser();
	public void deleteUser(int id);
	public User getUserByName(String name);
	public void saveUser(User user);
	public Address getAddressById(int id); 
	

}
