package com.flipkart.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

public class UserOperation implements UserInterface{
	
	private static Logger logger = Logger.getLogger(UserOperation.class);

	// Checking Identity.
	
	@Override
	public String checkIdentity (User user) throws LoginException  {
		
		String s="";
		
			UserDao userdao = new UserDaoImpl();
			 s= userdao.checkIdentity(user);
			 
		if(user.getUserId()==-1)
			throw new LoginException();
		
		return s;
		
	}


}
