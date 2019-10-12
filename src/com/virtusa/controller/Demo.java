package com.virtusa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.dao.CartDao;
import com.virtusa.dao.UserDao;

@Component("demoHandler")
public class Demo {
	@Autowired
	UserDao us;
	@Autowired
	CartDao cs;
	
	@Autowired
	HttpServletRequest request;
	public void initFlow(){
		
	
	}
	
}
