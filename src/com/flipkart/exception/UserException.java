// Used to handle to the exceptions.

package com.flipkart.exception;

import org.apache.log4j.Logger;

public class UserException extends Exception {
	
private static Logger logger = Logger.getLogger(UserException.class);

public String viewLog() {
	return "Error has occured";
}

}
