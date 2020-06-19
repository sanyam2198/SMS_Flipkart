/**
 * 
 */

// Interface class for the operation that can be done by the user.
package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.exception.LoginException;

/**
 * @author RAJIV SOOD
 *
 */
public interface UserInterface {
	
	public String checkIdentity (User user) throws LoginException ;
	//public void registerUser (User user);

}
