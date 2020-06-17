package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.dao.CoursesDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;

public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);
	
	// Method used to complete the registration .
	@Override
	public void completeRegistration(int userId, int registrationId, int paymentId) {
     
		RegistrationDao registrationDao = new RegistrationDaoImpl();
		registrationDao.doRegistration(userId,registrationId, paymentId);
	}


}
