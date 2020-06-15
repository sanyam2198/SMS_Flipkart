package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Registration;
import com.flipkart.utils.DBUtil;


public class RegistrationDaoImpl implements RegistrationDao {
	
	private static Logger logger = Logger.getLogger(RegistrationDaoImpl.class);
	
	public void doRegistration(int userId) {
		Registration registration = new Registration();
		
		  Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql = "insert into registration values(?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				Scanner sc = new Scanner(System.in);
				logger.info("Enter Registration Id");
				int registrationId = sc.nextInt();
				
				stmt.setInt(1,registrationId);
				
				logger.info("Enter the payment Id");
				int paymentId = sc.nextInt();
				stmt.setInt(2,paymentId);
				
				stmt.setInt(3,userId);
				stmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				
				int s= stmt.executeUpdate();
				logger.info(userId+": Registered Successfully with registrationId "  );
			}
				
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
	}

}
