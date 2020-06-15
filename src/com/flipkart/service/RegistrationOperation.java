package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegisterationDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;

public class RegistrationOperation implements RegistrationInterface {

	private static Logger logger = Logger.getLogger(RegistrationOperation.class);
	@Override
	public void completeRegistration(int userId) {
     
		RegistrationDao registrationDao = new RegistrationDaoImpl();
		registrationDao.doRegistration(userId);
		logger.info("Welcome to the University  "+ userId);
	}

}
