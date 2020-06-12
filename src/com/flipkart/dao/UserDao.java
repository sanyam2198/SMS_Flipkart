package com.flipkart.dao;

import com.flipkart.bean.User;

public interface UserDao {
	
	public String checkIdentity(User user);
	public void registerUser(User user);

}
