/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.User;

/**
 * @author RAJIV SOOD
 *
 */
public interface UserInterface {
	
	public String checkIdentity (User user);
	public void registerUser (User user);

}
